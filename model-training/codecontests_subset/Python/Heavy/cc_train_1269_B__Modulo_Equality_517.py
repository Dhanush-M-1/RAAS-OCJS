from collections import Counter


def read_nums():
    return [int(x) for x in input().split()]


def check_match(rs, m, ca, cb):
    for key, val in ca.items():
        if not val == cb[(key + rs) % m]:
            return False
    return True


def main():
    n, m = read_nums()
    a = [x % m for x in read_nums()]
    b = [x % m for x in read_nums()]
    ca = Counter(a)
    cb = Counter(b)

    ma = sum(a) % m
    mb = sum(b) % m

    options = []
    for elem_a in ca:
        for elem_b in cb:
            rs = (elem_b - elem_a) % m
            if not (ma + rs * n) % m == mb:
                continue
            if check_match(rs, m, ca, cb):
                options.append(rs)

    res = min(options)
    print(res)


if __name__ == '__main__':
    main()
