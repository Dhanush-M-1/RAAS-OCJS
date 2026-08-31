#Bhargey Mehta (Junior)
#DA-IICT, Gandhinagar
import sys, math
MOD = 998244353
#sys.stdin = open('input.txt', 'r')

def solve():
    n = int(input())
    a = list(map(int, input().split()))
    s = set()
    for i in range(n):
        if a[i] != -1:
            continue
        if 0 < i and a[i-1] != -1:
            s.add(a[i-1])
        if i+1 < n and a[i+1] != -1:
            s.add(a[i+1])
    if len(s) == 0:
        return '{} {}'.format(0, 0)
    
    k = (max(s)+min(s)) // 2
    ans = 0
    for i in range(n):
        if a[i] == -1:
            a[i] = k
    for i in range(1, n):
        ans = max(ans, abs(a[i]-a[i-1]))
    
    return '{} {}'.format(ans, k)

for test in range(1, int(input())+1):
    print(solve())