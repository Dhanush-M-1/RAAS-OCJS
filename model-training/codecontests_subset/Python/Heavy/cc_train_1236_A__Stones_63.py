
def solve(a, b, c):
    x = min(c//2, b)
    return 3*(x + min(a, (b-x)//2))


def solve2(a, b, c):
    global d

    if (a, b, c) in d: 
        return d[(a, b, c)]

    op1 = a >= 1 and b >= 2
    op2 = b >= 1 and c >= 2

    if not (op1 or op2): x = 0
    elif not op1 and op2: x = solve2(a, b - 1, c - 2) + 3
    elif op1 and not op2: x = solve2(a - 1, b - 2, c) + 3
    else: x = max(solve2(a - 1, b - 2, c), solve2(a, b - 1, c - 2)) + 3

    d[(a, b, c)] = x
    return x


def main():
    global d
    for _ in range(int(input())):
        a, b, c = list(map(int, input().split()))
        #print(solve(a, b, c))
        d = {}
        print(solve2(a, b, c))


main()
