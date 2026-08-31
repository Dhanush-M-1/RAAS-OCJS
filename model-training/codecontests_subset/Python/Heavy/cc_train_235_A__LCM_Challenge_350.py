def lcm(a, b, c):
    m = a * b
    while a != 0 and b != 0:
        if a > b:
            a %= b
        else:
            b %= a
    b = m // (a + b)
    m = b * c
    while c != 0 and b != 0:
        if c > b:
            c %= b
        else:
            b %= c
    return m // (c + b)
 
 
n = int(input())
if n == 1:
    ans = 1
elif n == 2:
    ans = 2
else:
    ans = max(lcm(n - 1, n, n - 3), lcm(n, n - 1, n - 2), lcm(n - 1, n - 2, n - 3), lcm(n, n - 2, n - 3), lcm(n,n-1,n-4),lcm(n,n-1,n-5))
 
print(ans)