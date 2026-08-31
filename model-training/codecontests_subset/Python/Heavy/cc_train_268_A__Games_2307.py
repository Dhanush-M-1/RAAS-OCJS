import sys

import sys
def data():
    return sys.stdin.readline().strip()
    
def sp(): return map(int, data().split())    
def l(): return list(sp())
 
def ans(arr,n):
    c=0
    home=[]
    away=[]
    for x,y in enumerate(arr):
        home.append(y[0])
        away.append(y[1])
    
    for i in range(0,n):    
        for j in range(0,n):
            if i!=j and home[i]==away[j]:
                c+=1
    return c
n=int(data())
arr=[]
for _ in range(n):
    arr.append(l())

print(ans(arr,n))    