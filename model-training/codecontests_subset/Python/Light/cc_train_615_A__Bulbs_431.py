n, m = map(int, input().split())
good = []
for i in range(n):
    bulbs = input().split()
    for j in range(1, len(bulbs)):
        if bulbs[j] not in good:
            good.append(bulbs[j])
if len(good) == m:
    print("YES")
else:
    print("NO")