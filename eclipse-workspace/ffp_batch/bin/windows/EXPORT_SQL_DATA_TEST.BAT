ECHO "EXPORT_SQL_DATA.BAT"

SET LOG_PATCH=C:\ffp\Log\BATCH
SET backuppath="C:\ffp\DATA\BACKUP\DB"
SET YYYYMMDD=%DATE:~0,4%%DATE:~5,2%%DATE:~8,2%

SET LOG_FILE=%LOG_PATCH%\HOUSE_KEEPING_%YYYYMMDD%.LOG
ECHO [%DATE%][%TIME:~0,8%] =========BEGIN========= >> %LOG_FILE%

SET binPath="C:/Program Files/MySQL/MySQL Server 5.7/bin"
SET acdate=%1
SET addflag=%2
SET backupfilename="%3"
SET sqlfile=%4
SET dbhost=%5
SET dbname=%6
SET username=%7
SET password=%8
SET schema=%9

if "%addflag%" equ "Y" SET suffix=%acdate%

ECHO sql-file: %sqlfile% >> %LOG_FILE%
	
if NOT EXIST "%sqlfile%" (
	ECHO [%DATE%][%TIME:~0,8%] file %sqlfile% not exists >> %LOG_FILE%
	GOTO ERROR_END
)

CD "%binPath%"

mysql -h"%dbhost%" -u"%username%" -p"%password%" <%sqlfile% > "%backuppath%"\"%acdate%"\"%backupfilename%""%suffix%".txt
IF %ERRORLEVEL% == 0 (
	ECHO [%DATE%][%TIME:~0,8%] Finish Selecting Data >> %LOG_FILE%
) ELSE (
	ECHO [%DATE%][%TIME:~0,8%] Excute mysql FAILED >> %LOG_FILE%
	GOTO ERROR_END
) 

GOTO END

:ERROR_END
ECHO [%DATE%][%TIME:~0,8%] ==========ERROR_END========== >> %LOG_FILE%
REM ECHO [%DATE%][%TIME:~0,8%] ==========SEND ERROR EMAIL TO IT========== >> %LOG_FILE%
REM CMD /C %SMTPCLIENT_ERROR_BAT% %1 >> %LOG_FILE%
EXIT /B  1
GOTO EOF

:END
ECHO [%DATE%][%TIME:~0,8%] ==========END========== >> %LOG_FILE%
ECHO [%DATE%][%TIME:~0,8%]                         >> %LOG_FILE%
EXIT /B  0