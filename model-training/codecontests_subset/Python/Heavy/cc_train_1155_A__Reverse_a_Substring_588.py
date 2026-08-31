import sys
import math
import bisect
import itertools
import random

def main():
    n = int(input())
    s = input()
    A = []
    for i in range(n):
        A.append(ord(s[i]) - ord('a'))
    #print('s: %s' % (s))
    #print('A: %s' % (str(A)))
    d = dict()
    ans = None
    for i in range(n):
        for t in range(A[i] + 1, 27):
            if t in d:
                ans = [d[t], i]
                break
        if ans != None:
            break
        d[A[i]] = i
    if ans == None:
        print('NO')
    else:
        print('YES')
        print('%d %d' % (ans[0] + 1, ans[1] + 1))

if __name__ == "__main__":
    main()
