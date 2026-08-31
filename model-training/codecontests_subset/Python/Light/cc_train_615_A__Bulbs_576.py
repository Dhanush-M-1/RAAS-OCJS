def main():
    n, m = map(int, input().split())
    l = [False] * (m + 1)
    for _ in range(n):
        for i in map(int, input().split()[1:]):
            l[i] = True
    print(("NO", "YES")[all(l[1:])])


if __name__ == '__main__':
    main()
