def main():
    first, second = map(str, input().split())
    print(first, second)
    n = int(input())
    while n > 0:
        n -= 1
        killed, replaced = map(str, input().split())
        if killed == first:
            first = replaced
        else:
            second = replaced
        print(first, second)


if __name__ == '__main__':
    main()