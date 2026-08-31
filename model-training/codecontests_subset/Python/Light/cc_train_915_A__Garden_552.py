n,k=map(int,input().split())
l=list(map(int,input().split()))
q=[]
for i in l:
    if k%i==0:
        q.append(i)
print(k//max(q))
