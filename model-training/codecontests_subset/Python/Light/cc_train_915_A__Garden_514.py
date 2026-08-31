n,k=list(map(int,input().split()))
t=list(map(int,input().split()))
s=[]
for i in range(len(t)):
    if k%t[i]==0:
        p=k//t[i]
        s.append(p)
print(min(s))
