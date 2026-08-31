def main():
    t = int(input())
    for _ in range(t):
        n = int(input())
        s = list(map(int, input().split()))
        if s[0] + s[1] <= s[-1]:
            print(1, 2, n)
        else:
            print(-1)


if __name__ == '__main__':
    main()
