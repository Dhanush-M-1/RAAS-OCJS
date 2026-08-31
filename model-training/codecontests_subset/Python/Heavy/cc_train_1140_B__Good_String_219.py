def main():
    n = int(input())
    strings = []
    for i in range(n):
        lenght = int(input())
        strings.append((input(), lenght))

    for s, l in strings:
        if s[0] == '>' or l == 1 or s[-1] == '<':
            print(0)
            continue

        min_len = l
        for i in range(l):
            if s[i] == '>':
                min_len = min(min_len, i, l-i)
                break
        counter = 0
        for i in range(l-1, -1, -1):
            if s[i] == '<':
                min_len = min(min_len, counter, l-counter)
                break
            counter += 1

        print(min_len)


if __name__ == '__main__':
    main()
