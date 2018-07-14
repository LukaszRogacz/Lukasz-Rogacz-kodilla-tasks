call runcrud
if "%ERRORLEVEL%" == "0" goto runbrowser
echo.
echo runcrud has errors
goto fail

:runbrowser
explorer "http://localhost:8080/crud/v1/task/getTasks"
goto end

:fail
echo.
echo Errors occured in showtasks file.


:end
echo.
echo Work for showtasks script is finished.
