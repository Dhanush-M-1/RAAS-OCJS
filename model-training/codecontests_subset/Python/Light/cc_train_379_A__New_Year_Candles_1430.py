
a,b=map(int,input().split())
s=a
while(a>=b):
    d=a//b
    s+=d
    r=a%b
    a=d+r
print(s)