def main():
    n, s = int(input()), input()

    cnt8 = 0
    for i in s:
        if i == "8":
            cnt8 += 1

    print(min(cnt8, n//11))


if __name__ == '__main__':
    main()
