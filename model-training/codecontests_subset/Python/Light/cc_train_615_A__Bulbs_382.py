def int_lst_input():
    return [int(val) for val in input().split(' ')]

def int_input():
    return int(input())

def print_lst(lst):
    print(' '.join([str(val) for val in lst]))

def solve():
    n, m = int_lst_input()

    state = [False for _ in range(m)]
    for _ in range(n):
        _, *y = int_lst_input()

        for val in y:
            state[val - 1] = True

    print('YES' if all(state) else 'NO')


if __name__ == '__main__':
    solve()

