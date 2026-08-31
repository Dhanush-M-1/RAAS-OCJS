import sys
from array import array  # noqa: F401
import typing as Tp  # noqa: F401


def input():
    return sys.stdin.buffer.readline().decode('utf-8')


def output(*args):
    sys.stdout.buffer.write(
        ('\n'.join(map(str, args)) + '\n').encode('utf-8')
    )


def main():
    t = int(input())
    ans_a = [''] * t

    for ti in range(t):
        n = int(input())
        mat = [input().rstrip() for _ in range(n)]
        cells = [mat[0][1], mat[1][0], mat[-1][-2], mat[-2][-1]]
        ans = []

        if len(set(cells)) == 1:
            ans.extend(['1 2', '2 1'])
        elif cells[0] == cells[1] and cells[2] == cells[3]:
            pass
        elif cells[0] == cells[1]:
            if cells[0] == cells[2]:
                ans.append(f'{n} {n-1}')
            if cells[0] == cells[3]:
                ans.append(f'{n-1} {n}')
        elif cells[2] == cells[3]:
            if cells[0] == cells[3]:
                ans.append('1 2')
            if cells[1] == cells[3]:
                ans.append('2 1')
        else:
            if cells[0] == '1':
                ans.append('1 2')
            if cells[1] == '1':
                ans.append('2 1')
            if cells[2] == '0':
                ans.append(f'{n} {n-1}')
            if cells[3] == '0':
                ans.append(f'{n-1} {n}')

        ans_a[ti] = f'{len(ans)}\n' + '\n'.join(ans)

    output(*ans_a)


if __name__ == '__main__':
    main()
