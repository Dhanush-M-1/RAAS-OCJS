a,b=map(int,input().split())
c=0
p=0
while a!=0:
   p+=1
   a-=1
   c+=1
   if c==b:
       a+=1
       c=0
print(p)
