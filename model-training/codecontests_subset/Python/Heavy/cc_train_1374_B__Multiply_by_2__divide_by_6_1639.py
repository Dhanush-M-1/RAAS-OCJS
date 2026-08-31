def prime(n):
    for i in range(2, n):
        if n % i == 0:
            return False
    return True

def hi_th(y):
    count = 0
    while(y % 3 == 0):
        count = count + 1
        y = y / 3
    return count

def hi_tw(z):
    c = 0
    while(z % 2 == 0):
        c = c + 1
        z = z / 2
    return c


T = int(input())
for _ in range(1, T+1):
    N = int(input())
    if N/((3**(hi_th(N))) * (2**(hi_tw(N)))) == 1:
        if hi_th(N) >= hi_tw(N):
            print(hi_th(N) - hi_tw(N) + hi_th(N))
        else:
            print(-1)
    else:
        print(-1)
