def minCost(a, b):
    # if (b[0] + b[1]) % 2 == 1:
    #     diagA = (a[0] - a[1])//2
    #     diagB = (b[0] - b[1])//2
    #     return diagA - diagB

    if (b[0] + b[1]) % 2 == 0 and (b[0] - b[1]) == (a[0] - a[1]):
            return b[0] - a[0]

    diagA = (a[0] - a[1]) // 2
    diagB = (b[0] - b[1]) // 2
    return diagB - diagA


t = int(input())
for i in range(t):
    n = int(input())
    nodes = list(zip(map(int, input().split()), map(int, input().split())))
    nodes.insert(0, (1,1))
    nodes.sort()
    res = 0
    for i in range(len(nodes) - 1):
        res += minCost(nodes[i], nodes[i+1])
    print(res)