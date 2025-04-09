# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## 2025.04.09

### Added

- Designed kernel implementation for FPLDataTracker component using a Map of player names to stat maps.

### Updated

- Changed design to include a nested Map structure, `Map<String, Map<String, String>>`, for modeling player stats.
- Specified convention and correspondence to define legal states and abstract meaning

## 2025.02.03

### Added

- Brainstormed a FPL (Fantasy Premier League) Data Tracker component.
- Brainstormed a Music Playlist Manager component.
- Brainstormed a To-Do List Manager component.
