a,b = [int(i) for i in input().split()]
c = 0
i = 1
while a!=0:
    if i%b==0:
        a+=1
    a-=1
    c+=1
    i+=1
print(c)
