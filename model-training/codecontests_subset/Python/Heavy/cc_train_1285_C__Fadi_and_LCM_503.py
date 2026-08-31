def fadi_lcm ():
    x = int(input())
    if x == 1:
        values = (1, 1)
    else:
        values = (10**12,10**12)
        for i in range(1, int(x**0.5)+1):
            if x % i == 0:
                if lcm(i, x//i) == x:
                    p_max = max(i, x//i)
                    if p_max < max(values) and i!=x//i:
                        values = (i, x//i)
    print(*values)


def gcd(a, b):
    if a == 0:
        return b
    return gcd(b % a, a)


# Function to return LCM of two numbers
def lcm(a, b):
    return (a * b) / gcd(a, b)
fadi_lcm()