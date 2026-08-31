'''
for i in range(int(input())):
    n, k = map(int, input().split())
    a = list(input())

    ans = ['1'] * n
    t = 0
    for j in range(n):
        if (a[j] == '0'):
            s = min(k, j - t)
            k -= s
            ans[j - s] = '0'
            t += 1
    print("".join(ans))
'''

'''
import collections
def solve():
    # ? Yes as long as there is a slope > 1
    # n = map(int, input().split())
    n = int(input())
    s = list(map(int, input().split()))
    for i in range(len(s)-1):
        if abs(s[i] - s[i+1]) > 1:
            print('Yes')
            print(i+1, i+2)
            return
    print('No')


for _ in range(int(input())):
    solve()
'''
import collections
def decompose(n):
    ans = []
    i = 2
    while i*i <= n:
        cur = 0
        while n%i == 0:
            n //= i
            cur += 1
        if cur > 0:
            ans.append(i**cur)
        i += 1
    if n != 1:
        ans.append(n)
    return ans


def solve():
    # ? Yes as long as there is a slope > 1
    # n = map(int, input().split())
    n = int(input())
    if n == 1:
        print('1 1')
        return
    l = decompose(n)
    if len(l) == 1:
        print('1', n)
    else:
        cur = [1, n]
        ans = n
        combs = [[]]
        for num in l:
            for comb in combs[:]:
                tmp = comb + [num]
                s = 1
                for c in tmp:
                    s *= c
                if max(s, n//s) < ans:
                    ans = max(s, n//s)
                    cur = [s, n//s]
                combs.append(tmp)
        print(cur[0], cur[1])



for _ in range(1):
    solve()
