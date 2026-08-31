def gcd(a, b, x, y):
    if a == 0:
        x[0] = 0
        y[0] = 1
        return b
    else:
        x1 = [0]
        y1 = [0]
        d = gcd(b % a, a, x1, y1)
        x[0] = y1[0] - (b // a) * x1[0]
        y[0] = x1[0]
        return d

def find_any_solution(a, b, c, x0, y0, g):
    g[0] = gcd(a, b, x0, y0)
    if c % g[0] != 0:
        return False
    else:
        x0[0] = x0[0] * (c // g[0])
        y0[0] = y0[0] * (c // g[0])
        return True

def __main__():
    n, c, a, b = map(int, input().split())
    x0 = [0]
    y0 = [0]
    g = [0]
    
    if not find_any_solution(a, b, c, x0, y0, g):
        print(-1)
    else:
        x0 = x0[0]
        y0 = y0[0]
        g = g[0]
        k1 = (-x0 + (b // g) - 1) // (b // g)
        k2 = (y0) // (a // g)
        k3 = (x0 + y0 - n + (a // g - b // g - 1)) // (a // g - b // g)

        k1 = max(k1, k3)
        if k1 <= k2:
            k = k1
            x = x0 + k * (b // g)
            y = y0 - k * (a // g)
            
            print(x, y, n - x - y)
        else:
            print(-1)
        
__main__()