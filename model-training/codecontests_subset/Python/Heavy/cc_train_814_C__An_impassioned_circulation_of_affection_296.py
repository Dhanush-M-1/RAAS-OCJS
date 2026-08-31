from sys import stdin
from sys import stdout


def main():
    n = int(stdin.readline())
    s = stdin.readline()
    d = {chr(i): [0 for j in range(n + 1)] for i in range(97, 123)}
    for i in range(97, 123):
        for j in range(n):
            dp = 1 if s[j] == chr(i) else 0
            d[chr(i)][1 - dp] = max(d[chr(i)][1 - dp], 1)
            for u in range(j + 1, n):
                if s[u] == chr(i):
                    dp += 1
                d[chr(i)][u - j + 1 - dp] = max(d[chr(i)][u - j + 1 - dp], u - j + 1)
    q = int(stdin.readline())
    for i in range(q):
        m, c = stdin.readline().split()
        m = int(m)
        res = d[c][m]
        if res == 0:
            res = n
        stdout.write(str(res) + '\n')

main()