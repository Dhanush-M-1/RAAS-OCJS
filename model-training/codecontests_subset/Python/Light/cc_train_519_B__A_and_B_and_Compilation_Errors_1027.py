from collections import Counter


def main():
    input()
    fir = Counter(input().split())
    sec = Counter(input().split())
    print(*(fir - sec))
    thi = Counter(input().split())
    print(*(sec - thi))


if __name__ == '__main__':
    main()
