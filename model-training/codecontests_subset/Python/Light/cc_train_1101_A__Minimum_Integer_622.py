import math
sa=lambda :input()
sb=lambda:int(input())
sc=lambda:input().split()
sd=lambda:list(map(int,input().split()))
se=lambda:float(input())
sf=lambda:list(input())
#10101001
def hnbhai():
    l,r,d=sd()
    
    temp=d
    while(temp>=l and temp<=r):
        temp+=d
        if temp>=l and temp<=r:
            temp=(r//d+1)*d
            break
    print(temp)
for _ in range(sb()):
    hnbhai()        
