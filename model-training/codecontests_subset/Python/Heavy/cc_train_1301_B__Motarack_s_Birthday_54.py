t = int(input())

for _ in range(t):
    n = int(input())

    a = list(map(int, input().split(' ')))

    rvs = []


    ms = 0

    for i in range(0, len(a)-1):
        if a[i] != -1 and a[i+1] == -1:
            rvs.append(a[i])
        if a[i] == -1 and a[i+1] != -1:
            rvs.append(a[i+1])

    if len(rvs) == 0:
        print(0,0); continue

    ls = max(rvs)
    ll = min(rvs)

    mid = (ls+ll)//2

    a = [x if x != -1 else mid for x in a]

    for i in range(1, len(a)):
        ms = max(ms, abs(a[i] - a[i-1]))



    print(ms, mid)