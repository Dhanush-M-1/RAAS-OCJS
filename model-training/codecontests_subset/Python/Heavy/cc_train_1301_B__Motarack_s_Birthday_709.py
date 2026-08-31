t = int(input())

for _ in range(t):
    n = int(input())
    al = list(map(int,input().split()))
    bl = []
    for i in range(n-1):
        if al[i] == -1 and al[i+1] != -1:
            bl.append(al[i+1])
        elif al[i] != -1 and al[i+1] == -1:
            bl.append(al[i])
    bl = sorted(bl)
    if len(bl) == 0:
        print(0, 0)
        continue
    ans = (bl[0] + bl[-1]) // 2
    ans2 = 0
    for i in range(n-1):
        if al[i] == -1:
            al[i] = ans
        if al[i+1] == -1:
            al[i+1] = ans
        k = abs(al[i+1] - al[i])
        ans2 = max(ans2, k)
    print(ans2, ans)
