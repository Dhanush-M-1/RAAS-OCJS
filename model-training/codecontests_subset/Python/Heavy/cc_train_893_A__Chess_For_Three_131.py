l=lambda:map(int,input().split())
t=lambda:int(input())
ss=lambda:input()
#from math import log10 ,log2,ceil,factorial as f
#from itertools import combinations_with_replacement as c

n=t()
loss=0
for i in range(n):
    x=t()
    
    if loss==0 :
        if x==3:
            print("NO")
            break
        else:
            loss=3-x
    elif loss!=x:
        loss=6-(x+loss)
    else:
        print("NO")
        break
else:
    if loss:
        print("YES")
    else:
        print("NO")

        
            