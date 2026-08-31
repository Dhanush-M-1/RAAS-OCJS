a,b = map(int,input().split())
hours = a
rem = 0
while(a>=b):
    temp = a//b
    hours += temp
    rem = a%b
    a = temp+rem
    
print(hours)