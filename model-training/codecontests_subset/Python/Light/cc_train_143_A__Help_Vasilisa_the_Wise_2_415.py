r1, r2 = map(int, input().split())
c1, c2 = map(int, input().split())
d1, d2 = map(int, input().split())
ans = [r1 + c1 - d2, r1 + c2 - d1, c1 + r2 - d1, c2 + r2 - d2]
if any([x % 2 == 1 or x // 2 not in range(1, 10) for x in ans]) or len(set(ans)) != 4:
  print(-1)
else:
  ans = [x // 2 for x in ans]
  print(*ans[:2])
  print(*ans[2:])
