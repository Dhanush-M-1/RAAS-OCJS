if __name__ == '__main__':
    a, b = [int(x) for x in input().split()]
    ans = a
    while a >= b:
        n = a // b
        ans += n
        a = n + a % b
    print(ans)