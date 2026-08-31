import sys
from itertools import permutations
from itertools import combinations
from itertools import combinations_with_replacement
#sys.stdin = open('/Users/pranjalkandhari/Desktop/Template/input.txt', 'r')

for _ in range( int(input()) ):
    n = int(input())
    a = ''
    b = ''
    c = ''
    d = ''
    for i in range(0,n):
        li = list(input())
        if(i == 0):
            a = li[1]
        if(i == 1):
            b = li[0]
        if(i == n-2):
            c = li[n-1]
        if(i == n-1):
            d = li[n-2]

    comp = [a,b,c,d]

    a1 = ['0' , '0' , '1' , '1']
    a2 = ['1' , '1' , '0' , '0']

    n1 = 0
    n2 = 0

    for i in range(0,4):
        if(comp[i] != a1[i]):
            n1 += 1
        if(comp[i] != a2[i]):
            n2+=1
    
    ctr = 0

    if(n1<=2):
        print(n1)
        if(comp[0] != a1[0]):
            print('1 2')
        if(comp[1] != a1[1]):
            print('2 1')
        if(comp[2] != a1[2]):
            print(n-1,n)
        if(comp[3] != a1[3]):
            print(n,n-1)
    else:
        print(n2)
        if(comp[0] != a2[0]):
            print('1 2')
        if(comp[1] != a2[1]):
            print('2 1')
        if(comp[2] != a2[2]):
            print(n-1,n)
        if(comp[3] != a2[3]):
            print(n,n-1)

















