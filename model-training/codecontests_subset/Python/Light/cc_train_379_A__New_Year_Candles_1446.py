a,b=map(int,input().split())
sum=0
while a>=b:
    c=a//b + a%b
    sum+=(a//b)*b
    a=c
print(sum+a)