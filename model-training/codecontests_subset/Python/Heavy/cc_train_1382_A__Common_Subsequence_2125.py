import sys

sys.setrecursionlimit(10 ** 6)
int1 = lambda x: int(x) - 1
p2D = lambda x: print(*x, sep="\n")
def II(): return int(sys.stdin.readline())
def MI(): return map(int, sys.stdin.readline().split())
def LI(): return list(map(int, sys.stdin.readline().split()))
def LLI(rows_number): return [LI() for _ in range(rows_number)]
def SI(): return sys.stdin.readline()[:-1]
def bit(xx):return [format(x,"b") for x in xx]
popcnt=lambda x:bin(x).count("1")

for _ in range(II()):
    SI()
    exs=[False]*1005
    for a in MI():
        exs[a]=True
    ans=[]
    for b in MI():
        if exs[b]:
            print("YES")
            print(1,b)
            break
    else:
        print("NO")
