REM 声明采用UTF-8编码
chcp 65001
set /p a=请输入msg:
set /p b=请输入branch:
echo 'git commit -m %a% ' &&   git add -u && git commit -m  %a% && git push origin %b% 



 