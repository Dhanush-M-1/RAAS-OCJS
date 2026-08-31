# cook your dish here
# from math import * 
#for _ in range(int(input().strip())):
a,b=map(int,input().split())
rem=ans=0
while True:
    ans+=a 
    a,rem = (a+rem)//b , (a+rem)%b
    if a==0:
        break
print(ans)