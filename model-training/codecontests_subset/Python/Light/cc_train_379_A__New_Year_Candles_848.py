a,b=map(int,input().strip().split(' '))
res=0
while a>=b:
   res+=a-a % b
   a=a//b+a % b
res+=a
print(res)