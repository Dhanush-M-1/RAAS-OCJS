n,k=map(int,input().split())
a=[int(i) for i in input().split()]
d={}
for i in a:
    if(k%i==0):
        d[i]=k//i
ans=101
for i in d:
    if(d[i]<ans):
        ans=d[i]
print(ans)







