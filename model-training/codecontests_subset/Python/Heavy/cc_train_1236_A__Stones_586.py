# import pytest
#
#
# @pytest.mark.parametrize('line, result', [
#     ((3, 4, 5), 9),
#     ((1, 0, 5), 0),
#     ((5, 3, 2), 6),
# ])
# def test(line, result):
#     assert solve(*line) == result


def _solve(a: int, b: int, c: int) -> int:
    left = min(a, b // 2)
    a -= left
    b -= left * 2

    while left >= 0:
        right = min(b, c // 2)
        yield 3 * (left + right)
        left -= 1
        a += 1
        b += 2


def solve(a: int, b: int, c: int) -> int:
    return max(_solve(a, b, c), default=0)


def main():
    for _ in range(int(input())):
        a, b, c = map(int, input().split())
        print(solve(a, b, c))


if __name__ == '__main__':
    main()
