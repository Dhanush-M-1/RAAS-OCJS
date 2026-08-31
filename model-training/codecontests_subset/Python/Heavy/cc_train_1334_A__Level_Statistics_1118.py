# Contest No.: Edu 85
# Problem No.: A
# Solver:      JEMINI
# Date:        20200410

import sys

def main():
    t = int(input())
    for _ in range(t):
        n = int(sys.stdin.readline().strip())
        flag = True
        tempP = None
        tempC = None
        for i in range(n):
            p, c = map(int, sys.stdin.readline().split())
            if not flag:
                continue
            else:
                if p < c:
                    flag = False
                    continue
                if tempP == None:
                    tempP = p
                    tempC = c
                elif p - tempP < c - tempC or p < tempP or c < tempC:
                    flag = False
                    continue
                else:
                    tempC = c
                    tempP = p
        if flag:
            print("YES")
        else:
            print("NO")
    return

if __name__ == "__main__":
    main()