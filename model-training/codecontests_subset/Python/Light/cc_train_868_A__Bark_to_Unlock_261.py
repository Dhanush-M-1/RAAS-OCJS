def main():
    pwd = input()
    n = int(input())
    s = [input() for _ in range(n)]

    print(
        'YES' if pwd in s or (
            len([i for i in range(n) if s[i][1] == pwd[0]]) > 0
            and len([i for i in range(n) if s[i][0] == pwd[1]]) > 0
        ) else 'NO'
    )


if __name__ == '__main__':
    main()
