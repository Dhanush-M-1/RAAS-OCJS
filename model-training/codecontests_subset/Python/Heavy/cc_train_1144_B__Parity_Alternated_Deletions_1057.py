from sys import stdin
def ip(): return [int(i) for i in stdin.readline().split()]
def sp(): return [str(i) for i in stdin.readline().split()]
def pp(A): 
    for i in A: print(i)


def solve():
    n = int(input())
    A = ip()
    A.sort()
    O,E = [], []
    for i in A:
        if i % 2 == 0: E.append(i)
        else: O.append(i)
    ans = 0
    if len(O) > len(E):
        for i in range(len(O) - len(E) - 1):
            ans += O[i]
        return ans
    elif len(E) > len(O):
        for i in range(len(E) - len(O) - 1):
            ans += E[i]
        return ans
    else: return 0

print(solve())