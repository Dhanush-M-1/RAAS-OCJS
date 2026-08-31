a,b =[int(i) for i in input().split()]
k=0
t=0
while a>0:
    t+=1
    a-=1
    k+=1
    if k==b:
        a+=1
        k=0
print (t)
