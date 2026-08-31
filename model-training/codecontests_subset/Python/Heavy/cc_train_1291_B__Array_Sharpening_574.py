def inc(a):
    for i in range(1, n):
        if a[i] <= a[i-1]:
            return False
    return True

for _ in range(int(input())):
    n = int(input())
    a = list(map(int, input().split()))

    if inc(a) or inc(a[::-1]):
        print("Yes")
        continue

    dec = True
    increase_after = -1
    minn = a[0]
    mc = a[0]-1
    smin = a[0]
    for i in range(n):
        if a[i] >= i:
            mc = a[i]
            increase_after += 1
        else:
            break

    poss = True
    minn = mc
    for i in range(increase_after+1, n):
        minn = min(a[i], minn-1)

        if minn < 0:
            poss = False
            break
    if poss:
        print("Yes")
    else:
        print("No")