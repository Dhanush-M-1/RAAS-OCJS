import sys
input = sys.stdin.readline
t = int(input())
for _ in range(t):
  l,r,d = map(int,input().split())
  if l <= d <= r:
    print(r//d*d+d)
  else:
    print(d)