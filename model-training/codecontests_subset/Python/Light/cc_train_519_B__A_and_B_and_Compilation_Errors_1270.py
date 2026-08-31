import sys
import math
import bisect

def main():
    n = int(input())
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))
    C = list(map(int, input().split()))
    '''
    print('A: %s' % (str(A)))
    print('B: %s' % (str(B)))
    print('C: %s' % (str(C)))
    '''
    x = 0
    for a in A:
        x ^= a
    for b in B:
        x ^= b
    print(x)
    x = 0
    for b in B:
        x ^= b
    for c in C:
        x ^= c
    print(x)

    
if __name__ == "__main__":
    main()
