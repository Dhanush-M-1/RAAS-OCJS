
t = int(input())

for _ in range(t):
    space = input()
    k, n, m = list(map(int,input().split()))
    i = j = 0

    a = list(map(int, input().split())) 
    b = list(map(int, input().split())) 

    history = []

    while i < n or j < m:
        if i < n and a[i] > 0 and a[i] <= k:
            history.append(a[i])
            i += 1
        elif i < n and a[i] == 0:
            k += 1
            history.append(0)
            i += 1
        elif j < m and b[j] > 0 and b[j] <= k:
            history.append(b[j])
            j += 1
        elif j < m and b[j]==0:
            k += 1
            history.append(0)
            j += 1
        else:
            break

    if i == n and j == m:
        print(' '.join(map(str, history)))
    else:
        print(-1)