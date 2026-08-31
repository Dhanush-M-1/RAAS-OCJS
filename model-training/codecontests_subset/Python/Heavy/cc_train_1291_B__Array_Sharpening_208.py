for avav in range(int(input())):
    n = int(input())
    mas = list(map(int, input().split()))
    pref = [False for i in range(n)]
    suf = [False for i in range(n)]
    pref[0] = True
    for i in range(1, n):
        if mas[i] < i:
            break
        pref[i] = True
    suf[n - 1] = True
    for i in range(n - 2, -1, -1):
        if mas[i] < (n - 1 - i):
            break
        suf[i] = True
    f = True
    for i in range(n):
        s1 = i - 1
        s2 = i + 1
        if suf[i] and pref[i]:
            print("Yes")
            f = False
            break
    if f:
        print("No")