for _ in range(int(input())):
    input()
    k, n, m = map(int, input().split())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    s = []
    flag =False
    i, j = 0, 0
    while(True):
        if i>=n and j>=m:
            break
        if i<n and a[i] == 0:
            k+=1
            i+=1
            s.append(0)
        elif j<m and b[j] == 0:
            k+=1
            j+=1
            s.append(0)
        elif i<n  and a[i] <= k:

            s.append(a[i])
            i += 1
        elif j<m and b[j] <= k:

            s.append(b[j])
            j += 1
        else:
            flag = True
            break

    if flag == False:
        print(*s)
    else:
        print(-1)