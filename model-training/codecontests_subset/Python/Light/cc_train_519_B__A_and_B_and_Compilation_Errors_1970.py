N = int(input())
f = lambda: sorted(list(map(int, input().split())))
s = f()


for i in range(2):
  nxt = f() + [None]
  for j in range(N):
    if s[j] != nxt[j]:
      print(s[j])
      break
  s = nxt[:]