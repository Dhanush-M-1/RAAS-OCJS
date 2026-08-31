
import sys
input=sys.stdin.readline
def getsum(BITTree,i):
    s = 0
    while i > 0:
        s += BITTree[i]
        i -= (i & -i) 
    return(s)
def updatebit(BITTree , i ,v):
    while i <= len(BITTree):
        BITTree[i] += v
        i += (i & -i)
        #print(BITTree)
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
#print(pos)
sorte=sorted(pos.keys())
bit=[0]*(n+10)
ind=[0]*(n+10)
ans,count,diff=0,0,0
for i in range(len(sorte)):
        #print(sort,pos)
        count=getsum(bit,pos[sorte[i]])
        diff=getsum(ind,pos[sorte[i]])
        ans+=count*sorte[i]-diff
        updatebit(bit,pos[sorte[i]],1)
        updatebit(ind,pos[sorte[i]],sorte[i])
print(int(ans))
        
        
