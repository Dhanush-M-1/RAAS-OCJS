def stone(a,b,c):
    count = 0
    p = max(a,b,c)
    for i in range(p):
        if c >= 2 and b >= 1:
            count += 3
            if c < 2 or b < 1:
                return
            c = c - 2
            b = b - 1
        else:
            if b >= 2 and a >= 1:
                count += 3
                if b < 2 or a < 1:
                    return
                b = b - 2
                a = a - 1
    return count

t = int(input())
for i in range(t):
    a,b,c = [int(i) for i in input().split()]
    ans = stone(a,b,c)
    print(ans)