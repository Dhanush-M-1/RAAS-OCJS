import sys as _sys


def main():
    t = int(input())
    for i_t in range(t):
        n, = _read_ints()
        left_borders = []
        right_borders = []
        for i_segment in range(n):
            l, r = _read_ints()
            left_borders.append(l)
            right_borders.append(r)
        result = max(left_borders) - min(right_borders)
        if result < 0:
            result = 0
        print(result)


def _read_line():
    result = _sys.stdin.readline()
    assert result[-1] == "\n"
    return result[:-1]


def _read_ints():
    return map(int, _read_line().split())


if __name__ == '__main__':
    main()
