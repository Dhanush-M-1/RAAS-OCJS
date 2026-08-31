import sys

sys.setrecursionlimit(10**7)
n,u,v = map(int,input().split())
u-=1
v-=1
ki = [[]for i in range(n)]
distt = [0]*n
dista = [0]*n
for i in range(n-1):
    a,b = map(int,input().split())
    a -= 1
    b -= 1
    ki[a].append(b)
    ki[b].append(a)
def dfst(now,last = -1):
    for next in ki[now]:
        if next == last:continue
        distt[next] = distt[now]+1
        dfst(next,now)
def dfsa(now,last = -1):
    for next in ki[now]:
        if next == last:continue
        dista[next] = dista[now]+1
        dfsa(next,now)
    
dfst(u)
dfsa(v)
ans = 0
for i in range(n):
    if dista[i]<=distt[i]:continue
    ans = max(ans,dista[i]-1)
print(ans)
    