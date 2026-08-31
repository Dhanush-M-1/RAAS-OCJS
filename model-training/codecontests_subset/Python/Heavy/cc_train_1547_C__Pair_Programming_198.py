

t = int(input())
for w in range(t):
    st = input()
    k, n, m = [int(x) for x in input().split()]
    a = [int(x) for x in input().split()]
    b = [int(x) for x in input().split()]
    a.reverse()
    b.reverse()
    v = []
    flag = 0
    while len(a) > 0 and len(b) > 0:
        x = a.pop()
        y = b.pop()
        if x == 0:
            v.append(0)
            b.append(y)
            k += 1
            continue
        if y == 0:
            v.append(0)
            a.append(x)
            k += 1
            continue
        if x <= k:
            v.append(x)
            b.append(y)
            continue
        if y <= k:
            v.append(y)
            a.append(x)
            continue
        else:
            flag = 1
            break

    while len(a) > 0:
        x = a.pop()
        if x == 0:
            v.append(0)
            k += 1
            continue
        if x <= k:
            v.append(x)
        else:
            flag = 1
            break

    while len(b) > 0:
        x = b.pop()
        if x == 0:
            v.append(0)
            k += 1
            continue
        if x <= k:
            v.append(x)
        else:
            flag = 1
            break


    if flag == 1:
        print("-1")
    else:
        print(*v, sep=" ")




