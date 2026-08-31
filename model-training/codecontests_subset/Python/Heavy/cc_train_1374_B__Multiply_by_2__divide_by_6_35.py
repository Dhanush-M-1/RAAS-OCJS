
import math
from collections import defaultdict
# prime
def f(n):
    num=n
    d=defaultdict(int)
     
    while n % 2 == 0:
        #print (2),
        d[2]=d[2]+1
        n = n / 2
   
    for i in range(3,4):
      
        while n % i== 0:
            #print (i)
            d[i]=d[i]+1
            n = n / i
 
    #print(d)
    tp=dict(d)
    #print(2**d[2] * 3**d[3],n)
    if 2**d[2] * 3**d[3]!=num:
        return (-1)
    #print("here")
    for i in tp:

        if i not in [2,3]:
            return (-1)
    return [d[2],d[3]] #2,3
    

for tc in range(int(input())):
    #al=list(map(int,input().split()))
    x=int(input())
    a=f(x)
    if type(a)==int:
        print(-1)
    elif a[0]>a[1]:
        print(-1)
    else:
        print(a[0]+2*(a[1]-a[0]))