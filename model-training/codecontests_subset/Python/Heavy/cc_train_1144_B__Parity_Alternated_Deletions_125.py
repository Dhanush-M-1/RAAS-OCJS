n=int(input())
a=list(map(int,input().split()))
o=[]
e=[]
odd=0
even=0
for i in a:
    if i%2==0:
        e.append(i)
        even+=1
    else:
        o.append(i)
        odd+=1
if abs(even-odd)<=1:
    print(0)
else:
    o.sort()
    e.sort()
    if even>odd:
        if odd==0:
            ans=sum(e[0:len(e)-1])
        elif odd!=0:        
            ans=sum(e[0:len(e)-len(o)-1])
    elif odd>even:
        if even==0:
            ans=sum(o[0:len(o)-1])
        elif even!=0:
            ans=sum(o[0:len(o)-len(e)-1])
    print(ans)