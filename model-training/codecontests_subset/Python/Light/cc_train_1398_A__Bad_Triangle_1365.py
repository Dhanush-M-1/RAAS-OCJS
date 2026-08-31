for _ in range(int(input())):
   n=int(input())
   a=list(map(int,input().split()))[:n]
   for i in range(n-2):
       if(a[0]+a[1]<=a[i+2]):
           print(1,2,i+3)
           d=0
           break
       else:
           d=1
   if(d==1):
       print('-1')