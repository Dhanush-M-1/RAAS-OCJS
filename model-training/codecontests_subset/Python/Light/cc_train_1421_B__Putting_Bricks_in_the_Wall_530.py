import sys

t = int(input())

for _ in range(t):
    n = int(input())
    arr = []
    for _ in range(n):
        arr.append(list(input()))
    candidate = [[1, 2], [2, 1], [n - 1, n], [n, n - 1]]
    ans = [arr[0][1], arr[1][0], arr[n - 2][n - 1], arr[n - 1][n - 2]]
    tmp = [['1', '1', '0', '0'],['0', '0', '1', '1']]


    for i in range(2):
        realAns = []
        for j in range(4):
            if tmp[i][j] != ans[j]:
                realAns.append(candidate[j])
        if len(realAns) <= 2:
            break
    print(len(realAns))
    for x in realAns:
        print("%d %d" % (x[0], x[1]))
