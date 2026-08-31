# cook your dish here
a,b=map(int,input().split())
cnt=a
rem=a%b
while a>=b:
    c=a//b
    a=c+rem
    cnt+=c
    rem=a%b
    
    
print(cnt)