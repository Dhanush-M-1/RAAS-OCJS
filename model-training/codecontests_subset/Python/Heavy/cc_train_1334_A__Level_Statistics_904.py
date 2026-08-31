import sys
import math
import heapq
import collections
def inputnum():
    return(int(input()))
def inputnums():
    return(map(int,input().split()))
def inputlist():
    return(list(map(int,input().split())))
def inputstring():
    return([x for x in input()])
def inputmatrixchar(rows):
    arr2d = [[j for j in input().strip()] for i in range(rows)] 
    return arr2d
def inputmatrixint(rows):
    arr2d = []
    for _ in range(rows):
        arr2d.append([int(i) for i in input().split()])
    return arr2d
    
t=int(input())
for q in range(t):
    n = inputnum()
    played = []
    cleared = []
    for i in range(n):
        p, c = inputnums()
        played.append(p)
        cleared.append(c)
    done = False
    if played[0] < cleared[0]:
        print("NO")
        done = True
        continue
    for i in range(1, n):
        if played[i]-played[i-1] < cleared[i]-cleared[i-1] or played[i] < played[i-1] or cleared[i] < cleared[i-1]:
            print ("NO")
            done = True
            break
    if not done:
        print ("YES")