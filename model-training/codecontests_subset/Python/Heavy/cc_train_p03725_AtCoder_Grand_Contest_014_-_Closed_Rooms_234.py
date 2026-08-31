import collections

def solve():
  def calc(x,y):
    cnt1=(x+k-1)//k
    cnt2=(w-1-x+k-1)//k
    cnt3=(y+k-1)//k
    cnt4=(h-1-y+k-1)//k
    return min(cnt1,cnt2,cnt3,cnt4)

  h,w,k=map(int,input().split())
  boards=[tuple(input()) for _ in range(h)]
  for i in range(h):
    for j in range(w):
      if boards[i][j]=='S':
        sx=j
        sy=i
        break
  q=collections.deque()
  checked=[[0]*w for _ in range(h)]
  checked[sy][sx]=1
  q.append((sx,sy,0))
  ans=1+calc(sx,sy)
  while 1:
    if len(q)==0:
      break
    tx,ty,cnt=q.popleft()
    if cnt==k+1:
      break
    ans=min(ans,1+calc(tx,ty))
    if tx!=0 and boards[ty][tx-1]!='#' and checked[ty][tx-1]==0:
      checked[ty][tx-1]=1
      q.append((tx-1,ty,cnt+1))
    if tx!=w-1 and boards[ty][tx+1]!='#' and checked[ty][tx+1]==0:
      checked[ty][tx+1]=1
      q.append((tx+1,ty,cnt+1))
    if ty!=0 and boards[ty-1][tx]!='#' and checked[ty-1][tx]==0:
      checked[ty-1][tx]=1
      q.append((tx,ty-1,cnt+1))
    if ty!=h-1 and boards[ty+1][tx]!='#' and checked[ty+1][tx]==0:
      checked[ty+1][tx]=1
      q.append((tx,ty+1,cnt+1))
  print(ans)
solve()