def main():
    r1, r2 = map(int, input().split())
    c1, c2 = map(int, input().split())
    d1, d2 = map(int, input().split())

    x1 = -0.5 * r2 + -0.5 * c2 + d1 + 0.5 * d2
    x2 = -0.5 * r2 + 0.5 * c2 + 0.5 * d2
    x3 = 0.5 * r2 + -0.5 * c2 + 0.5 * d2
    x4 = 0.5 * r2 + 0.5 * c2 + -0.5 * d2
    solutions = {x1, x2, x3, x4}
    if len(solutions) != 4:
        print(-1)
        return
    if all(0 < x <= 9 and x.is_integer() for x in solutions):
        print(int(x1), int(x2))
        print(int(x3), int(x4))
    else:
        print(-1)


if __name__ == '__main__':
    main()
