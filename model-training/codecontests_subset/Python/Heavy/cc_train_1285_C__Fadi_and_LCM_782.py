import math
def lcm(a, b):
    return a*b//math.gcd(a, b)
def brute(x):
    z = []
    for i in range(1, x+1):
        for j in range(1, x+1):
            if lcm(i, j) == x:
                z.append([max(i, j), min(i, j)])
    z.sort()
    return z[0]
def factors(n): 
    i = 1
    z = []
    while i <= int(n**0.5)+1: 
        if (n % i == 0) :
            if (n // i == i) : 
                z.append([i, i])
            else : 
                z.append([max(i, n//i), min(n//i, i)])
        i = i + 1
    y = []
    for i in z:
        if lcm(i[0], i[1]) == n:
            y.append(i)
    y.sort()
    return y[0]
x = int(input())
print(*factors(x))