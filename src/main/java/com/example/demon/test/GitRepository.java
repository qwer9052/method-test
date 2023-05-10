package com.example.demon.test;

import org.kohsuke.github.GHIssueState;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.IOException;

public class GitRepository {

    private GitHubService gitHubService;

    public GitRepository(GitHubService gitHubService){
        this.gitHubService = gitHubService;
    }

    public int getPoint(String repositoryName) throws IOException {
        GitHub gitHub = gitHubService.connect();
        GHRepository repository = gitHub.getRepository(repositoryName);

        int point = 0;
        if(repository.hasIssues()){
            point += 1;
        }

        if(repository.getReadme() != null){
            point += 1;
        }

        if(repository.getPullRequests(GHIssueState.CLOSED).size() > 0){
            point += 1;
        }


        point += repository.getStargazersCount();
        point += repository.getForksCount();
        return point;
    }
}
