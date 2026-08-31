def make_prime_factors_compress(n):
    """自然数nの素因数を列挙した圧縮済みリストを出力する
    計算量：O(sqrt(N))
    入出力例：156 -> [(2, 2), (3, 1), (13, 1)]
    """
    prime_factors = []
    for k in range(2, int(n**0.5) + 1):
        cnt = 0
        while n % k == 0:
            cnt += 1
            n = n // k
        if cnt != 0:
            prime_factors.append((k, cnt))
    if n != 1:
        prime_factors.append((n, 1))
    return prime_factors
  
 
x = int(input())
prime_li = make_prime_factors_compress(x)
a = [0] * len(prime_li)
for i in range(len(prime_li)):
     num, jo = prime_li[i]
     a[i] = num ** jo
 
dp = [0]* (1 << len(prime_li))
ans = 10**18
res = None
for bit_state in range((1 << len(prime_li))):
    tmp = 1
    for i in range(len(prime_li)):
        if bit_state & (1 << i):
            tmp *= a[i]
    if ans > max(tmp, x // tmp):
        ans = max(tmp, x // tmp)
        res = (tmp, x// tmp)
print(*res)