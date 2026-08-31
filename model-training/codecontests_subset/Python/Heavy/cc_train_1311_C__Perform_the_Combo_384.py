for _ in range(int(input())):
    n, m = map(int, input().split())
    s = list(input())
    p = list(map(int, input().split()))
    matrix = [[0 for i in range(26)]for i in range(n)]
    for i in range(n):
        for j in range(26):
            matrix[i][j] = matrix[i - 1][j]
        matrix[i][ord(s[i]) - 97] += 1
    ans = [0 for i in range(26)]
    for i in range(m):
        pos = p[i] - 1
        for j in range(26):
            ans[j] += matrix[pos][j]
    for j in range(26):
        ans[j] += matrix[n - 1][j]
    for i in ans:
        print(i, end=' ')
    print('')