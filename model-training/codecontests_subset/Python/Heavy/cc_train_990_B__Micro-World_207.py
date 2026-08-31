import configparser
import math
import sys


input = sys.stdin.readline


def main():

    n, k = [int(x) for x in input().split(' ')]
    a = [int(x) for x in input().split(' ')]

    cnts = {}
    for i in a:
        if i in cnts:
            cnts[i] += 1
        else:
            cnts[i] = 1

    a = sorted(list(set(a)))

    cnt = 0
    for i in range(1, len(a)):
        if a[i-1]+k>=a[i] and a[i] > a[i-1]:
            cnt += cnts[a[i-1]]

    print(n - cnt)


if __name__ == '__main__':
    main()
