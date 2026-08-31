n,m=map(int,input().split())
l=list(map(int,input().split()))
x=101
for i in range(n):
    if(m%l[i]==0):
        a=min(m//l[i],x)
        x=a
print(a)