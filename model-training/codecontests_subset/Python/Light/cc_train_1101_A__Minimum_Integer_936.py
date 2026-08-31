n = int(input())
for i in range(n):
     l, r, d = map(int, input().split())
     if (l / d > 1):
          print(d)
          continue
     print(r + d - r % d)
