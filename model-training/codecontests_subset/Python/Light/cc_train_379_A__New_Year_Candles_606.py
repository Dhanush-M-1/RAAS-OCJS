def main():
    a, b = [int(v) for v in input().split()]
    s = a
    d = a
    while d >= b:
        v = d // b
        d = v + d % b
        s += v
    print(s)


if __name__ == "__main__":
    main()
