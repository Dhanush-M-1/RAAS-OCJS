n = int(input())
r = lambda: sorted(map(int, input().split()))
a = r()
b = r()
c = r()
def d(a, b, n):
  for i in range(n - 1):
    if a[i] != b[i]:
      print(a[i])
      break
  else:
    print(a[-1])
d(a, b, n)
d(b, c, n - 1)