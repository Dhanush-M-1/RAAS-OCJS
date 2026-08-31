n, m = map(int, input().split())
x=n
def loop(n, m):
    global x
    while n>=m:
        if n%m==0:
            x += n//m
            return loop(n//m, m)
        else:
            y = n//m + n%m
            x += n//m
            return loop(y, m)
loop(n, m)
print(x)
