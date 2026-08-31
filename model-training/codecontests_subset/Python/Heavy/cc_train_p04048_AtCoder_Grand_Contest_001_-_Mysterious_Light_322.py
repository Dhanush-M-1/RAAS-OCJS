import sys
input = sys.stdin.readline
sys.setrecursionlimit(10 ** 7)

n, x = map(int, input().split())

ans = 0
ans += n

l1, l2 = min(n - x, x), max(n - x, x)
#while True:
#    if l1 == l2:
#        ans += l1
#        break
#    else:
#        ans += (l1 * 2)
#        l1, l2 = min(l1, l2 -l1), max(l1, l2 - l1)
#while True:
#    if l2 % l1 == 0:
#        ans += (l1 * ((l2 // l1) * 2 - 1))
#        break
#    else:
#        ans += (l1 * 2)
#        l1, l2 = min(l1, l2 -l1), max(l1, l2 - l1)
while True:
    if l2 % l1 == 0:
        ans += (l1 * ((l2 // l1) * 2 - 1))
        break
    else:
        ans += (l1 * 2) * (l2 // l1)
        l1, l2 = l2 % l1, l1

print(ans)
