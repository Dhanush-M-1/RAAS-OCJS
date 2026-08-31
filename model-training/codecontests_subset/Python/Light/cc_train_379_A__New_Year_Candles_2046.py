def main():
    a, b = map(int, input().split())
    ans = 0
    curra = a
    currb = 0
    while curra:
        ans += 1
        currb += 1
        curra -= 1
        if not curra:
            curra = currb // b
            currb %= b
    print(ans)
    pass


if __name__ == '__main__':
    main()
