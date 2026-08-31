def node(ind,stuff,lvl):
    if(ind[0]-ind[1] !=0):
        most = max(a[ind[0]:ind[1]])
        inds = a.index(most)
        ind = [[ind[0],inds],[inds+1,ind[1]]]
        stuff[inds] = lvl
        for i in reversed(range(len(ind))):
            if(i==1):
               lvl += 1
            stuff = node(ind[i],stuff,lvl)
    return stuff          
t = int(input())
for u in range(t):
    n = int(input())
    a = [int(x) for x in input().split()]
    stuff = [-1]*len(a)
    rights = []
    stuff = node([0,len(a)],stuff,0)
    stuff = [str(x) for x in stuff]
    print(" ".join(stuff))
