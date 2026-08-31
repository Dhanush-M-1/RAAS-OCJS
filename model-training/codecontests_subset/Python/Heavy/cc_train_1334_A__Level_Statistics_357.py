

T = int(input())
results = []
for case in range(1, T + 1):
    n = int(input())
    stats = []
    for i in range(n):
        p, c = [int(j) for j in input().split()]
        stats.append([p, c])
    result = 'YES'
    for i in range(len(stats)):
        p, c = stats[i]
        if (p < c):
            result = 'NO'
            break
        if (i < len(stats) - 1):
            p2, c2 = stats[i + 1]
            if (p2 - p) < (c2 - c) or (p2 < p) or (c2 < c):
                result = 'NO'
                break
    
    results.append(result)

for result in results:
    print (result)