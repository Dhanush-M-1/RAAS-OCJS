#Consistency is the key :)
#code by: amrit2000
from sys import stdin,stdout
import math
input=stdin.readline
def print(x='',y='',end='\n'):
    if y=='':
        stdout.write(str(x)+end)
    else:
        stdout.write(str(x)+' '+str(y)+end)

def solve():
    n=int(input())
    if n==1:
        print(0)
        return

    cnt3,cnt2=0,0
    p=n
    c=0
    while n%6==0:
        n//=6
        c+=1
    if n==1:
        print(c)
        return
    p=n

    while n%3==0:
        n//=3
        cnt3+=1
    if cnt3==0:
        print(-1)
        return
    x=(2**cnt3)*p
    if 6**int(math.log(x,6))!=x:
        print(-1)
        return
    
    
    print(cnt3*2+c)
            
            
        


    
        
tt=1
tt=int(input())
for __ in range(tt):
    solve()
