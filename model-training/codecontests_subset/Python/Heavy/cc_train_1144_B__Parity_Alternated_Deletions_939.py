def deletions(ar):
    p = 0
    o = []
    e = []
    for i in ar :
        if i%2 == 1 :
            o.append(i)
        else :
            e.append(i)
    if len(o)==len(e) :
        return 0
    if len(o)>len(e):
        p = o[-1]
        while e :
            if p%2 == 1:
                o.remove(p)
                p = max(e)
            else:
                e.remove(p)
                p = max(o)
        if len(o)>=1 :
            o.pop()
    else :
        p = e[-1]
        while o :
            if p%2 == 1:
                o.remove(p)
                p = max(e)
            else:
                e.remove(p)
                p = max(o)
        if len(e)>=1 :
            e.pop()
    if o :
        return sum(o)
    else:
        return sum(e)
    return 0
    
n = int(input())
ar = list(map(int,input().split()))
print(deletions(sorted(ar)))