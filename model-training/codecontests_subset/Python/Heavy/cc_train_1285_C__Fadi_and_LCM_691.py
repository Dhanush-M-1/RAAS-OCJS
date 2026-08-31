def make_prime_factors_distinct(n):
    prime_factors = []
    for k in range(2, int(n**0.5) + 1):
        if n % k == 0:
            prime_factors.append(k)
            while n % k == 0:
                n = n // k
    if n != 1:
        prime_factors.append(n)
    return prime_factors
  

x = int(input())
prime_li = make_prime_factors_distinct(x)
a = [0] * len(prime_li)

for i in range(len(prime_li)):
    num = 1
    while True:
        if x % (prime_li[i] ** num) != 0:
            break
        num += 1
    num -= 1
    a[i] = prime_li[i] ** num

ans = 10**18
for bit_state in range((1 << len(prime_li))):
    tmp = 1
    for i in range(len(prime_li)):
        if bit_state & (1 << i):
            tmp *= a[i]
    if ans > max(tmp, x // tmp):
        ans = max(tmp, x // tmp)
        res = (tmp, x // tmp)
print(*res)