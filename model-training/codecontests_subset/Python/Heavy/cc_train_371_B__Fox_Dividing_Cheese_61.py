import sys
input = sys.stdin.readline
read_tuple = lambda _type: map(_type, input().split(' '))
from fractions import Fraction as frac
    

def solution(a, b):
    f = frac(a, b)
    ops = 0
    num, den = f.numerator, f.denominator
    while num % 2 == 0:
        ops += 1
        num = num // 2
    while num % 3 == 0:
        ops += 1
        num = num // 3
    while num % 5 == 0:
        ops += 1
        num = num // 5
    while den % 2 == 0:
        ops += 1
        den = den // 2
    while den % 3 == 0:
        ops += 1
        den = den // 3
    while den % 5 == 0:
        ops += 1
        den = den // 5
    if num == den == 1:
        return ops
    else:
        return -1

def solve():
    a, b = read_tuple(int)
    print(solution(a, b))

if __name__ == '__main__':
    solve()