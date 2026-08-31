a,b = map(int,input().split())
k=0
k1=0
while a>0:
    k+=1
    k1+=1
    a-=1
    if (k1==b):
        a+=1
        k1=0
print(k)