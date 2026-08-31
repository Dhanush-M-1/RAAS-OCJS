import math
a,b=map(int,input().split())
z=(a/b)
z1=z
l=[]
if(a<b):
    print(a)
else:
    while (z >= b):
        z = (z / b)
        l.append(z)
    # print(l)
    ans = a + z1 + sum(l)
    if((math.floor(ans))%2==0):
        print(math.ceil(ans))
    else:
        print(math.floor(ans))