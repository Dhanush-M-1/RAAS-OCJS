from sys import stdin

def readline():
    return stdin.readline()

tests = int(readline())

def solve(n, a):
    i = 0
    j = 1
    k = n - 1
    if a[k] >= a[i] + a[j] or a[i] >= a[k] + a[j] or a[j] >= a[i] + a[k]:
        return str(i + 1) + ' ' + str(j + 1) + ' ' + str(k + 1)
    return -1


for t in range(0, tests):
    n = int(readline().rstrip("\n"))
    #n, d, m = list(map(int, readline().rstrip("\n").split(' ')))
    a = list(map(int, readline().rstrip("\n").split(' ')))
    print(solve(n, a))
