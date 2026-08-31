d = {}

def solve(a, b):
    if a > b:
        a, b = b, a

    if a == b:
        return 0

    args = [(a % 2, (a // 2, b)),
            (a % 3, (a // 3, b)),
            (a % 5, (a // 5, b)),
            (b % 2, (a, b // 2)),
            (b % 3, (a, b // 3)),
            (b % 5, (a, b // 5))]
    res = []
    
    for cond, (arg1, arg2) in args:
        if not cond:
            tmp = d.get((arg1, arg2))
            if tmp is None:
                tmp = solve(arg1, arg2)
                d[(arg1, arg2)] = tmp
            if tmp != -1:
                res.append(tmp + 1)

    if res:
        return min(res)
    else:
        return -1


if __name__ == "__main__":
    a, b = map(int, input().split())
    print(solve(a, b))
