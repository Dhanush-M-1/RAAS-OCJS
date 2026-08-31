n=int(input())
weidian=[]
changdu=[]
s=2
for i in range (n):
         w=list(map(int,input().split()))
         weidian.append(w[0])
         changdu.append(w[1])
if n==1:
         print("1")
else:

         for i in range(1,n-1):
                  if weidian[i]-changdu[i]>weidian[i-1]:
                           s+=1
                  elif weidian[i]+changdu[i]<weidian[i+1]:
                           s+=1
                           weidian[i]+=changdu[i]                 
         print(s)        
                  
         
