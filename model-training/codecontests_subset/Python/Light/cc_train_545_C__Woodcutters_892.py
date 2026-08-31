n = int(input())
if n == 1:
    print(1)
else:
    tree = [[int(x) for x in input().split()] for y in range(n)]
    N = 2
    spot = tree[0][0]
    for i in range(1, n-1):
        if tree[i][0] - spot > tree[i][1]:
            N += 1
            spot = tree[i][0]
        elif tree[i+1][0] - tree[i][0] > tree[i][1]:
            N += 1
            spot = tree[i][0] + tree[i][1]
        else:
            spot = tree[i][0]
    print(N)
