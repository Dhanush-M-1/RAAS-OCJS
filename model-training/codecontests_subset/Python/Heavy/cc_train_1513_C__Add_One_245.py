import sys
input=sys.stdin.readline

d=[0 for x in range(200001)]
d[0]=1
for i in range(1,10):
    d[i]=2
for i in range(10,200001):
    d[i]=(d[i-10]+d[i-9])%(10**9+7)
 
t =int(input())
 
for i in range(t):
    #n=int(input())
    n,m=map(int,input().split())
    #a=[int(x) for x in input().split()]
 
    n=list(str(n))
    count=[0 for x in range(10)]
    for i in n:
        count[int(i)]+=1
 
#    for i in range(m):
 #       temp=False
  #      temp1=count[9]
   #     if count[9]>0:
    #        temp=True
     #   for j in range(9,0,-1):
      #      count[j]=count[j-1]
       # count[0]=0
        #if temp:
         #   count[0]+=temp1
          #  count[1]+=temp1
 
    ans=0
    for i in range(10):
        temp=m-(9-i)
        if temp>0:
            ans+=d[temp]*count[i]
        else:
            ans+=count[i]
    print(ans%(10**9+7))