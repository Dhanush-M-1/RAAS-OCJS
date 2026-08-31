t=0
k=0
n,b=map(int,input().split())
while n>0:
    t+=n
    n=n+k
    k=n%b
    n=n//b
print(t)