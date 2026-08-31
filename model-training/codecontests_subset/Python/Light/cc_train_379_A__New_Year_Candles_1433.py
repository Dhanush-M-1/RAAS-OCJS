a,b=map(int,input().split())
c=a
while(a>=b):
    t=a%b
    a=a//b
    c=c+a
    a=a+t
print(c)