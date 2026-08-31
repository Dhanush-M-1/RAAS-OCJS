a,b=[int(x) for x in input().split()]
count=0
i=1
while(i<=a):
    if(i%b==0):
        a=a+1
    i=i+1
print(a)