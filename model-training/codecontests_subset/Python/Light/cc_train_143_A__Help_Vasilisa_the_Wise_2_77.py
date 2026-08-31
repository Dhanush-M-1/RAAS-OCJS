def main():
    from itertools import permutations
    r1, r2, c1, c2, d1, d2 = (int(s) for _ in (1, 2, 3) for s in input().split())
    for a, b, c, d in permutations(range(1, 10), 4):
        if a + b == r1 and c + d == r2 and a + c == c1 and b + d == c2 and a + d == d1 and b + c == d2:
            print(a, b)
            print(c, d)
            break
    else:
            print(-1)


if __name__ == '__main__':
    main()
