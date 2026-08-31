import itertools


def main():
    a, b = [v.strip() for v in input().split()]
    names = {a,b}
    n = int(input())
    print(" ".join(list(names)))
    for i in range(n):
        na, nb = [v.strip() for v in input().split()]
        names.remove(na)
        names.add(nb)
        print(" ".join(list(names)))


if __name__ == "__main__":
    main()
