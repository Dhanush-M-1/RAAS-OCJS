import sys

readLine = lambda : sys.stdin.readline()
readInt = lambda : int(sys.stdin.readline())
readInts = lambda : [int(x) for x in sys.stdin.readline().split(" ")]

def main():
    solns = []
    t = readInt()
    for _ in range(t):
        n = readInt()
        valid = True
        p, c = readInts()
        if c > p:
            valid = False
        for l in range(1,n):
            nextP, nextC = readInts()
            if (nextC - c) > (nextP - p):
                valid = False # clears increase more than plays
            if (nextC < c):
                valid = False # clears decrease
            if (nextP < p):
                valid = False # plays decrease
            p = nextP
            c = nextC
        solns.append("YES" if valid else "NO")
    print("\n".join(solns))

main()