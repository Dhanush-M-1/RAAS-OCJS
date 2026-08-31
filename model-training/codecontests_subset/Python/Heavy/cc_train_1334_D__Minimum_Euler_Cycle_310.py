t = int(input())
for i in range(t):
    n, l, r = map(int, input().split())
    if (l == n * (n - 1) + 1):
        print(1)
        continue
    left, right, summ = 0, n, 0
    while (left != right - 1):
        mid = (left + right) // 2;
        tmp = n * mid - (mid * (mid + 1) // 2)
        if (2 * tmp < l):
            left = mid
            summ = 2 * tmp
        else:
            right = mid
        #print(left, right)
    beg = summ
    count = left + 1
    ans = []
    ind = False
    for i in range(count, n):
        for j in range(i + 1, n + 1):
            ans.append(i)
            ans.append(j)
            summ += 2
            if (summ > r):
                ind = True
                break
        if (ind):
            break
    ans.append(1);
    for i in range(l - 1, r):
        print(ans[i - beg], end = " ")
    print()