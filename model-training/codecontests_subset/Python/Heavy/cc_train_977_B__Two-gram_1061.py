import collections
import itertools
import sys
from collections import defaultdict, Counter
from math import sqrt, ceil

input = sys.stdin.readline


############ ---- Input Functions ---- ############
def inp():
    return (int(input()))


def inlt():
    return (list(map(int, input().split())))


def insr():
    s = input()
    return (list(s[:len(s) - 1]))


def invr():
    return (map(int, input().split()))


def ds(d):
    for i in range(2, d + 1):
        if d % i == 0:
            return i


def main():
    d = inp()
    v = input()
    res = defaultdict(lambda : 0)
    cc = ''
    for c in v:
        cc+=c
        if len(cc)==2:
            res[cc]+=1
            cc = cc[1]
    print(sorted(res.items(), key=lambda b:b[1], reverse=True)[0][0])





if __name__ == "__main__":
    # sys.setrecursionlimit(10 ** 6)
    # threading.stack_size(10 ** 8)
    # t = threading.Thread(target=main)
    # t.start()
    # t.join()
    main()
