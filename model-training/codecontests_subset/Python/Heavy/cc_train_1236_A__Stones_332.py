t=int(input())
a=[]
b=[]
c=[]

for i in range(t):
    values=input().split()
    abc=[int(x) for x in values]
    a.append(abc[0])
    b.append(abc[1])
    c.append(abc[2])
    

    
    
def stones(a,b,c):
    stones=0
    if a<1 and c<2:
        return stones
    while b>=1:
        if a<=1 and c<2 and b<2 :
            return stones
        elif a==0 and c<2:
            return stones
        elif b==1 and c<2:
            return stones
        else:
            if c>=2 and b>=1:
                c-=2
                b-=1
                stones+=3
            elif b>=2 and a>=1:
                b-=2
                a-=1
                stones+=3
    return stones


for i in range(t):
    print(stones(a[i],b[i],c[i]))
