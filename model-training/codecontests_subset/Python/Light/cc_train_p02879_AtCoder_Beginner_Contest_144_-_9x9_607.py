A, B = map(int, input().split())
ans = A*B
if A > 9 or B > 9:
  ans = -1
print(ans)