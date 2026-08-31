import math


def min_left(n, arr):
    even, odd = [], []
    for x in arr:
        if x % 2 == 0:
            even.append(x)
        else:
            odd.append(x)
    even.sort()
    odd.sort()
    if len(even) == len(odd):
        return 0
    if len(even) < len(odd):
        return sum(odd[:len(odd) - len(even) - 1])
    else:
        return sum(even[:len(even) - len(odd) - 1])


if __name__ == '__main__':
    n = int(input())
    arr = list(map(int, input().split()))
    print(min_left(n, arr))
