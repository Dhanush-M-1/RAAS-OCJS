from sys import stdout
from sys import stdin
def get():
    return stdin.readline().strip()
def getf():
    return [int(i) for i in get().split()]
def put(a, end = "\n"):
    stdout.write(str(a) + end)
def putf(a, sep = " ", end = "\n"):
    stdout.write(sep.join(map(str, a)) + end)

def matrix(n, m, a = 0):
    return [[a for i in range(m)]for j in range(n)]

def transf(a, k):
    s = ""
    while(a >= k):
        s += str(a % k)
        a //= k
    s += str(a)
    return s[::-1]

def main():
    n = int(get())
    t = matrix(n - 1, n - 1)
    for i in range(1, n):
        for j in range(1, n):
            t[i - 1][j - 1] = transf(i*j, n)
    for i in t:
        putf(i)
main()
