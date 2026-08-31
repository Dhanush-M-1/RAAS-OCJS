import sys
input = sys.stdin.readline
from collections import deque

def main():
  h, w, k = map(int, input().split())
  A = [input().rstrip() for _ in range(h)]
  for i, a in enumerate(A):
    if "S" in a:
      sy = i
      sx = a.index("S")
      break

  que = deque()
  D = ((-1, 0), (0, -1), (1, 0), (0, 1))

  def bfs(y, x):
    seen = [0]*h
    seen[y] |= 1 << x
    F = deque()
    F.append((y, x, 0))
    while F:
      ny, nx, cnt = F.popleft()
      que.append((ny, nx, k))
      if cnt == k:
        continue
      for dy, dx in D:
        yy, xx = ny+dy, nx+dx
        if 0 <= yy < h and 0 <= xx < w:
          if A[yy][xx] == "#":
            continue
          if seen[yy] >> xx & 1:
            continue
          seen[yy] |= 1 << xx
          F.append((yy, xx, cnt+1))

  bfs(sy, sx)

  seen = [0]*h
  while que:
    y, x, cnt = que.popleft()
    if y == 0 or y == h-1 or x == 0 or x == w-1:
      ans = -(-cnt // k)
      break
    for dy, dx in D:
      ny, nx = y+dy, x+dx
      if 0 <= ny < h and 0 <= nx < w:
        if seen[ny] >> nx & 1:
          continue
        seen[ny] |= 1 << nx
        que.append((ny, nx, cnt+1))

  print(ans)

if __name__ == "__main__":
  main()