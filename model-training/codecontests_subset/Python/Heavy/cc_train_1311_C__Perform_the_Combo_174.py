import sys

sys.setrecursionlimit(10 ** 6)
int1 = lambda x: int(x) - 1
p2D = lambda x: print(*x, sep="\n")
def II(): return int(sys.stdin.readline())
def MI(): return map(int, sys.stdin.readline().split())
def LI(): return list(map(int, sys.stdin.readline().split()))
def LI1(): return list(map(int1, sys.stdin.readline().split()))
def LLI(rows_number): return [LI() for _ in range(rows_number)]
def SI(): return sys.stdin.readline()[:-1]

def main():
    t=II()
    for _ in range(t):
        n,m=MI()
        s=SI()
        pp=LI1()
        pp.sort()
        ans=[0]*26
        a=ord("a")
        cnt=1
        for i in range(n-1,-1,-1):
            while pp and i==pp[-1]:
                cnt+=1
                pp.pop()
            ans[ord(s[i])-a]+=cnt
        print(*ans)

main()