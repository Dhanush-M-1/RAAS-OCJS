A,B = map(int,input().split())

if max(A,B) > 9:
  print(-1)
else:
  print(A*B)