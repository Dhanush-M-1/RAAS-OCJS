from collections import deque
import math

#入力
h,w,k=map(int,input().split())
a=[input() for i in range(h)]

#Sの位置の捜索
for i in range(h):
    for j in range(w):
        if a[i][j]=='S':
            sy,sx=i,j

#各種パラメータの初期設定
d=deque([[sy,sx]])
dist=[]
inf=-1
m=1000
for i in range(h):
    dist.append([inf]*w)
dist[sy][sx]=0

#一回目の魔法で移動できる範囲を幅優先探索
while len(d)!=0:
    b=d.popleft()
    p,q=b[0],b[1]
    for i in [[1,0],[0,-1],[-1,0],[0,1]]:
        by,bx=b[0]+i[0],b[1]+i[1]
        if bx>=0 and bx<w and by>=0 and by<h and a[by][bx]!='#' and dist[by][bx]==-1 and dist[p][q]<k:
            #訪問先が配列内かつ壁でなく未訪問、訪問元の距離がk以下のとき訪問
            d.append([by,bx])
            dist[by][bx]=dist[p][q]+1

#一回目で移動できる各地点からの魔法の使用回数を計算
for i in range(h):
    for j in range(w):
        if dist[i][j]!=-1:
            m=min(m,0--min(i,h-1-i,j,w-1-j)//k)

print(m+1)
