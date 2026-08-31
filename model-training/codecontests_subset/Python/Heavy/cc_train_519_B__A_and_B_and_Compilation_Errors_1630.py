# Author Kmoussai 
import sys
import math
import random
'''
i = 0
while i < n:
    
    i += 1

map(int, input().split())


def pgcd(a, b):
    if b == 0:
        return a
    return pgcd(b, a%b)



'''
if len(sys.argv) >= 2:
    if sys.argv[1] == 'LOCAL':
        sys.stdin = open('input.in', 'r')

n = int(input())

s = input().split()
s1 = input().split()
s2 = input().split()

dect1 = {}
for i in s:
    try:
        dect1[i] += 1
    except:
        dect1[i] = 1
dect2 = {}
for i in s1:
    try:
        dect2[i] += 1
    except:
        dect2[i] = 1
dect3 = {}
for i in s2:
    try:
        dect3[i] += 1
    except:
        dect3[i] = 1
for i in dect1:
    try:
        if dect1[i] > dect2[i]:
            print(i)
            break
    except:
        print(i)
        break
for i in dect2:
    try:
        if dect3[i] < dect2[i]:
            print(i)
            break
    except:
        
        print(i)
        break
 