n=int(input())
l=list(map(int,input().split()))
e=[]
o=[]
ce=0
co=0
for i in range(n):
    if l[i]%2==0:
        ce += 1
        e.append(l[i])
    else:
        co += 1
        o.append(l[i])
if ce==co:
    print("0")
elif ce==0:
    o.sort()
    o.remove(o[len(o)-1])
    print(sum(o))
elif co==0:
    e.sort()
    e.remove(e[len(e)-1])
    print(sum(e))
elif ce>co:
    e.sort()
    o.sort()
    sumt=sum(e[0:len(e)-(co+1)])+ sum(o[0:len(o)-co])
    print(sumt)
else:
    e.sort()
    o.sort()
    sumt = sum(e[0:len(e) - ce]) + sum(o[0:len(o) - (ce+1)])
    print(sumt)
