import sys


def readlines(type=int):
    return list(map(type, sys.stdin.readline().split()))


def read(type=int):
    return type(sys.stdin.readline().strip())


joint = lambda it, sep=" ": sep.join(
    [str(i) if type(i) != list else sep.join(map(str, i)) for i in it])


def solve(a, b):
    a_set = set(a)
    b_set = set(b)
    intersc = list(a_set.intersection(b_set))
    if len(intersc) > 0:
        return "YES\n1 {}".format(intersc[0])
    return "NO"


def main():
    n = read()
    for _ in range(n):
        readlines()
        a = readlines()
        b = readlines()
        print(solve(a, b))


if __name__ == "__main__":
    main()
