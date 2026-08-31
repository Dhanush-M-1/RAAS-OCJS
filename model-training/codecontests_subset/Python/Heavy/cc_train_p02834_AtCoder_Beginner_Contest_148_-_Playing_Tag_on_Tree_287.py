import sys
sys.setrecursionlimit(1000000)

n,u,v=map(int,input().split())
Graph=[]
for i in range(n):
    Graph.append([])
for i in range(n-1): #隣接頂点の登録
    a,b=map(int,input().split())
    Graph[a-1].append(b-1)
    Graph[b-1].append(a-1)

def dfs(s,b=-1): #深さ優先探索(子,親(初期値は-1))
    for i in Graph[s]: #隣接点に対して
        if i!=b: #親と一緒じゃないとき
            depth[i]=depth[s]+1 #深さを登録
            dfs(i,s) #親子を更新して再探索

depth=[0]*n
dfs(u-1)
dT=depth

depth=[0]*n
dfs(v-1)
dA=depth

dArrest=0
for i in range(n):
    if dA[i]>dT[i]: #Tが先に着ける点のうち
        dArrest=max(dArrest,dA[i]) #一番Aから遠い点
print(dArrest-1)