def check(a: list, m: int, n: int) -> bool:
    # print('m:', m)
    l = -1
    r = int(1e9)
    for i in range(1, n+1):
        if a[i] == -1:
            lt = rt = 0
            if a[i-1] == -1 and a[i+1] == -1:
                continue
            elif a[i-1] == -1 and a[i+1] != -1:
                lt = a[i+1] - m
                rt = a[i+1] + m
            elif a[i-1] != -1 and a[i+1] == -1:
                lt = a[i-1] - m
                rt = a[i-1] + m
            else:
                rt = min(a[i-1], a[i+1]) + m
                lt = max(a[i+1], a[i-1]) - m
            l = max(l, lt)
            r = min(r, rt)
            if l > r:
                return False
        else:
            if a[i-1] != -1 and abs(a[i-1]-a[i]) > m:
                return False
    global k
    k = r
    return True


for _ in range(int(input())):
    n = int(input())
    a = [-1] + list(map(int, input().split())) + [-1]
    lm = k = 0
    rm = int(1e9)
    while lm < rm:
        mid = (lm+rm) >> 1
        if check(a, mid, n):
            rm = mid
        else:
            lm = mid+1

    print(rm, k)