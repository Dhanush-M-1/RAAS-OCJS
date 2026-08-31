n,m,*a=map(int,open(0).read().split())
b=[1]*(n+1)
for i in a:
    b[i]=0
for i in range(2,n+1):
    b[i]=(b[i-1]+b[i-2])%1000000007*b[i]
print(b[-1])
