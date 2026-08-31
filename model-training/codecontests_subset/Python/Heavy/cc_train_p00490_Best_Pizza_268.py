# -*- coding: utf-8 -*-
"""


"""
import sys
from sys import stdin
from collections import deque
input = stdin.readline
from collections import namedtuple
item = namedtuple('item', ['cal', 'pri'])


def Cond(x, n, items, pizza):
    y = [0] * n
    for i in range(n):
        y[i] = items[i].cal - x * items[i].pri
    y.sort(reverse=True)

    total = pizza.cal - x * pizza.pri
    for i in range(n):
        if y[i] > 0:
            total += y[i]
        else:
            break
    return total >= 0



def main(args):
    # n = 3
    # k = 2
    # items = [item(2, 2), item(5, 3), item(2, 1)]

    N = int(input())
    A, B = map(int, input().split())
    C = int(input())
    toppings = []
    for i in range(N):
        toppings.append(item(int(input()), B))
    pizza = item(C, A)

    lb = 0
    ub = 1e5
    for i in range(100):
        mid = (lb + ub) / 2
        if Cond(mid, N, toppings, pizza):
            lb = mid
        else:
            ub = mid
    print(int(ub))


if __name__ == '__main__':
    main(sys.argv[1:])