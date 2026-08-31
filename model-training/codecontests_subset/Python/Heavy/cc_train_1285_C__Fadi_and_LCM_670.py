import math



def get_primes(X):
    primes = []
    num = 2
    while num*num <= X:
        num_pow = 0
        while X % num == 0:
            X //= num
            num_pow += 1
        if num_pow:
            primes.append((num, num_pow))
        num += 1
    if X:
        primes.append((X, 1))
    return primes


pair = (math.inf, math.inf)
X = int(input())
primes = get_primes(X)

def backtrack(idx, num1, num2):
    global pair
    if idx >= len(primes):
        if ((num1 * num2) // math.gcd(num1, num2)) == X and max(num1, num2) < max(*pair):
            pair = (num1, num2)
        return
    prime, prime_cnt = primes[idx] 
    for cnt in range(prime_cnt+1):
        backtrack(idx+1, num1*(prime**cnt), num2*(prime**(prime_cnt-cnt)))

backtrack(0, 1, 1)
print('{} {}'.format(*pair))
