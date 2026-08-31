t = int(input())
for u in range(t):
    y = input()
    k, n, m = map(int, input().split())
    pol = list(map(int, input().split()))
    mon = list(map(int, input().split()))
    i = 0
    j = 0
    ans = []
    f = 1
    
    while (i < n or j < m):
        if (i < n and pol[i] == 0):
            ans.append(pol[i])
            k += 1
            i += 1
        elif (j < m and mon[j] == 0):
            ans.append(mon[j])
            k += 1
            j += 1
        elif(i < n and pol[i] <= k):
            ans.append(pol[i])
            i += 1
        elif(j < m and mon[j] <= k):
            ans.append(mon[j])
            j += 1
        else:

            f = 0
            break
    if f:
        print(*ans)
    else:
        print(-1)