import string, copy


def solution(n, a):
    a = sorted(a, reverse=True)
    odds = [i for i in a if (i % 2 == 1)]
    evens = [i for i in a if (i % 2 == 0)]
    if abs(len(odds) - len(evens)) <= 1:
        return 0
    l = min(len(odds), len(evens)) + 1
    return sum(odds[l:] + evens[l:])


def parser():
    n = int(input())
    a = [int(s) for s in input().split(' ')]
    return n, a


def output(s):
    print(s)


def main():
   args = parser()
   result = solution(*args)
   output(result)


if __name__ == '__main__':
    main()