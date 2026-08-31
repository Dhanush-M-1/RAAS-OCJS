q = int(input())
results = []
for i in range(q):
    l, r, d = map(int, input().split())
    temp = d
    if temp < l or temp > r:
        results.append(temp)
    else:
        n = r // d
        temp += n * d
        results.append(temp)
for j, temp in enumerate(results):
    print(temp)