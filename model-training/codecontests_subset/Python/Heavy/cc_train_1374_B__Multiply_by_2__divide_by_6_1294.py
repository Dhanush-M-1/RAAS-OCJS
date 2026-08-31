import sys

int1 = lambda x: int(x) - 1
p2D = lambda x: print(*x, sep="\n")
def II(): return int(sys.stdin.readline())
def MI(): return map(int, sys.stdin.readline().split())
def LI(): return list(map(int, sys.stdin.readline().split()))
def LLI(rows_number): return [LI() for _ in range(rows_number)]
def SI(): return sys.stdin.readline()[:-1]

def main():
    for _ in range(II()):
        n=II()
        c2=c3=0
        while n%3==0:
            n//=3
            c3+=1
        while n%2==0:
            n//=2
            c2+=1
        if n==1 and c3>=c2:
            print(2*c3-c2)
        else:
            print(-1)

main()