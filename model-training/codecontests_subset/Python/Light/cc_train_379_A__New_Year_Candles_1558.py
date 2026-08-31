a,b=map(int,input().split())
sum1=a
while(a>=b):
    d=a//b
    sum1=sum1+d
    rem=a%b
    a=d+rem
print(sum1)    