# -*- coding: utf-8 -*-
import sys
read = sys.stdin.buffer.read
readline = sys.stdin.buffer.readline
write = sys.stdout.write
def ii(): return int(readline())
def mi(): return map(int, readline().rstrip().split())
def li(): return list(readline().rstrip())
def lmi(): return list(map(int, readline().rstrip().split()))
def end(*arg): print(*arg); sys.exit()
# template


def main():
    n, m = map(int, input().split())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    b.sort()
    answer = []
    for i in range(n):
        x = (b[0] - a[i]) % m
        tmp = a.copy()
        for idx in range(n):
            tmp[idx] = (tmp[idx] + x) % m
        tmp.sort()
        if tmp == b:
            answer.append(x)
    print(min(answer))
    return


if __name__ == '__main__':
    main()
