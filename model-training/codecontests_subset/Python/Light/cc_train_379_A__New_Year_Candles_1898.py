a,b=map(int,input().split())
n=a
sum=0
while a>=b:
    c=a//b
    d=a%b
    sum+=c
    a=c+d
print(n+sum)