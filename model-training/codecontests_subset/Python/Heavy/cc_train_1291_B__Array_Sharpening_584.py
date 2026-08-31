t = int(input())
for _ in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    sa = sorted(a)
    count = 0
    div = n // 2
    # diff = [0] * (n - 1)
    for i in range(n):
        if a[i] >= div:
            count += 1
        # if i < n - 1:
        #     diff[i] = a[i+1] - a[i]
    # print(diff)
    inc, dec = True, True
    for i in range(1, n):
        if a[i] <= a[i-1]:
            inc = False
        if a[i] >= a[i-1]:
            dec = False
    if count == n or inc or dec:
        print('Yes')
    elif n % 2 != 0:
        cond = True
        mid = n // 2
        for i in range(mid+1):
            if a[i] < i:
                cond = False
            if a[-(i+1)] < i:
                cond = False
        if cond:
            print('Yes')
        else:
            print('No')
    else:
        cond = True
        mid = n // 2 - 1
        for i in range(mid+1):
            if a[i] < i:
                cond = False
            if a[-(i+1)] < i:
                cond = False
        if a[mid] <= mid and a[mid+1] <= mid:
            cond = False
        if cond:
            print('Yes')
        else:
            print('No')
