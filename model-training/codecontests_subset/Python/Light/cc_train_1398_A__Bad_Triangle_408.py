import sys, math


input = lambda: sys.stdin.readline().rstrip()
def pr(a, b, c):
    if a + b > c and a + c > b and c + b > a:
        return True
    return False


for i in range(int(input())):
    n = int(input())
    a = list(map(int, input().split()))
    f, t = a[0], a[1]
    ans = True
    for i in range(2, n):
        if not pr(f, t, a[i]):
            ans = False
            print(1, 2, i + 1)
            break
    if ans:
        print(-1)
