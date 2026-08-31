a,b=[int(i)for i in input().split()]
sum=a
while(1):
    c=a//b
    a=c+(a%b)
    sum+=c
    if(a<b):
        break
print(sum)
    
    