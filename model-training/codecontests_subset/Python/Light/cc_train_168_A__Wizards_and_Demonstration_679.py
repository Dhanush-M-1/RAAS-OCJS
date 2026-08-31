a,b,c=map(int,input().split())
x=a*c
y=0
if x%100!=0: y=1
y+=(int(x/100))
if b>=y:print(0)
else:print(y-b)
