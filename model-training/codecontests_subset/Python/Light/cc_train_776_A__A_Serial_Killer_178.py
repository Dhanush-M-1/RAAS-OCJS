import sys
import math
import bisect
import itertools

def main():
    ans = []
    A = input().split()
    ans.append(A.copy())
    n = int(input())
    for i in range(n):
        s, t = input().split()
        A.remove(s)
        A.append(t)
        ans.append(A.copy())
    for i in range(len(ans)):
        print(' '.join(ans[i]))

if __name__ == "__main__":
    main()
