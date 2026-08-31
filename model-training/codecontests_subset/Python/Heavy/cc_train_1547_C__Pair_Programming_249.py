for _ in range(int(input())):
    input()
    k, n, m = map(int, input().split())
    a1 = list(map(int, input().split()))
    a2 = list(map(int, input().split()))
    l, r = 0, 0
    ans = []
    count = k
    flag,i=0,0
    while i<(n+m):
        f1, f2 = 0, 0
        if l < n and a1[l]<=count:
            if a1[l] == 0:
                count += 1
            ans.append(a1[l])
            l += 1
        elif r < m and a2[r]<=count:
            if a2[r] == 0:
                count += 1
            ans.append(a2[r])
            r += 1
        else:
            flag = 1
            ans = -1
            break
        i+=1
    if flag:
        print(ans)
    else:
        for i in range(m + n):
            print(ans[i], end=" ")
        print()