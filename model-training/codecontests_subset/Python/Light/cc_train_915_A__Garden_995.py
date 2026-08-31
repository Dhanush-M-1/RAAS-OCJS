l=[int(e) for e in input().split()]
le=[int(e) for e in input().split()]
lst=[]
for e in le:
    if(l[1]%e==0):
        lst.append(l[1]//e)
print(min(lst))        