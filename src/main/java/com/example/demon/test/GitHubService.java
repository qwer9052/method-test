package com.example.demon.test;

import org.kohsuke.github.GitHub;

import java.io.IOException;

public interface GitHubService {
    GitHub connect() throws IOException;
}