from sys import stdin

input = stdin.readline


def solve():
    n = int(input())
    s = [''] * n
    for i in range(n):
        s[i] = input().strip()
    s1 = int(s[0][1])
    s2 = int(s[1][0])
    e1 = int(s[-1][-2])
    e2 = int(s[-2][-1])
    res = 0
    r = []
    if s1 == s2:
        if e1 == s1:
            res += 1
            r.append(f'{n} {n-1}')
        if e2 == s1:
            res += 1
            r.append(f'{n-1} {n}')
    else:
        if e1 == e2:
            if s1 == e1:
                res += 1
                r.append('1 2')
            if s2 == e1:
                res += 1
                r.append('2 1')
        else:
            if s1 == 0:
                res += 1
                r.append('1 2')
            if s2 == 0:
                res += 1
                r.append('2 1')
            if e1 == 1:
                res += 1
                r.append(f'{n} {n-1}')
            if e2 == 1:
                res += 1
                r.append(f'{n-1} {n}')
    print(res)
    if res != 0:
        print('\n'.join(r))




if __name__ == '__main__':
    t = int(input())
    for _ in range(t):
        solve()
