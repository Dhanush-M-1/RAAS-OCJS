for _ in range(int(input())):
    n = int(input())
    a = [int(x) for x in input().split()]
    r = []
    for i,e in enumerate(a):
        if e == -1 :
            if i > 0 and a[i-1]!=-1:
                r.append(a[i - 1])
            if i < len(a) - 1 and a[i+1]!=-1:
                r.append(a[i + 1])

    if len(r) != 0:
        k = (max(r) + min(r)) // 2
        a = [k if i ==-1 else i for i in a]
        m = 0
        for i in range(1, n):
            m = max(m, abs(a[i] - a[i - 1]))
        print(m, k)
    else:
        print(0, 1)