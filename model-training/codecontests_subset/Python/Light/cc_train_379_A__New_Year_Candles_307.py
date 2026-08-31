import math
a,b=map(int,input().split())
count=a
left=0
while(a>0):
    a+=left
    count+=math.floor((a)/b)
    left=(a)%b
    a=math.floor(a/b)
    check=math.floor((a+left)/b)
    if(check<0):
        a=0
print(int(count))