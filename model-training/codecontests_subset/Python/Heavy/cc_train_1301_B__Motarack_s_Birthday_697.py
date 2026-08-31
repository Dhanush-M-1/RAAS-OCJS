for _ in range(int(input())):
    n = int(input())
    a = list(map(int, input().split()))
    m1 = 0
    ans2 = 0
    m2 = 999999999
    for i in range(n):
        if a[i] != -1:
            if i != n-1 and a[i+1] == -1:
                m2, m1 = min(m2, a[i]), max(m1, a[i])
            if i and a[i-1] == -1:
                m1, m2 = max(m1, a[i]), min(m2, a[i])
    ans = (m1+m2)//2
    ans2 = 0
    for i in range(n-1):
        if a[i] == a[i+1] == -1:
            continue
        if a[i] == -1:
            ans2 = max(ans2, abs(ans-a[i+1]))
            continue
        if a[i+1] == -1:
            ans2 = max(ans2, abs(ans-a[i]))
            continue
        ans2 = max(ans2, abs(a[i]-a[i+1]))
    print(ans2, ans)