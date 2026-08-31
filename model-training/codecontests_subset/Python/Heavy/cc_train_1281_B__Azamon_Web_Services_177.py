from sys import stdin, stdout
import math
import heapq
import collections
input = stdin.readline
def inputnum():
    return(int(input()))
def inputnums():
    return(map(int,input().split()))
def inputlist():
    return(list(map(int,input().split())))
def inputstring():
    return([x for x in input()])
def inputstrings():
    return([x for x in input().split()])
def inputstringnum():
    return([ord(x)-ord('a') for x in input()])
def inputmatrixchar(rows):
    arr2d = [[j for j in input().strip()] for i in range(rows)] 
    return arr2d
def inputmatrixint(rows):
    arr2d = []
    for _ in range(rows):
        arr2d.append([int(i) for i in input().split()])
    return arr2d
    
t = int(input())
for q in range(t):
    l = inputstring()
    s = []
    c = []
    space = False
    for i in range(len(l)):
        if l[i] == ' ':
            space = True
            continue
        if not space:
            s.append(l[i])
        elif l[i] != '\n':
            c.append(l[i])
    s1 = ''
    c1 = ''
    for i in range(len(s)):
        s1 += s[i]
    for i in range(len(c)):
        c1 += c[i]
    if s1 < c1:
        print(s1)
        continue
    sort = sorted(s)
    ind1 = 0
    ind2 = 0
    for i in range(len(sort)):
        if s[i] != sort[i]:
            ind1 = i
            break
    for i in range(ind1+1, len(sort)):
        if s[i] == sort[ind1]:
            ind2 = i
    s[ind1], s[ind2] = s[ind2], s[ind1]
    if s < c:
        for i in range(len(s)):
            print(s[i], end = '')
        print()
    else:
        print('---')