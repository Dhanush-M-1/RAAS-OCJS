a=int(input())
bi=input()
i=0
zero=0
um=0
trans=1
comp=['','']
while i<a:
    if bi[i]=='1':
        um+=1
    else:
        zero+=1
    i+=1
if zero!=um:
    print(trans)
    print(bi)
else:
    zero=0
    um=0
    if a%2==0 and (a/2)%2!=0:
        x=0
        trans+=1
        while x<a/2:
            comp[0]+=bi[x]
            comp[1]+=bi[int(x+a/2)]
            x+=1
    elif (a/2)%2==0:
        x=0
        trans+=1
        while x<(a/2)-1:
            comp[0]+=bi[x]
            x+=1
        x=0
        while x<(a/2)+1:
            comp[1]+=bi[int((x+(a/2))-1)]
            x+=1
    print(trans)
    print(*comp)