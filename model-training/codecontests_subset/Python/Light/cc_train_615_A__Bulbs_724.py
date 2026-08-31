def answer():
    a = [int(x) for x in input().split()]
    n = a[0]
    t= a[1]
    l=[]
    
    while n:
        c=input().split()
        c=[int(x) for x in c]
        for x in c[1:]:
            if x not in l:
                l.append(x)
        n-=1
    
    l=set(l)
    i=1
    while i<=t:
        if i not in l:
            return "NO"
        i+=1
    return "YES"
print(answer())