n, m = tuple(map(int, input().split()))

turned = set()
for i in range(n):
    lamps = list(map(int, input().split()))
    for j in range(lamps[0]):
        turned.add(lamps[j + 1])

if len(turned) == m:
    print("YES")
else:
    print("NO")
