import java.util.ArrayList;
import java.util.List;

abstract class JobRole {
    private String roleName;

    public JobRole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    @Override
    public String toString() {
        return "Role: " + roleName;
    }
}

class SoftwareEngineer extends JobRole {
    private String primaryLanguage;

    public SoftwareEngineer(String primaryLanguage) {
        super("Software Engineer");
        this.primaryLanguage = primaryLanguage;
    }

    public String getPrimaryLanguage() {
        return primaryLanguage;
    }

    @Override
    public String toString() {
        return super.toString() + ", Primary Language: " + primaryLanguage;
    }
}

class DataScientist extends JobRole {
    private String specialization;

    public DataScientist(String specialization) {
        super("Data Scientist");
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    @Override
    public String toString() {
        return super.toString() + ", Specialization: " + specialization;
    }
}

class ProductManager extends JobRole {
    private String productType;

    public ProductManager(String productType) {
        super("Product Manager");
        this.productType = productType;
    }

    public String getProductType() {
        return productType;
    }

    @Override
    public String toString() {
        return super.toString() + ", Product Type: " + productType;
    }
}

class Resume<T extends JobRole> {
    private String candidateName;
    private T jobRole;
    private List<String> skills;
    private String education;
    private String experience;

    public Resume(String candidateName, T jobRole, List<String> skills, String education, String experience) {
        this.candidateName = candidateName;
        this.jobRole = jobRole;
        this.skills = skills;
        this.education = education;
        this.experience = experience;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public T getJobRole() {
        return jobRole;
    }

    public List<String> getSkills() {
        return skills;
    }

    public String getEducation() {
        return education;
    }

    public String getExperience() {
        return experience;
    }

    public double calculateMatchScore(List<String> requiredSkills) {
        if (requiredSkills == null || requiredSkills.isEmpty() || this.skills == null || this.skills.isEmpty()) {
            return 0.0;
        }
        int matchedSkills = 0;
        for (String requiredSkill : requiredSkills) {
            for (String candidateSkill : this.skills) {
                if (candidateSkill.trim().equalsIgnoreCase(requiredSkill.trim())) {
                    matchedSkills++;
                    break;
                }
            }
        }
        return (double) matchedSkills / requiredSkills.size();
    }

    @Override
    public String toString() {
        return "Candidate: " + candidateName + ", " + jobRole + ", Education: " + education + ", Experience: " + experience + ", Skills: " + skills;
    }
}

class ScreeningPipeline {
    public static void processResumes(List<? extends JobRole> roles, List<Resume<?>> resumes, List<String> requiredSkills) {
        for (Resume<?> resume : resumes) {
            System.out.println("\nProcessing Resume for " + resume.getCandidateName() + ":");
            System.out.println(resume);
            double matchScore = resume.calculateMatchScore(requiredSkills);
            System.out.println("Match Score: " + matchScore);

            if (matchScore > 0.5) {
                System.out.println("Resume is a good match for " + resume.getJobRole().getRoleName());
            } else {
                System.out.println("Resume is not a strong match for " + resume.getJobRole().getRoleName());
            }
        }
    }
}

public class JobApplication {
    public static void main(String[] args) {
        SoftwareEngineer seRole = new SoftwareEngineer("Java");
        DataScientist dsRole = new DataScientist("Machine Learning");
        ProductManager pmRole = new ProductManager("SaaS");

        List<String> seSkills = new ArrayList<>();
        seSkills.add("Java");
        seSkills.add("Spring Boot");
        seSkills.add("SQL");
        seSkills.add("Docker");

        List<String> dsSkills = new ArrayList<>();
        dsSkills.add("Python");
        dsSkills.add("Machine Learning");
        dsSkills.add("Statistics");
        dsSkills.add("TensorFlow");

        List<String> pmSkills = new ArrayList<>();
        pmSkills.add("Product Strategy");
        pmSkills.add("Market Analysis");
        pmSkills.add("Agile");
        pmSkills.add("Communication");

        Resume<SoftwareEngineer> seResume1 = new Resume<>("Alice", seRole, seSkills, "BS in CS", "3 years");
        Resume<DataScientist> dsResume1 = new Resume<>("Bob", dsRole, dsSkills, "MS in Data Science", "2 years");
        Resume<ProductManager> pmResume1 = new Resume<>("Charlie", pmRole, pmSkills, "MBA", "5 years");
        Resume<SoftwareEngineer> seResume2 = new Resume<>("David", seRole, List.of("Python", "JavaScript"), "BS in CS", "1 years");


        List<Resume<?>> resumes = new ArrayList<>();
        resumes.add(seResume1);
        resumes.add(dsResume1);
        resumes.add(pmResume1);
        resumes.add(seResume2);

        List<JobRole> roles = new ArrayList<>();
        roles.add(seRole);
        roles.add(dsRole);
        roles.add(pmRole);

        List<String> requiredSESkills = new ArrayList<>();
        requiredSESkills.add("Java");
        requiredSESkills.add("Spring Boot");
        requiredSESkills.add("SQL");

        List<String> requiredDSSkills = new ArrayList<>();
        requiredDSSkills.add("Python");
        requiredDSSkills.add("Machine Learning");
        requiredDSSkills.add("Statistics");

          List<String> requiredPMSkills = new ArrayList<>();
        requiredPMSkills.add("Product Strategy");
        requiredPMSkills.add("Market Analysis");
        requiredPMSkills.add("Agile");



        System.out.println("Screening Software Engineer Resumes:");
        ScreeningPipeline.processResumes(roles, List.of(seResume1, seResume2), requiredSESkills);
        System.out.println("\nScreening Data Scientist Resumes:");
        ScreeningPipeline.processResumes(roles, List.of(dsResume1), requiredDSSkills);
        System.out.println("\nScreening Product Manager Resumes:");
        ScreeningPipeline.processResumes(roles, List.of(pmResume1), requiredPMSkills);
    }
}
