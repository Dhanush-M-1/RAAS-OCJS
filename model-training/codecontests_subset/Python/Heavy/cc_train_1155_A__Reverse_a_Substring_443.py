"""
[input1]


[output1]


[input2]


[output2]

"""

import sys

sys_input = sys.stdin.readline


def si(): return sys_input().rstrip()


def ii(): return int(si())


def sti(): return si().split()


def iti(): return map(int, sti())


def sli(): return list(si())


def ili(): return list(iti())


def main():
    for i in range(N - 1):
        if S[i] > S[i + 1]:
            print('YES')
            print(i + 1, i + 2)
            return

    print('NO')

    return


if __name__ == '__main__':
    N = ii()
    S = si()

    main()
