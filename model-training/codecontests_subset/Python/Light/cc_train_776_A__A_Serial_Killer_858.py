def solution():
    candidates = set(input().split())
    days = int(input())

    print(*candidates)

    for day in range(days):
        candidates ^= set(input().split())
        print(*candidates)


def main():
    solution()


if __name__ == '__main__':
    main()
