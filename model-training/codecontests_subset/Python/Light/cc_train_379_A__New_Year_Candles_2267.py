a,b = map(int,input().split())
hours,divi,mod = a,0,0
while a>=b:
    divi = a//b
    hours+=divi
    mod = a % b  
    a = divi+mod
print(hours)