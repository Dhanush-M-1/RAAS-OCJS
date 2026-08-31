class Number:
    def __init__(self, num, x, y):
        self.num = num
        self.x = x
        self.y = y


def gcd(a, b):
    left = Number(num=a, x=1, y=0)
    right = Number(num=b, x=0, y=1)

    while right.num != 0:
        mult = left.num // right.num

        left.x -= right.x * mult;
        left.y -= right.y * mult;
        left.num -= right.num * mult;

        left, right = right, left

    return left;


def divide(a, b, up):
    if up:
        return (a + (b - 1)) // b
    else:
        return a // b

    
if __name__ == '__main__':
    n, p, w, d = map(int, input().split())
    
    common_gcd = gcd(gcd(w, d).num, p).num
    p //= common_gcd
    w //= common_gcd
    d //= common_gcd
    
    sol = gcd(w, d);
    
    if p % sol.num != 0:
        print(-1)
    else:
        mult = p // sol.num
        x0 = sol.x * mult
        y0 = sol.y * mult

        k_max = min(divide(x0, d, False), divide((n - x0 - y0), (w - d), False))
        k_min = divide(-y0, w, True)

        if k_min > k_max:
            print(-1)
        else:
            x = x0 - d * k_min
            y = y0 + w * k_min
            z = n - x - y

            print(x, y, z)