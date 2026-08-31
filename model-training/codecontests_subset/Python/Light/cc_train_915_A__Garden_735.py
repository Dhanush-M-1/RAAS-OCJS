n,k=map(int,input().split())
li=list(map(int,input().split()))
s=0
for i in li[:n]:
    if k%i==0 and i>s:
        s=i
print(k//s)
