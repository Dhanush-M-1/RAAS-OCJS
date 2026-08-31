t = int(input())

for _ in range(t):
    n = int(input())
    N = n
    cnt_2 = 0
    cnt_3 = 0

    while True:
        if n % 2 == 0:
            n //= 2
            cnt_2 += 1
        else:
            break

    while True:
        if n % 3 == 0:
            n //= 3
            cnt_3 += 1
        else:
            break
            
    if N == 1:
        res = 0
    else:
        if cnt_2 > cnt_3:
            res = -1
        else:
            k = (6 ** cnt_3) // (2 ** (cnt_3 - cnt_2))

            if k == N:
                res = cnt_3 + (cnt_3 - cnt_2)
            else:
                res = -1


    print(res)
