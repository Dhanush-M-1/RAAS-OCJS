tc = int(input())
while tc > 0:
    n = int(input())
    last_p = 0
    last_c = 0
    ans = True
    while n > 0:
        n -= 1
        p, c = map(int, input().split())
        if p < last_p or c < last_c:
            ans = False
            break
        delta_p = p - last_p
        delta_c = c - last_c
        if delta_c > delta_p:
            ans = False
            break
        last_p = p
        last_c = c
    for _ in range(n):
        _ = input()
    if ans:
        print("YES")
    else:
        print("NO")
    tc -= 1