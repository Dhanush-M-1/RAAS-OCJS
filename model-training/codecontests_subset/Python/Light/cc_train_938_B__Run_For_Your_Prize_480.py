n = int(input())
l = [int(i) for i in input().split()]
maxn = int(-1e9)
for i in l:
    if i > 5*1e5:
        maxn = max(maxn, 1e6 - i)
    else:
        maxn = max(maxn, i - 1)
print(int(maxn))