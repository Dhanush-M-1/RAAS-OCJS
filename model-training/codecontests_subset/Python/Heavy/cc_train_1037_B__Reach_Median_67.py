n, median = input().split()
n=int(n)
median=int(median)
 
myArr =  [int(i) for i in input().split()]


        

myArr.sort()
midIndex =int( n/2)
cost=0
k=midIndex



if myArr[midIndex]!=median:
    while(k>=0):
      if myArr[k]>median:
         cost=cost+myArr[k]-median
      else:
          break
      k=k-1
       
    for j in range(midIndex,n):
      if myArr[j]<median:
         cost = cost + median-myArr[j]
      else:
          break
         
         
print(cost)

    
        
    
    