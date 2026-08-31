def int_lst_input():
    return [int(val) for val in input().split()]


def int_input():
    return int(input())


def print_lst(lst):
    print(' '.join([str(val) for val in lst]))


def dec_ab_inc_stones(a, b, stones):
    return a - 1, b - 2, stones + 3


def solve():
    t = int_input()

    for _ in range(t):
        a, b, c = int_lst_input()

        if b == 0:
            print(0)
            continue

        # otherwise check whether c or b is greater
        ans, cnt = 0, 0

        # We take from left side first
        x = min(a, b // 2)
        rem = b - (2 * x)
        cnt += 3 * x
        x = min(rem, c // 2)
        cnt += 3 * x

        ans = cnt
        cnt = 0

        # Now we take from right side first
        x = min(b, c // 2)
        rem = b - x
        cnt += 3 * x
        x = min(rem // 2, a)
        cnt += 3 * x

        print(max(ans, cnt))


if __name__ == '__main__':
    solve()
