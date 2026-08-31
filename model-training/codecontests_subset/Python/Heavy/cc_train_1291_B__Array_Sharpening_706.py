import sys
input = sys.stdin.readline
t = int(input())
for _ in range(t):
  N = int(input())
  a = list(map(int, input().split()))
  if a == [0, 0]:
    print("No")
    continue
  tl = [0] * N
  tr = [0] * N
  l = N // 2 - 1 + N % 2
  for i in range(N):
    tl[i] = N - abs(i - l)
  mnl = min(tl)
  for i in range(N):
    tl[i] -= mnl
  tl[0] = 0
  tl[-1] = 0
  #print(tl)
  if len(tl) > 1:
    for i in range(N):
      if i + 1 >= N: break
      if tl[i + 1] == N - mnl: break
      tl[i + 1] = tl[i] + 1
  tr = tl[: : -1]
  #print(tl, tr)
  lok = 1
  rok = 1

  for i in range(N):
    if tl[i] > a[i]: lok = 0
    if tr[i] > a[i]: rok = 0
  if lok or rok:
    print("Yes")
  else:
    print("No")
