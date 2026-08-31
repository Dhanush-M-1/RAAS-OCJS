q = int(input())
for k in range(q):
    arr = []
    sm = 0
    n = int(input())
    p, c = map(int, input().split())
    arr.append([p, c])
    ok = True
    if p < c:
        print('NO')
        ok = False
    for i in range(1, n):
        a, b = map(int, input().split())
        arr.append([a, b])
        if ok and (arr[i][0] < arr[i-1][0] or arr[i][1] < arr[i-1][1] or a < b or arr[i-1][0] - arr[i-1][1] > arr[i][0] - arr[i][1]):
            print('NO')
            ok = False
    if ok:
        print('YES')