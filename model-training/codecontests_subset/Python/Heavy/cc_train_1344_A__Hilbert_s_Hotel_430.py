import sys
import math
def inputnum():
    return(int(input()))
def inputnums():
    return(map(int,input().split()))
def inputlist():
    return(list(map(int,input().split())))
def inputstring():
    return([x for x in input()])

t=int(input())
for q in range(t):
    n = inputnum()
    a = inputlist()
    good = True
    for i in range(len(a)):
        a[i] = ((i + a[i])%n + n)%n
    for i in range(1, len(a)):
        for j in range(0, i):
            if i != j and a[i] == a[j]:
                good = False
                break
        if not good:
            break
    if good:
        print ("YES")
    else: 
        print ("NO")