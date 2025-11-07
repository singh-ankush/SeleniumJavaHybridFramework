package com.selenium.util;

import com.selenium.base.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import java.time.Duration;
import java.time.Instant;

public class SikuliHelper extends TestBase {

    static Logger logger = Logger.getLogger(SikuliHelper.class.getName());

    private static final Screen screen = new Screen();
    private static final int POLLING_INTERVAL_MS = 500;

    // Reads timeout from properties file
    private int timeoutValue() {
        int timeout = 10; // default fallback
        try {
            timeout = Integer.parseInt(prop.getProperty("Timeout"));
        } catch (Exception ex) {
            logger.error("Exception while reading timeout value from config: " + ex.getMessage());
        }
        return timeout;
    }

    /**
     * Waits for an image (element) to appear on the screen within timeout.
     */
    public boolean waitForElementToAppear(String imagePath) {
        Pattern pattern = new Pattern(imagePath);
        Instant endTime = Instant.now().plus(Duration.ofSeconds(timeoutValue()));
        try {
            while (Instant.now().isBefore(endTime)) {
                Match match = screen.exists(pattern, 0);
                if (match != null) {
                    logger.info("Element appeared: " + imagePath);
                    return true;
                }
                Thread.sleep(POLLING_INTERVAL_MS);
            }
        } catch (Exception e) {
            logger.error("Error while waiting for element to appear: " + e.getMessage());
        }
        logger.error("Element did not appear within timeout: " + imagePath);
        return false;
    }

    /**
     * Waits for an image (element) to disappear from the screen within timeout.
     */
    public boolean waitForElementToDisappear(String imagePath) {
        Pattern pattern = new Pattern(imagePath);
        Instant endTime = Instant.now().plus(Duration.ofSeconds(timeoutValue()));
        try {
            while (Instant.now().isBefore(endTime)) {
                Match match = screen.exists(pattern, 0);
                if (match == null) {
                    logger.info("Element disappeared: " + imagePath);
                    return true;
                }
                Thread.sleep(POLLING_INTERVAL_MS);
            }
        } catch (Exception e) {
            logger.error("Error while waiting for element to disappear: " + e.getMessage());
        }
        logger.error("Element did not disappear within timeout: " + imagePath);
        return false;
    }

    /**
     * Clicks on an image-based element.
     */
    public void clickImage(String imagePath) {
        try {
            if (waitForElementToAppear(imagePath)) {
                screen.click(new Pattern(imagePath));
                logger.info("Clicked on image: " + imagePath);
            } else {
                throw new NoSuchElementException("Image not found for click: " + imagePath);
            }
        } catch (Exception e) {
            logger.error("Exception while clicking image: " + imagePath + " - " + e.getMessage());
        }
    }

    /**
     * Types text into an image-based input field.
     */
    public void typeText(String imagePath, String text) {
        try {
            if (waitForElementToAppear(imagePath)) {
                screen.type(new Pattern(imagePath), text);
                logger.info("Typed text into image field: " + imagePath);
            } else {
                throw new NoSuchElementException("Image not found for typing: " + imagePath);
            }
        } catch (Exception e) {
            logger.error("Exception while typing into image field: " + imagePath + " - " + e.getMessage());
        }
    }

    /**
     * Checks if an image is currently present on the screen.
     */
    public boolean isImagePresent(String imagePath) {
        try {
            Match match = screen.exists(new Pattern(imagePath), 0);
            if (match != null) {
                logger.info("Image is present: " + imagePath);
                return true;
            }
        } catch (Exception e) {
            logger.error("Error checking image presence: " + imagePath + " - " + e.getMessage());
        }
        logger.warn("Image not present: " + imagePath);
        return false;
    }

    /**
     * Drags an image-based element and drops it on another.
     */
    public void dragAndDropImage(String sourceImagePath, String targetImagePath) {
        try {
            if (waitForElementToAppear(sourceImagePath) && waitForElementToAppear(targetImagePath)) {
                screen.drag(new Pattern(sourceImagePath));
                screen.dropAt(new Pattern(targetImagePath));
                logger.info("Dragged from " + sourceImagePath + " to " + targetImagePath);
            } else {
                throw new NoSuchElementException("Source or target image not found");
            }
        } catch (Exception e) {
            logger.error("Exception during drag and drop: " + e.getMessage());
        }
    }

}
