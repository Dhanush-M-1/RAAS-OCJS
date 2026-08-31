from itertools import groupby

IMP = "0 0 0"


def solve(n, xs):
    if n <= 5:
        return IMP

    half = n // 2
    i = half
    while i > 0 and xs[i] == xs[i - 1]:
        i -= 1

    if i == 0 and xs[i] == xs[i + 1]:
        # Top half are all the same
        return IMP

    # i is the last index that differs in the top half.
    ys = [(x, len(list(b))) for x, b in groupby(xs[:i])]
    # print(ys)

    # Can't give silver and bronze unless there are at least 3 scores.
    if len(ys) < 3:
        return IMP

    # Give the minimum amount of gold possible.
    # Since g < s and g < b and g + s + b <= half
    # => g + (g + 1) + (g + 1) <= half
    # => 3g <= half - 2
    g = ys[0][1]
    if 3 * g > half - 2:
        return IMP

    # Then make sure there are just enough silver medals.
    s = 0
    ind = 1
    while s <= g and ind < len(ys):
        s += ys[ind][1]
        ind += 1

    if s < g:
        return IMP

    b = sum(y[1] for y in ys[ind:])
    if b <= g:
        return IMP

    return " ".join(map(str, (g, s, b)))


for _ in range(int(input())):
    n = int(input())
    xs = [int(x) for x in input().split()]
    print(solve(n, xs))
