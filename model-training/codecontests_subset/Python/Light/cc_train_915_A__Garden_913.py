n,k=map(int,input().split())
a=list(map(int,input().split()))
m=0
for x in a:
    if(k%x==0)&(x>m):
        m=x
print(k//m)
