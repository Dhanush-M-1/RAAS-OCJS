a,b=map(int,input().split())
n=a;
while(a>=b):
    t=a
    a=a//b
    n=n+a
    a=a+(t%b)
print(n)
