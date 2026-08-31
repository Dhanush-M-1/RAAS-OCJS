import sys

int1 = lambda x: int(x) - 1
p2D = lambda x: print(*x, sep="\n")
def II(): return int(sys.stdin.readline())
def MI(): return map(int, sys.stdin.readline().split())
def LI(): return list(map(int, sys.stdin.readline().split()))
def LLI(rows_number): return [LI() for _ in range(rows_number)]
def SI(): return sys.stdin.readline()[:-1]

class BitSum:
    def __init__(self, n):
        self.n = n + 3
        self.table = [0] * (self.n + 1)

    def add(self, i, x):
        i += 1
        while i <= self.n:
            self.table[i] += x
            i += i & -i

    def sum(self, i):
        i += 1
        res = 0
        while i > 0:
            res += self.table[i]
            i -= i & -i
        return res

def main():
    n = II()
    xx = LI()
    vv = LI()
    itox = list(sorted(set(xx)))
    xtoi = {x: i for i, x in enumerate(itox)}
    #print(itox)
    #print(xtoi)
    vx = [(v, x) for x, v in zip(xx, vv)]
    cnt = BitSum(len(itox))
    val = BitSum(len(itox))
    ans = 0
    for v, x in sorted(vx):
        i = xtoi[x]
        if i: ans += cnt.sum(i - 1) * x - val.sum(i - 1)
        cnt.add(i,1)
        val.add(i,x)
    print(ans)

main()
