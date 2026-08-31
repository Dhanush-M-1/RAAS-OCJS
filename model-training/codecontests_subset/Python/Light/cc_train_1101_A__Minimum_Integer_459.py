n=int(input())
for i in range(n):
  (l,r,d)=input().split(" ")
  (l,r,d)=(int(l),int(r),int(d))
  checker=True
  fac=1
  if(r>=d>=l):
    print(d*(int(r/d)+1))
  else:
    print(d)
    
      
      
  