import sys

def answer(n, x, h):
    if n <= 2:
        return n
    cuttrees = 2
    L = x[0]
    for i in range(1, n-1):
        if x[i] - h[i] > L: #fell left
            L = x[i]
            cuttrees += 1
        elif x[i] + h[i] < x[i+1]: #fell right
            L = x[i] + h[i]
            cuttrees += 1
        else: #do not cut.
            L = x[i]
    return cuttrees

def main():
    n = int(sys.stdin.readline())
    x = [0 for i in range(n)]
    h = [0 for i in range(n)]
    for i in range(n):
        x[i], h[i] = map(int, sys.stdin.readline().split())
    print(answer(n, x, h))
    return
main()