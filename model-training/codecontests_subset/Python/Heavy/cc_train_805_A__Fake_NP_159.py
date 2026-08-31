from sys import stdin
from collections import Counter
inFile = stdin
tokens = []
tokens_next = 0

def next_str():
    global tokens, tokens_next
    while tokens_next >= len(tokens):
        tokens = inFile.readline().split()
        tokens_next = 0
    tokens_next += 1
    return tokens[tokens_next - 1]

def nextInt():
    return int(next_str())
    
def getDivisors(n):
    res = set()
    for i in range(2, n + 1):
        if n % i == 0:
            res.add(i)
    # print('divisors of {} is {}'.format(n, res))
    return res


def mostFrequentDivisor(l, r):
    c = Counter()
    for i in range(l, r + 1):
        cur = getDivisors(i)
        c.update(cur)
    return c.most_common()[0][0]

def getPrimes():
    isPrime = [False] * 2 + [True] * (10 ** 6)
    for i in range(2, len(isPrime)):
        if isPrime[i]:
            for j in range(i*i, len(isPrime), i):
                isPrime[j] = False
    return [i for i in range(2, len(isPrime)) if isPrime[i]]

l, r = nextInt(), nextInt()
if r > l or r % 2 == 0:
    print(2)
else:
    flag = 0
    for i in getPrimes():
        if r % i == 0:
            print(i)
            flag = 1
            break
    if flag == 0:
        print(r)
    