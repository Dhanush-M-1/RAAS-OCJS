n, x, y = map(int, input().split())

p = n/100


ans = (y*p) - x

if ans % 1 != 0:
    ans = ans - ans%1 + 1

if ans < 0:
    ans = 0
print(int(ans))