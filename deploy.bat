@echo on
@echo =============================================================
@echo $                                                           $
@echo $                      duke-kernel                          $
@echo $                                                           $
@echo =============================================================
@echo.
@echo off

@title duke-kernel deploy
@color 0a

rem  Please execute command in local directory.

call mvn clean deploy -DskipTests -P release

pause