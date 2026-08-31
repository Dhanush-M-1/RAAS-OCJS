def solve(a, b, n):
    if n==0: return a
    if n==1: return b
    res = 0
    for i in range(32):
        x = a & (1<<i)
        y = b & (1<<i)
        if x==0:
            if y==0:
                continue
            elif n%3!=0:
                res |= (1<<i)
        else:
            if y==0:
                if n%3!=1:
                    res |= (1<<i)
            elif n%3!=2:
                res |= (1<<i)
    return res



def do():
    n = int(input())
    for _ in range(n):
        a, b, n = map(int, input().split(" "))
        print(solve(a, b, n))

do()
