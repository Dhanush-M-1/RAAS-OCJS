for _ in range(int(input())):
    input()
    k, n, m = [int(i) for i in input().split()]
    a = [int(i) for i in input().split()]
    b = [int(i) for i in input().split()]
    ans = True
    b_be = True
    arr = []
    i = j = 0
    do = True
    while True:
        if i < len(a) and a[i] == 0:
            arr.append(0)
            k += 1
            i += 1
            b_be = True
            continue
        else:
            if i < len(a) and a[i] <= k:
                arr.append(a[i])
                i += 1
                b_be = True
                continue
            else:
                if len(a) == i and len(b) == j:
                    ans = True
                    break
                if not b_be:
                    ans = False
                    break
                while True:
                    if j < len(b) and b[j] == 0:
                        arr.append(0)
                        k += 1
                        j += 1
                        continue
                    else:
                        if j < len(b) and b[j] <= k:
                            arr.append(b[j])
                            j += 1
                            continue
                        else:
                            b_be = False
                            break
                continue
    if ans:
        print(*arr)
    else:
        print(-1)