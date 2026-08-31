import sys


def main():
    n = int(sys.stdin.readline())
    digits = sys.stdin.readline()
    eights = sum(d == "8" for d in digits)
    print(min(n // 11, eights))


if __name__ == "__main__":
    main()