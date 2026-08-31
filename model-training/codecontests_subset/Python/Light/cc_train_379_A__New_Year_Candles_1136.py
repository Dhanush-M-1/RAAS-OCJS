n,p=map(int,input().split())
m,l=0,0
while(n>0):
    l=l+n
    k=n
    n=(n+m)//p
    m=(k+m)%p
print(l)