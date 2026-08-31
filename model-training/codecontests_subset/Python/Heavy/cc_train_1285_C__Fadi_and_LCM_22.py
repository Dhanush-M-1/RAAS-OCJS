import math
#Return Divisors O(n**2)
def divisors(n):
    i = 1
    l = []
    while i <= int(n**0.5):
        if (n % i == 0):
            if (n // i == i):
                l.append(i)

            else:
                l.append(n // i)
                l.append(i)

        i = i + 1

    return l

for _ in range(1):
    n = int(input())
    ans = n
    l = divisors(n)
    for i in l:
        j = n//i
        a = i
        b = j
        if a*b//math.gcd(a,b) == n:
            ans = min(ans,max(i,j))

    print(ans,n//ans)
