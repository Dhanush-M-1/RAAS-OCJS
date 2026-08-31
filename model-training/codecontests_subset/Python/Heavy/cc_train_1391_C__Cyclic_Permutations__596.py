# Contest No.: 663
# Problem No.: C
# Solver:      JEMINI
# Date:        20200809

import sys
import heapq

def main():
    n = int(input())
    modVal = 10 ** 9 + 7
    ans = [0] * (n + 1)
    ans[3] = 4
    ansVal = 1
    diffVal = 1
    for i in range(1, n + 1):
        ansVal *= i
        ansVal %= modVal
    for i in range(1, n):
        diffVal *= 2
        diffVal %= modVal
    ansVal -= diffVal
    ansVal %= modVal
    print(ansVal)
        
    return

if __name__ == "__main__":
    main()