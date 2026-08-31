# coding: utf-8
# Your code here!
import heapq as hq
H,W,K = map(int,input().split())
A = []
X,Y=0,1
start = None
for h in range(H):
    tmp = list(input())
    A.append(tmp)
    if "S" in tmp:
        start = (tmp.index("S"), h)

def minCost(x,y):
    return min(start[X], W-1-start[X], start[Y], H-1-start[Y]) // K
search = []
searched = [[False for w in range(W)] for h in range(H)]
hq.heapify(search)
search.append((0, start[X], start[Y]))
vector = [(1,0),(-1,0),(0,1),(0,-1)]
max_x,min_x,max_y,min_y = 0,W-1,0,H-1
while len(search) > 0:
    cnt,x,y = hq.heappop(search)
    if x == 0 or x == W-1 or y == 0 or y == H-1:
        print(1)
        exit()
    if searched[y][x]:
        continue
    searched[y][x] = True
    max_x = max(max_x, x)
    min_x = min(min_x, x)
    max_y = max(max_y, y)
    min_y = min(min_y, y)
    for v in vector:
        newX,newY = x+v[X], y+v[Y]
        if not searched[newY][newX] and cnt < K and A[newY][newX] != "#":
            hq.heappush(search,(cnt+1,newX,newY))
dist = min(min_x, min_y, W-1-max_x, H-1-max_y)
print(1 + (dist+K-1)//K)