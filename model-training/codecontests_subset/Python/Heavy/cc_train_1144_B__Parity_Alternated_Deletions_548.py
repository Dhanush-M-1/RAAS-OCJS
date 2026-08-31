def pc(a,n):
    e=[]
    o=[]
    ne=0
    no=0
    s=0
    for x in a:
        s+=x
        if x%2==0:
            e.append(x)
            ne+=1
        else:
            o.append(x)
            no+=1
    e.sort()
    o.sort()
    e.reverse()
    o.reverse()
    if ne>no:
        return s-sum(e[:no+1])-sum(o)
    if no>ne:
        return s-sum(o[:ne+1])-sum(e)
    else:
        return 0

#pc([1,5,7,8,2],5)
n = int(input().strip())
inp = input()
a = [int(x) for x in inp.strip().split(' ')]
print(pc(a,n))





