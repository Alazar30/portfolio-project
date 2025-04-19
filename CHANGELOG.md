# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## 2025.03.26

### Added

- Designed abstract class for FPLDataTracker component

### Updated

- Changed design to include an absract class of all the secondary (enhanced) methods.
- Went back and changed the following to the interfaces step:
  - Removed getBestPlayersByPosition because it would be too complicated/not clear how exactly to implement
  - Made the get goal scorer and get assist methods singular as in making them so they only get the sole top goal scorer and assister so that it is easier to implement. Before, though, these methods were to get the top goals socrers and assisters, so like a list of the top 5, 10, or 15 (this was never specified before).

## 2025.03.03

### Added

- Designed kernel and enhanced interfaces for FPLDataTracker component

### Updated

- Changed design to include separate interfaces for primary (kernel) and secondary methods.
- Updated method headers with clear parameter requirements and return types
- Improved documentation

## 2025.02.19

### Added

- Designed a proof of concept for FPLDataTracker component

### Updated

- Changed design to include kernal and secondary methods. Also a main method to test.
- Kernal Methods:
  - addPlayer, removePlayer, updatePlayerStats, containsPlayer, getPlayerCount.
- Secondary Methods:
  - getPlayerStats, getTopScorers, getTopAssisters, getBestPlayerByPosition.

## 2025.02.03

### Added

- Brainstormed a FPL (Fantasy Premier League) Data Tracker component.
- Brainstormed a Music Playlist Manager component.
- Brainstormed a To-Do List Manager component.
