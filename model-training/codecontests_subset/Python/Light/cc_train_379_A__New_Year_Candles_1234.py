s = input().split()
a=int(s[0])
b=int(s[1])
res=0
i=1
while i<=a:
   if i%b==0:
      a+=1
   res+=1
   i+=1
print(res)
      
   
