t = int(input())
input()
for _ in range(t):
    k, n, m = (int(x) for x in input().split())
    a, b = [int(x) for x in input().split()], [int(x) for x in input().split()]
    try:
        input()
    except:
        pass
    i, j, c, arr = 0, 0, k, []
    while i + j < m + n:
        if i >= n:
            if b[j] > c:
                print(-1)
                break
            if b[j] == 0:
                c += 1
            arr.append(b[j])
            j += 1
        elif j >= m:
            if a[i] > c:
                print(-1)
                break
            if a[i] == 0:
                c += 1
            arr.append(a[i])
            i += 1
        else:
            if b[j] > c and a[i] > c:
                print(-1)
                break
            elif b[j] > c:
                arr.append(a[i])
                if a[i] == 0:
                    c += 1
                i += 1
            else:
                arr.append(b[j])
                if b[j] == 0:
                    c += 1
                j += 1
    else:
        print(' '.join(str(x) for x in arr))
