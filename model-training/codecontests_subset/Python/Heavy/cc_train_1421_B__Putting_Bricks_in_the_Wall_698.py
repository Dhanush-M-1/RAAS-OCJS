import sys

sys.setrecursionlimit(10**5)
int1 = lambda x: int(x)-1
p2D = lambda x: print(*x, sep="\n")
def II(): return int(sys.stdin.buffer.readline())
def MI(): return map(int, sys.stdin.buffer.readline().split())
def LI(): return list(map(int, sys.stdin.buffer.readline().split()))
def LLI(rows_number): return [LI() for _ in range(rows_number)]
def BI(): return sys.stdin.buffer.readline().rstrip()
def SI(): return sys.stdin.buffer.readline().rstrip().decode()

for _ in range(II()):
    n = II()
    ss = [SI() for _ in range(n)]
    ans = []
    if ss[0][1] == ss[1][0]:
        c = ss[0][1]
        if ss[-1][-2] == c: ans.append((n, n-1))
        if ss[-2][-1] == c: ans.append((n-1, n))

    elif ss[-1][-2] == ss[-2][-1]:
        c = ss[-1][-2]
        if ss[0][1] == c: ans.append((1, 2))
        if ss[1][0] == c: ans.append((2, 1))

    else:
        if ss[-1][-2] == "1": ans.append((n, n-1))
        if ss[-2][-1] == "1": ans.append((n-1, n))
        if ss[0][1] == "0": ans.append((1, 2))
        if ss[1][0] == "0": ans.append((2, 1))

    print(len(ans))
    for i, j in ans: print(i, j)
