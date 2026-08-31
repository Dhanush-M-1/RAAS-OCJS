n,k=map(int,input().split())
a=list(map(int,input().split()))
s=0
for i in a:
    if k%i==0:s=max(s,i)
print(k//s)