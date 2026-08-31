def main():
    s, n = input().rsplit(sep="= ", maxsplit=2)
    n = int(n)
    m = s.count('-')
    p = s.count('+') + 1
    if p * n - m < n or p - m * n > n:
        print("Impossible")
        return
    x = (n + m) // p
    if x:
        src = ([x + 1] * ((n + m) % p) + [x] * (p - (n + m) % p), [1] * m)
    else:
        x = (p - n) // m
        src = ([1] * p, [x + 1] * ((p - n) % m) + [x] * (m - (p - n) % m))
    res = [str(src[0].pop())]
    for c in s[2:len(s):4]:
        res.append(c)
        res.append(str(src[c == '-'].pop()))
    res.append('=')
    res.append(str(n))
    print("Possible")
    print(' '.join(res))


if __name__ == '__main__':
    main()
