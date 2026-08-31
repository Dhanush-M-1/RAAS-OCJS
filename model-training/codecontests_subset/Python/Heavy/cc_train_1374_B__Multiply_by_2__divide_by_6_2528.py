from sys import stdin, stdout  
import math
def primeFactors(n,arr,flgg): 
      
    while n % 2 == 0: 
        arr.append(2) 
        n = n // 2
    
    for i in range(3,int(math.sqrt(n))+1,2):    
        if(i!=3):
            flgg=1
            break
        while n % i== 0:
            arr.append(i) 
            n = n // i 
              
    if n > 2: 
        arr.append(n) 


t=int(stdin.readline())
for _ in range(t):
    n=int(stdin.readline() )
    #x,y,n=(map(int, stdin.readline().strip().split()))
    #arr=list(map(int, stdin.readline() .strip().split()))
    #s=input()

    #stdout.write(str(cp))
    #stdout.write("\n")
    arr=[]
    xx=0
    primeFactors(n,arr,xx)

    tw=0
    th=0
    flg=0
    for i in arr:
        if(i==2):
            tw+=1
        elif(i==3):
            th+=1
        else:
            flg=1

    if(not flg and tw<=th):
        print(th-tw+th)
    else:
        print(-1)
