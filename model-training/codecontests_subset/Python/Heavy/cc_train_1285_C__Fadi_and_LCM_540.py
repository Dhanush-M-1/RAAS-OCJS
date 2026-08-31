from functools import reduce
import io
import os
import sys
from atexit import register
import random
import math
import itertools
from math import gcd

##################################### Flags          #####################################
# DEBUG = True
DEBUG = False
STRESSTEST = False

##################################### IO             #####################################

if not DEBUG:
    input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
sys.stdout = io.BytesIO()
register(lambda: os.write(1, sys.stdout.getvalue()))

tokens = []
tokens_next = 0


def nextStr():
    global tokens, tokens_next
    while tokens_next >= len(tokens):
        tokens = input().split()
        tokens_next = 0
    tokens_next += 1

    if type(tokens[tokens_next - 1]) == str:
        return tokens[tokens_next - 1]
    return tokens[tokens_next - 1].decode()


def nextInt():
    return int(nextStr())


def nextIntArr(n):
    return [nextInt() for i in range(n)]


def print(*argv, end='\n'):
    for arg in argv:
        sys.stdout.write((str(arg) + ' ').encode())
    sys.stdout.write(end.encode())


##################################### Helper Methods #####################################
def genTestCase():
    raise NotImplementedError


def bruteforce(a):
    res = (a, 1)
    for i in range(1, a + 1):
        if i > res[0]:
            break
        for j in range(i, a + 1):
            if j > res[0]:
                break
            if i * j / gcd(i, j) == a:
                res = min(res, (j, i))
    return ' '.join(map(str, sorted(res)))


def doStressTest():
    while True:
        curTest = genTestCase()
        mySoln = solve(curTest)
        bruteforceSoln = bruteforce(curTest)
        if mySoln != bruteforceSoln:
            print('### Found case ###')
            print(curTest)
            print(f'{mySoln} should have been: {bruteforceSoln}')
            return


def factorize(x):
    orgX = x
    res = {}
    for i in [2] + list(range(3, int(x**0.5) + 1, 2)):
        while x % i == 0:
            res[i] = res.get(i, 0) + 1
            x = x // i
    if x > 1:
        res[x] = 1

    if False:
        c = reduce(lambda x, y: (x**res[x]) * (y**res[y]), res)
        assert c == orgX
    return res


def solve(a):
    d = factorize(a)
    # group factors into two numbers to minimize max(the 2 nums)
    x = sorted(i**d[i] for i in d)
    if len(x) == 1:
        return f'1 {a}'

    res = (a, 1)
    for i in range(1, len(x) // 2 + 1):
        for comb in itertools.combinations(x, i):
            first = reduce(lambda x, y: x * y, comb)
            second = a // first
            if first < second:
                first, second = second, first
            res = min(res, (first, second))

    if res[1] < res[0]:
        res = (res[1], res[0])
    return f'{res[0]} {res[1]}'


##################################### Driver         #####################################

if __name__ == "__main__":
    if not DEBUG and STRESSTEST:
        raise Exception('Wrong flags!')

    if STRESSTEST:
        doStressTest()
    else:
        ### Read input here
        a = nextInt()
        res = solve(a)
        print(res)

    sys.stdout.flush()