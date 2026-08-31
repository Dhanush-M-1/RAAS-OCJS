cases = int(input())

for k in range(cases):
    a, b, c = map(int, input().split())


    resp = 0
    maxa = b//2
    maxb = c//2

    if b > c:

        while a >= 1 and b >= 2 and b > maxb:
            resp += 3
            a-=1
            b-=2
        while b >= 1 and c >= 2:
            resp += 3
            b-=1
            c-=2

    else:
        while b >= 1 and c >= 2:
            resp += 3
            b -= 1
            c -= 2
        while a >= 1 and b >= 2:
            resp += 3
            a -= 1
            b -= 2


    print(resp)