t = int(input())
for _ in range(t):
    a,b,c = map(int,input().split())
    res = 0
    if a == 0:
        temp = c//2
        if b >= temp:
            res = (3)*temp
        else:
            res = 3 * b
        print(res)
        continue
    elif b== 0:
        res = 0
        print(res)
        continue
    elif c == 0:
        temp = b//2
        if a>= temp:
            res = 3 * temp
        else:
            res = 3*a
        print(res)
        continue
    else:
        while c>=2:
            if b==0:
                break
            else:
                res += 3
                b -= 1
                c -= 2

        while b>=2:
            if a==0:
                break
            else:
                res += 3
                b -= 2
                a -= 1
        print(res)



