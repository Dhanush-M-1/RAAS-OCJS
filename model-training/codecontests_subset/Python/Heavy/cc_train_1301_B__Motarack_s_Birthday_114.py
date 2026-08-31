t = int(input())
for case in range(1,t+1):
    n = int(input())
    a = [int(x) for x in input().split()]
    assert len(a) == n

    caps = []
    for i, x in enumerate(a):
        if x == -1:
            if i > 0 and a[i-1] != -1:
                caps.append(a[i-1])
            if i < n-1 and a[i+1] != -1:
                caps.append(a[i+1])

    if caps:
        k = round((max(caps) + min(caps))/2)
    else:
        k = 42

    a_complete = [x if x != -1 else k for x in a]
    m = max(abs(a_complete[i] - a_complete[i-1]) for i in range(1, n))

    print(m, k)
