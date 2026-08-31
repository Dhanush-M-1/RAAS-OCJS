import sys


def input():
    return sys.stdin.readline().strip()


def print(*x, sep=' ', end='\n'):
    return sys.stdout.write(sep.join(map(str, x)) + end)


def read():
    return sys.stdin.read()


def get():
    return int(input()), [int(i) for i in input().split()]


def out(*arg):
    if type(arg[0]) == list:
        for i in arg[0]:
            print(i)
    else:
        print(arg)


def main():
    n, a = get()
    odd = []
    even = []
    for i in range(n):
        if a[i] % 2 == 0:
            odd.append(a[i])
        else:
            even.append(a[i])
    x, y = len(odd), len(even)
    if abs(x - y) <= 1:
        print(0)
    else:
        odd = sorted(odd, reverse=True)
        even = sorted(even, reverse=True)
        if x > y:
            print(sum(odd) - sum(odd[:y + 1]))
        else:
            print(sum(even) - sum(even[:x + 1]))


if __name__ == "__main__":
    main()
