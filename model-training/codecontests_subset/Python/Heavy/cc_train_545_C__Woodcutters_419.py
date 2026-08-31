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
def printDivisors(n) : 
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
n=vary(1)
trees=[]
for i in range(n):
    u,v=vary(2)
    trees.append([u,v])
count=1
if n==1:
    print(count)
    exit()
trees.sort()
for i in range(n-2):
    if trees[i+1][0]-trees[i+1][1]>trees[i][0]:
        count+=1
    elif trees[i+1][0]+trees[i+1][1]<trees[i+2][0]:
        count+=1
        trees[i+1][0]=trees[i+1][0]+trees[i+1][1]
print(count+1)


    
    


    

    



    


    














        

    

            
    





        
        
   
