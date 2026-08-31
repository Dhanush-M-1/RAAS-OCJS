from sys import stdin
import heapq


# Driver function 

T=int(input())
for case in range(T):
    
        
    num1,num2 = [int(x) for x in stdin.readline().split()]
    lst1=[]
    lst1 = [int(item) for item in input().split()] 
    flag=False
    lst2=[]
    lst2 = [int(item) for item in input().split()]
    for i in range(num2):   
        if lst1.count(lst2[i])!=0:
            print("YES")
            print(1,end=" ")
            print(lst2[i])
            flag=True
            break
    if not flag:
        print("NO")
    


        
      
    



