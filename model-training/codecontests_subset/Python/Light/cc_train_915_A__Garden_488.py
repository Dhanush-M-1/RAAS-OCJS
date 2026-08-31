m,n=map(int,input().split())
a=list(map(int,input().split()))
m+=222
for e in a:
    if n%e==0: m=min(m,n//e)
print(m)