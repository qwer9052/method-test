package com.example.demon.test;

import org.kohsuke.github.GitHub;

import java.io.IOException;

class DefaultGitHubService implements GitHubService {

    @Override
    public GitHub connect() throws IOException {
        return GitHub.connect();
    }
}