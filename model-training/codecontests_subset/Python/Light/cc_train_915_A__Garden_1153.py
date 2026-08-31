
n, k = map(int, input().split())
a = list(map(int, input().split()))
a.sort(reverse=True)
for num in a:
     if k % num == 0:
          print(k // num)
          break
