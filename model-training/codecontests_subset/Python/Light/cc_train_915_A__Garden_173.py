n, k = map(int, input().split())
l = input().split()

ans = 10000000000

for item in l:
    t = int(item)
    if k % t == 0:
        ans = min(ans, int(k/t))

print(ans)

