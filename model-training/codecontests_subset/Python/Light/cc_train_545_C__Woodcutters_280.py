n = int(input())
tree = [[]for i in range(n)]
result = 2
if n >= 2:
    for i in range(n):
        c = list(map(int, input().split()))
        tree[i] = c
    for i in range(1, n-1):
        if tree[i][0] - tree[i-1][0] > tree[i][1]:
            result+= 1
        else:
            if tree[i+1][0] - tree[i][0] > tree[i][1]:
                result+= 1
                tree[i][0] = tree[i][0]+tree[i][1]
    print(result)
else:
    print(1)