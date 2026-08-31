from collections import deque
h,w,k = map(int,input().split())
a = []
for i in range(h):
  b = input()
  tmp = []
  for j in range(w):
    tmp.append(b[j])
    if b[j] == "S":
      sx = i
      sy = j
  a.append(tmp)
ma = [[0]*w for i in range(h)]
def dfs(x,y,z):
  if ma[x][y] == 1:
    return
  if z>k:
    return
  ma[x][y] = 1
  if x > 0 and a[x-1][y]== ".":
    que.append([x-1,y,z+1])
  if y > 0 and a[x][y-1]== ".":
    que.append([x,y-1,z+1])
  if x <h-1 and a[x+1][y]==".":
    que.append([x+1,y,z+1])
  if y <w-1 and a[x][y+1]==".":
    que.append([x,y+1,z+1])
que = deque([[sx,sy,0]])
while que:
  x,y,z = que.popleft()
  dfs(x,y,z)
ans = float("inf")
for i in range(h):
  for j in range(w):
    if ma[i][j] == 1:
      ans = min(ans,1+(h-i-1)//k+ (1 if (h-i-1)%k else 0),1+(w-j-1)//k+ (1 if (w-j-1)%k else 0),
               1+(i)//k+ (1 if (i)%k else 0),1+(j)//k+ (1 if (j)%k else 0))
print(ans)