n, x, y = input().split()
n, x, y = int(n), int(x), int(y)
percent = ((y * n) / 100)
if int(percent) != percent:
    percent += 1
    percent = int(percent)
ans = int(percent - x)
if ans >= 0:
    print(ans)
else:
    print(0)
