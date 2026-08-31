import sys
input = sys.stdin.readline
mod=1000000007
n,m=map(int,input().split())
ans=[]
groupi=[-1]*(m+1)
groups=[2]*m
for i in range(m):
    groups[i]=[]
cur=1
for i in range(n):
    x=list(map(int,input().split()))
    k=x.pop(0)
    if k==1:
        x=x[0]
        if groupi[x]==-1:
            groupi[x]=0
            ans.append(i+1)
        if groupi[x]>0:
            ind=groupi[x]
            for y in groups[ind]:
                groupi[y]=0
            groupi[x]=0
            ans.append(i+1)
    if k==2:
        x1,x2=x[0],x[1]
        if groupi[x1]==-1:
            if groupi[x2]==-1:
                groupi[x1]=cur
                groupi[x2]=cur
                groups[cur]=[x1,x2]
                cur+=1
                ans.append(i+1)
            else:
                if groupi[x2]==0:
                    groupi[x1]=0
                    ans.append(i+1)
                else:
                    groupi[x1]=groupi[x2]
                    groups[groupi[x2]].append(x1)
                    ans.append(i+1)
        else:
            if groupi[x2]==-1:
                if groupi[x1]==0:
                    groupi[x2]=0
                    ans.append(i+1)
                else:
                    groupi[x2]=groupi[x1]
                    groups[groupi[x1]].append(x2)
                    ans.append(i+1)
            else:
                if groupi[x1]!=groupi[x2]:
                    if groupi[x1]==0 or groupi[x2]==0:
                        if groupi[x1]==0:
                            for y in groups[groupi[x2]]:
                                groupi[y]=0
                        else:
                            for y in groups[groupi[x1]]:
                                groupi[y]=0
                    else:
                        if len(groups[groupi[x1]])<len(groups[groupi[x2]]):
                            x1,x2=x2,x1
                        for y in groups[groupi[x2]]:
                            groupi[y]=groupi[x1]
                            groups[groupi[x1]].append(y)
                    ans.append(i+1)
print(pow(2,len(ans),mod),len(ans))
print(*ans)