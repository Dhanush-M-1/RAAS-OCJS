
import sys
def data():
    return sys.stdin.readline().strip()
    
def sp(): return map(int, data().split())    
def l(): return list(sp())
 
def ans(arr):
    s=0
    games=len(arr)*(len(arr)-1)
    home={}
    away={}
    for i in range(1,101):
        home[i]=0
        away[i]=0
        for x,y in enumerate(arr):
            if i==y[0]:
                home[i]+=1
            elif i==y[1]:
                away[i]+=1
        
    for i in range(1,101):
        p=home[i]*away[i]
        s+=p
    return s
n=int(data()) 
arr=[]
for _ in range(n):
    arr.append(l())

print(ans(arr))