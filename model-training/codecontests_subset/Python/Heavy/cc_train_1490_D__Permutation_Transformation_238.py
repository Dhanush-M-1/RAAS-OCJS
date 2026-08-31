"""
Accomplished using the EduTools plugin by JetBrains https://plugins.jetbrains.com/plugin/10081-edutools
"""


def depth(a, i):
    mi = a.index(max(a))
    if i == mi:
        return 0
    elif i < mi:
        return 1 + depth(a[:mi], i)
    else:
        return 1 + depth(a[(mi + 1):], i - (mi + 1))


def foo(a):
    return [depth(a, i) for i in range(len(a))]


def main():
    t = int(input())
    for case in range(t):
        n = int(input())
        a = input()
        a = [int(i) for i in a.split()]

        print(' '.join([str(i) for i in foo(a)]))


if __name__ == "__main__":
    main()
