x,y=[int(i) for i in input().split()]
sum=0
while x>0:
    x=x-1
    sum+=1
    if sum%y==0:
        x+=1
print(sum)