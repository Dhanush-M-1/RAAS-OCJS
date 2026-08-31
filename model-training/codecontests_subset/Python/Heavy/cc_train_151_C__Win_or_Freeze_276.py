import math 
def prime(n): 
    while n % 2 == 0: 
        lis.add(2) 
        n = n / 2
    for i in range(3,int(math.sqrt(n))+1,2): 
        while n % i== 0: 
            lis.add(i) 
            n = n / i 
    if n > 2: 
        lis.add(n)

n = int(input())
lis=set()
n1=n
if n==1:
    print(1)
    print(0)
    exit()
prime(n)
lis = list(lis)
#print(lis)    
if len(lis)==2 and int(lis[0]*lis[1])==n:
    print(2)
elif len(lis)==1:
    c=0
    while n1%lis[0]==0:
        c+=1
        n1 = n1//lis[0]
    if c==2:
        print(2)
    elif c==1:
        print(1)
        print(0)    
    else:
        print(1)
        print(lis[0]**(2))        
else:
    print(1)
    print(int(lis[0]*lis[1]))
