import sys,collections,math
######################################
def in_out():
    sys.stdin = open('input.txt', 'r')  
    sys.stdout = open('output.txt', 'w')
#in_out()
######################################

from collections import Counter
for _ in range(int(input())):
    n,m = list(map(int,input().split()))
    a = list(map(int,input().split()))
    b = list(map(int,input().split()))
    f=0
    for ele in a:
        if ele in b:
            print('YES')
            print(1,ele)
            f=1
            break
    if f==0:
        print('NO')