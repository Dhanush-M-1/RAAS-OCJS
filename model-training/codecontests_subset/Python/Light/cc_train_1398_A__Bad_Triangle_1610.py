

def f(a):
    
     if a[0]+a[1]<=a[-1]:
     	 return [1,2,len(a)]
     return -1


for _ in range(int(input())):
    n=int(input())
    #e=[int(x) for x in input().split()]
    #a=list(input())
    #b=list(input())
    a=[int(x) for x in input().split()]
 
    r=f(a)
  
    if r==-1:
    	print(-1)
    else:
       for x in r:
          print(x,end=" ")
       print()   	




