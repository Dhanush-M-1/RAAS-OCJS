t = int(input())
for i in range(t):
    n, m = map(int, input().split())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    res = 0
    i = 0
    if n < m:
        while i < n and a[i] not in b:
            i += 1
        if i == n:
            print('NO')
        else:
            print('YES')
            print('1 ' + str(a[i]))
    else:
        while i < m and b[i] not in a:
            i += 1
        if i == m:
            print('NO')
        else:
            print('YES')
            print('1 ' + str(b[i]))