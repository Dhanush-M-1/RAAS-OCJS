for _ in range(int(input())):
    n = int(input())
    a = list(map(int, input().split()))
    max1, min1 = 0, 10**9
    for q in range(len(a)):
        if a[q] != -1:
            if q != n-1 and a[q+1] == -1:
                max1 = max(max1, a[q])
                min1 = min(min1, a[q])
            if q != 0 and a[q-1] == -1:
                max1 = max(max1, a[q])
                min1 = min(min1, a[q])
    ans, ans1 = (min1+max1)//2, 0
    for q in range(n-1):
        if a[q] == -1 and a[q+1] == -1:
            continue
        elif a[q] == -1:
            ans1 = max(ans1, abs(ans-a[q+1]))
        elif a[q+1] == -1:
            ans1 = max(ans1, abs(ans-a[q]))
        else:
            ans1 = max(ans1, abs(a[q]-a[q+1]))
    print(ans1, ans)
