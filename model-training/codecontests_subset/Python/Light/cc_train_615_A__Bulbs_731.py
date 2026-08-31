if __name__ == '__main__':
    n, m = map(int, input().split())
    s = set()
    for _ in range(n):
        s.update(map(int, input().split()[1:]))
    print('YES' if len(s) == m else 'NO')
