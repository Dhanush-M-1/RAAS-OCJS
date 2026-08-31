def calc():
    print()


def main():
    n: int = int(input())
    num: str = input().strip()
    tmp: int = n // 11
    print(min(num.count('8'), tmp))


if __name__ == '__main__':
    main()
