a,b=map(int,input().split())
n=a
r=0
while a>=(b-r):
    a=(a+r)/b
    n=n+int(a)
    r=(n-int(a))%b
print(n)
