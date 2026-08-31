input()
a = list(map(int, input().split()))
r = 0
for x in a:
    r = max(r, min(x - 1, 1000000 - x))
print(r)
