package pl.soek.jira.config;

public enum ApiResourcesEnum {

    AddIssueAPI("rest/api/3/issue"),
    GetProjectAPI("rest/api/3/project/");

    private final String resource;

    ApiResourcesEnum(String resource) {
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }
}
