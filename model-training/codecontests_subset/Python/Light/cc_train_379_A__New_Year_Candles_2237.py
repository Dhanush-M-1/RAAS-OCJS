a,b=map(int,input().split())
k=a
while a>=b:
   k=k+a//b
   
   a=a//b+a%b

print(k)
