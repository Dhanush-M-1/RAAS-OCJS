from math import floor
a=list(map(int,input().split()))
count=0
while a[0]!=count:
    count=count+1
    if count%a[1]==0: 
        a[0]=a[0]+1

print(count)
