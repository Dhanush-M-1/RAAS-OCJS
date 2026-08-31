t = int(input())
for _ in range(t):
    input()
    k, n, m = map(int, input().split())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    i = j = 0
    p = []
    while True:
        if i < len(a) and a[i] == 0:
            p.append(a[i])
            k += 1
            i += 1
        elif j < len(b) and b[j] == 0:
            p.append(b[j])
            k += 1
            j += 1
        elif i < len(a) and a[i] <= k:
            p.append(a[i])
            i += 1
        elif j < len(b) and b[j] <= k:
            p.append(b[j])
            j += 1
        else:
            break
    if len(p) == len(a) + len(b):
        print(*p)
    else:
        print(-1)