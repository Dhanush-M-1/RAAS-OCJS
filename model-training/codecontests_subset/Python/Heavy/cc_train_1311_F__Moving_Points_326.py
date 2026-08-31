
import sys
input=sys.stdin.readline
def getsum(BITTree,i):
    s = 0
    while i > 0:
        s += BITTree[i]
        i -= i & (-i) 
    return(s)
def updatebit(BITTree , n , i ,v):
    while i <= n:
        BITTree[i] += v
        i += i & (-i)
n=int(input())
x=[int(i) for i in input().split() if i!='\n']
v=[int(i) for i in input().split() if i!='\n']
for i in range(n):
        v[i]=[v[i],i]
v.sort()
pos=dict()
store,prev=1,v[0][0]
for i in range(n):
        if i>0:
            if prev==v[i][0]:
                pos[x[v[i][1]]]=store
            else:
                store+=1
                pos[x[v[i][1]]]=store
                prev=v[i][0]
        else:
            pos[x[v[i][1]]]=store
sort=sorted(pos.keys())
bit=[0]*(n+1)
ind=[0]*(n+1)
ans,count,diff=0,0,0
length=max(sort)
total=0
for i in range(len(sort)-1,-1,-1):
        count=getsum(bit,pos[sort[i]]-1)
        diff=getsum(ind,pos[sort[i]]-1)
        if i<(n-1):
            total+=(sort[i+1]-sort[i])*(n-1-i)
            ans+=total-(diff-count*sort[i])
        updatebit(bit,len(bit)-1,pos[sort[i]],1)
        updatebit(ind,len(ind)-1,pos[sort[i]],sort[i])
print(int(ans))
        
        
