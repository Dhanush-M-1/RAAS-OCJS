#!/usr/bin/env python3

str = str(input())

if(len(str) == 1):
    print(str)
else:
    n1 = str.count('1')
    n2 = str.count('2')
    n3 = str.count('3')
    for i in range(n1):
        if(i == n1 - 1 and n2 == 0 and n3 == 0):
            print('1', end = '')
        else:
            print('1+', end = '')
    for j in range(n2):
        if(j == n2 - 1 and n3 == 0):
            print('2', end = '')
        else:
            print('2+', end = '')
    for k in range(n3):
        if(k != n3 - 1):
            print('3+', end = '')
        else:
            print('3', end = '')
