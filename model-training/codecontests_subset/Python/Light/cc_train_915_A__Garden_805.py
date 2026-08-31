def main():
    n, m = map(int, input().split())
    a = map(int, input().split())
    a = sorted(a, reverse=True)
    ans = None
    for i in a:
        if m % i == 0:
            ans = m // i
            break
    print(ans)


if __name__ == '__main__':
    main()
