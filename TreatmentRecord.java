package model;

public class TreatmentRecord {
    private int patientId;
    private String patientName;
    private String doctorAssigned;
    private String treatmentDetails;
    private String completionTime;

    public TreatmentRecord(int patientId, String patientName, String doctorAssigned, String treatmentDetails, String completionTime) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.doctorAssigned = doctorAssigned;
        this.treatmentDetails = treatmentDetails;
        this.completionTime = completionTime;
    }

    @Override
    public String toString() {
        return "Patient ID: " + patientId + " (" + patientName + ") | Doctor: " + doctorAssigned +
               " | Treatment: " + treatmentDetails + " | Time: " + completionTime;
    }
}