R = lambda: map(int, input().split())
for _ in range(int(input())):
    n = int(input())
    arr = list(R())
    cnt = 1
    cnts = []
    for i in range(1, n):
        if arr[i] == arr[i - 1]:
            cnt += 1
        elif i - 1 < n // 2:
            cnts.append(cnt)
            cnt = 1
    if len(cnts) < 3:
        print(0, 0, 0)
    else:
        l = len(cnts) - 1
        bcnt = 0
        while l > 0 and bcnt <= cnts[0]:
            bcnt += cnts[l]
            l -= 1
        scnt = sum(cnts) - bcnt - cnts[0]
        if bcnt > cnts[0] and scnt > cnts[0]:
            print(cnts[0], scnt, bcnt)
        else:
            print(0, 0, 0)