reader = lambda: map(int, input().split())
n, m = reader()
counters = {}

for i in range(n):
    lights = list(reader())[1:]
    for j in lights:
        counters[j] = counters.get(j, 0) + 1

for j in range(1, m + 1):
    if j not in counters:
        print("NO")
        break
else:
    print("YES")