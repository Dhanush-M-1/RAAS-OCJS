import sys
import math
import bisect
import itertools

def main():
    A = [1, 2]
    B = []
    for _ in range(int(input())):
        a = int(input())
        B.append(a)
    #print('B: ' + str(B))
    ans = True
    for a in B:
        if a not in A:
            ans = False
        else:
            b = sum(A) - a
            c = 6 - a - b
            A.remove(b)
            A.append(c)
        '''
        print(' => %d' % (a))
        print('A: ' + str(A))
        '''
    if ans:
        print('YES')
    else:
        print('NO')

if __name__ == "__main__":
    main()
