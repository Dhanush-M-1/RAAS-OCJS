n, k = map(int, input().split())
l = list(map(int, input().split()))
l.sort(reverse=True)
def solve():
    for e in l:
        if ((k%e) == 0):
            return k // e
    return -1
print(solve())

