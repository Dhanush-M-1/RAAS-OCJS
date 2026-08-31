a,b=map(int,input().split())
time=0

while a>0:
 time=time+1
 a=a-1
 if time%b==0:
  a=a+1

print(time)
