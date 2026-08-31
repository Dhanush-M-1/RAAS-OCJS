n, k = map(int, input().split())
a = map(int, input().split())
tmp = 0
for i in a:
    if k % i == 0 and i > tmp:
        tmp = i
print(k // tmp)
# CodeForcesian
# ♥
# دمت گرم که هستی