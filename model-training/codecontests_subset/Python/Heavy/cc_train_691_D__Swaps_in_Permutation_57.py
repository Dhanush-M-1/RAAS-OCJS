from collections import defaultdict as df
from sys import stdin,stdout
from collections import deque
    
p=set()
n,m=list(map(int,stdin.readline().split()))
a=list(map(int,stdin.readline().rstrip().split()))
a.insert(0,0)
d=df(list)
visited=[0]*(n+1)
for i  in range(m):
    c,l=list(map(int,stdin.readline().split()))
    
    if c==l:
        continue
    if (min(c,l),max(c,l)) not in p:
        p.add((min(c,l),max(c,l)))
        d[c].append(l)
        d[l].append(c)
    
mainans=[0]*(n+1)
#print(d)
#print(d)
for i in range(1,n+1):
    if visited[i]==False:
        ans=[]
        motagota=[]
        #print(i)
        h=deque()
        ans.append(a[i])
        motagota.append(i)
        visited[i]=True
        h.append(i)
        #print(h)
        while(len(h)>0):
            g=h.pop()
            
            for j in d[g]:
                if visited[j]==False:
                    visited[j]=True
                    ans.append(a[j])
                    motagota.append(j)
                    h.append(j)
                    
            
        #print(ans)
        #print(ans)
        ans.sort(reverse=True)
        motagota.sort()
        for j in range(len(ans)):
            mainans[motagota[j]]=ans[j]
mainans.pop(0)
for i in range(len(mainans)):
    stdout.write(str(mainans[i])+' ')
        
    


    