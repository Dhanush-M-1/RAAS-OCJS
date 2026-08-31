def getPrimes(n):
    isPrime = [True] * n
    p = []
    for i in range(2, n):
        if isPrime[i]:
            for j in range(i, (n - 1) // i + 1):
                isPrime[i * j] = False
            p.append(i)
    return p

def main():
    n = int(input())

    p = getPrimes(int(n ** 0.5 + 0.5) + 100)

    a = []

    for x in p:
        if n % x == 0:
            a.append([x, 0])
            while n % x == 0:
                n //= x
                a[-1][-1] += 1
    if n > 1 or len(a) == 0:
        a.append([n, 1])

    a = [x[0] ** x[1] for x in a]
    ans = solve(a)
    print(ans[0], ans[1])

def solve(a):
    n = len(a)
    ans = (float('inf'), (0, 0))
    for x in range(1<<n):
        s0, s1 = 1, 1
        for i in range(n):
            if (x & (1 << i)):
                s1 *= a[i]
            else:
                s0 *= a[i]
        ans = min(ans, (max(s0, s1), (s0, s1)))
    return ans[1]
main()
