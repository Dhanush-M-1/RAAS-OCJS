for i in range(int(input())):
    n, a = int(input()), list(map(int, input().split()))
    ans, ix = 'NO', -1

    for j in range(n):
        if a[j] >= j:
            ans = 'YES'
        else:
            ix = j
            break

    if ix != -1:
        for j in range(n - 1, ix - 1, -1):
            if a[j] >= n - j - 1 and a[j - 1] != n - j - 1:
                ans = 'YES'
            else:
                ans = 'NO'
                break
    if n == 1:
        ans = 'YES'
    if n == 2 and a[0] == a[-1] == 0:
        ans = 'NO'
    print(ans)
