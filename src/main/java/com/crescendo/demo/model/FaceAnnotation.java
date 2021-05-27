package com.crescendo.demo.model;

import java.util.List;

public class FaceAnnotation {

    private BoundingPoly boundingPoly;
    private FBoundingPoly fboundingPoly;
    private List<Landmark> landmarks;
    private double rollAngle;
    private double panAngle;
    private double tiltAngle;
    private double detectionConfidence;
    private double landmarkingConfidence;
    private String joyLikelihood;
    private String sorrowLikelihood;
    private String angerLikelihood;
    private String surpriseLikelihood;
    private String underExposedLikelihood;
    private String blurredLikelihood;
    private String headwearLikelihood;

    public BoundingPoly getBoundingPoly() {
        return boundingPoly;
    }

    public void setBoundingPoly(BoundingPoly boundingPoly) {
        this.boundingPoly = boundingPoly;
    }

    public double getRollAngle() {
        return rollAngle;
    }

    public void setRollAngle(double rollAngle) {
        this.rollAngle = rollAngle;
    }

    public double getPanAngle() {
        return panAngle;
    }

    public void setPanAngle(double panAngle) {
        this.panAngle = panAngle;
    }

    public double getTiltAngle() {
        return tiltAngle;
    }

    public void setTiltAngle(double tiltAngle) {
        this.tiltAngle = tiltAngle;
    }

    public double getDetectionConfidence() {
        return detectionConfidence;
    }

    public void setDetectionConfidence(double detectionConfidence) {
        this.detectionConfidence = detectionConfidence;
    }

    public double getLandmarkingConfidence() {
        return landmarkingConfidence;
    }

    public void setLandmarkingConfidence(double landmarkingConfidence) {
        this.landmarkingConfidence = landmarkingConfidence;
    }

    public String getJoyLikelihood() {
        return joyLikelihood;
    }

    public void setJoyLikelihood(String joyLikelihood) {
        this.joyLikelihood = joyLikelihood;
    }

    public String getSorrowLikelihood() {
        return sorrowLikelihood;
    }

    public void setSorrowLikelihood(String sorrowLikelihood) {
        this.sorrowLikelihood = sorrowLikelihood;
    }

    public String getAngerLikelihood() {
        return angerLikelihood;
    }

    public void setAngerLikelihood(String angerLikelihood) {
        this.angerLikelihood = angerLikelihood;
    }

    public String getSurpriseLikelihood() {
        return surpriseLikelihood;
    }

    public void setSurpriseLikelihood(String surpriseLikelihood) {
        this.surpriseLikelihood = surpriseLikelihood;
    }

    public String getUnderExposedLikelihood() {
        return underExposedLikelihood;
    }

    public void setUnderExposedLikelihood(String underExposedLikelihood) {
        this.underExposedLikelihood = underExposedLikelihood;
    }

    public String getBlurredLikelihood() {
        return blurredLikelihood;
    }

    public void setBlurredLikelihood(String blurredLikelihood) {
        this.blurredLikelihood = blurredLikelihood;
    }

    public String getHeadwearLikelihood() {
        return headwearLikelihood;
    }

    public void setHeadwearLikelihood(String headwearLikelihood) {
        this.headwearLikelihood = headwearLikelihood;
    }

    public FBoundingPoly getFboundingPoly() {
        return fboundingPoly;
    }

    public void setFboundingPoly(FBoundingPoly fboundingPoly) {
        this.fboundingPoly = fboundingPoly;
    }

    public List<Landmark> getLandmarksList() {
        return landmarks;
    }

    public void setLandmarksList(List<Landmark> landmarksList) {
        this.landmarks = landmarksList;
    }
}
