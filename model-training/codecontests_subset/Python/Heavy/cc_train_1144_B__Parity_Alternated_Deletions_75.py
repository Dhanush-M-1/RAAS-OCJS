n = int(input())
a = [int(x) for x in input().split()]
a=sorted(a)
a.reverse()
e=[]
o=[]
for i in range(n):
    if a[i]%2==0:
        e.append(a[i])
    else:
        o.append(a[i])
#print(e)
#print(o)
        
if n%2 == 0:
    if len(e)==len(o):
        print(0)
    elif len(e)>len(o):
        k = 0
        del e[k]
        while len(o)!=0:
            del o[k]
            del e[k]
            #k=k+1
        
        print(sum(e)+sum(o))
    else:
        k = 0
        del o[k]
        while len(e)!=0:
            del e[k]
            del o[k]
            #k=k+1
        
        print(sum(e)+sum(o))
        
            
        
        
else:
    if len(e)==(len(o)+1) or len(o)==(len(e)+1):
        print(0)
    elif len(e)>(len(o)+1):
        k = 0
        del e[k]
        while len(o)!=0:
            del o[k]
            del e[k]
            #k=k+1
        
        print(sum(e)+sum(o))
    else:
        k = 0
        del o[k]
        while len(e)!=0:
            del e[k]
            del o[k]
            #k=k+1
        
        print(sum(e)+sum(o))

    