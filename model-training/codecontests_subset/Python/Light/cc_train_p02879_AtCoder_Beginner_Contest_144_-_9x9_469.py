a,b = map(int, input().split())
ans = a*b
if (a>9) or (b>9):
  ans = -1
print(ans)