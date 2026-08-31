a,b=map(int,input().split())
count=0
while a>=b:
  count+=b
  a-=b
  a+=1
print(count+a)