def getone(n):
    if n == 1:
        return 0
    if n%3 != 0:
        return -1
    cnt = 0
    while n >= 6 and n%6 == 0:
        n /= 6
        cnt += 1
    if n < 6:
        if n == 1:
            return cnt
        if n == 3:
            return cnt + 2
        else:
            return -1
    else:
        while n >= 3 and n%3 == 0:
            n /= 3
            cnt += 2
        if n == 1:
            return cnt
        else:
            return -1

t = int(input())
for _ in range(t):
    n = int(input())
    print(getone(n))
