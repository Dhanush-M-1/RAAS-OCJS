''' Testing Python performance @c1729 solution '''
INF = 10 ** 10

MOD = 998244353


def mod_mul(x, y, z=0):
    result = 0
    if y == 0:
        return result

    while y > 1:
        if y & 1 == 1:
            result += x
            if result >= MOD:
                result -= MOD
        x += x
        if x >= MOD:
            x -= MOD
        y >>= 1

    result += x
    if result >= MOD:
        result -= MOD

    result += z
    if result >= MOD:
        result -= MOD
    return result


def main():
    #print = out.append
    ''' Cook your dish here! '''
    # Read input and build the graph
    n = int(input())
    str_a = input().split()

    counter = [0] * 11
    for ai in str_a:
        counter[len(ai)] += 1

    pow10 = [0] * 19
    pow10[0] = 1
    for i in range(18):
        pow10[i + 1] = mod_mul(pow10[i], 10)

    ans = 0
    for i in range(n):
        for j, digit in enumerate(reversed(str_a[i])):
            digit = ord(digit) - 48
            for k in range(1, 11):
                ans = mod_mul(mod_mul(counter[k] * digit, pow10[min(2 * j, j + k)]), 11 if j < k else 2, ans)

    print(ans % MOD)

''' Pythonista fLite 1.1 '''
import sys
#from collections import defaultdict, Counter, deque
# from bisect import bisect_left, bisect_right
# from functools import reduce
# import math
input = iter(sys.stdin.buffer.read().decode().splitlines()).__next__
out = []
get_int = lambda: int(input())
get_list = lambda: list(map(int, input().split()))
main()
#[main() for _ in range(int(input()))]
print(*out, sep='\n')
