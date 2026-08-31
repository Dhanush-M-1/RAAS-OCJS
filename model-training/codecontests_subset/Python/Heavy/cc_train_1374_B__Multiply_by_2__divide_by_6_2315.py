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
    return int(str(d).replace("0", ""))


def main():
    n = inp()
    for _ in range(n):
        d = inp()
        c = 0
        while True:
            if d%6==0:
                d//=6
                c+=1
            elif d%3==0:
                d//=3
                c+=2
            else:
                break
        if d==1:
            print(c)
        else:
            print(-1)



if __name__ == "__main__":
    # sys.setrecursionlimit(10 ** 6)
    # threading.stack_size(10 ** 8)
    # t = threading.Thread(target=main)
    # t.start()
    # t.join()
    main()
