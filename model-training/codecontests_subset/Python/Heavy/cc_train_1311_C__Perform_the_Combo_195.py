from sys import stdin
t = int(stdin.readline())
z = [0] * t
for _ in range(t):
    n, m = map(int, stdin.readline().split())
    s = stdin.readline()[:n]
    p = list(map(int, stdin.readline().split()))
    d = {'a': 0, 'b': 0, 'c': 0, 'd': 0, 'e': 0, 'f': 0, 'g': 0, 'h': 0, 'i': 0, 'j': 0, 'k': 0, 'l': 0, 'm': 0, 'n': 0, 'o': 0, 'p': 0, 'q': 0, 'r': 0, 's': 0, 't': 0, 'u': 0, 'v': 0, 'w': 0, 'x': 0, 'y': 0, 'z': 0}
    y = [0] * n
    for i in range(m):
        y[p[i]-1] += 1
    for i in range(n-1, 0, -1):
        y[i-1] += y[i]
    for i in range(n):
        d[s[i]]+=y[i]+1
    z[_] = ' '.join(map(str, d.values()))
print(*z, sep='\n')