from collections import Counter
import string
import math
import sys
def array_int():
    return [int(i) for i in sys.stdin.readline().split()]
def vary(arrber_of_variables):
    if arrber_of_variables==1:
        return int(sys.stdin.readline())
    if arrber_of_variables>=2:
        return map(int,sys.stdin.readline().split()) 
def makedict(var):
    return dict(Counter(var))
# i am noob wanted to be better and trying hard for that
def printDivisors(n): 
    divisors=[]  
    # Note that this loop runs till square root 
    i = 1
    while i <= math.sqrt(n): 
          
        if (n % i == 0) : 
              
            # If divisors are equal, print only one 
            if (n//i == i) : 
                divisors.append(i) 
            else : 
                # Otherwise print both 
                divisors.extend((i,n//i)) 
        i = i + 1
    return divisors

def countTotalBits(num):
     
     # convert number into it's binary and 
     # remove first two characters 0b.
     binary = bin(num)[2:]
     return(len(binary))
for _ in range(vary(1)):
    n=vary(1)
    arr=[]
    for i in range(n):
        arr.append([str(i) for i in input()])
    if arr[0][1]==arr[1][0]:
        count=0
        tt=[]
        if arr[n-2][n-1]==arr[0][1]:
            count+=1
            tt.append([n-1,n])
        if arr[n-1][n-2]==arr[0][1]:
            count+=1
            tt.append([n,n-1])
        print(count)
        for i in tt:
            print(*i)
    else:
        if arr[n-2][n-1]==arr[n-1][n-2]:
            if arr[0][1]==arr[n-2][n-1]:
                print(1)
                print(1,2)
            else:
                print(1)
                print(2,1)
        else:
            print(2)
            print(n-1,n)
            if arr[n-2][n-1]!=arr[0][1]:
                print(1,2)
            else:
                print(2,1)
        
    
        
    
        
    

	



                






    
    

    
    


    

    



    


    














        

    

            
    





        
        
   
