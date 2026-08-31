from math import * 
n=int(input())

if(n<=500):
     for i in range(n):
         l=[int(i) for i in input().split()]
         
         if((l[0]>=1 and l[0]<=pow(10,9)) and (l[1]>=1 and l[1]<=pow(10,9)) and (l[2]>=1 and l[2]<=pow(10,9))):
             j=1
             s=0
             while(1):
                 if(l[0]==1):
                     if(l[1]<l[2]):
                         s=l[2]
                         break
                     elif(l[1]%l[2]==0):
                         s=l[1]+l[2]
                         break
                     elif(l[1]%l[2]!=0):
                         k=l[1]%l[2]
                         s=l[1]+l[2]-k
                         break
                 elif(l[0]<=l[2]):
                     if(l[1]<l[2]):
                         s=l[2]
                         break
                     elif(l[1]%l[2]==0):
                         s=l[1]+l[2]
                         break
                     elif(l[1]%l[2]!=0):
                         k=l[1]%l[2]
                         s=l[1]+l[2]-k
                         break
                 else:
                     s=l[2]*j
                     
                     if(l[0]>s or s>l[1]):
                         break
                 j+=1   
                 
             print(s)
             
                  
    
        
    