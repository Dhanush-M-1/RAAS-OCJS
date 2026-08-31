for i in range(int(input())):
    a=list(input())
    alphabet=set(list('abcdefghijklmnopqrstuvwxyz'))
    a_Set=set(a)    
    j=0
    count=0
    for i in range(1,len(a)):
        nei=set()
        nei.add(a[i-1])
        nei.add(a[i])
        if(i+1<=len(a)-1):
            nei.add(a[i+1])
        if(i+2<=len(a)-1):
            nei.add(a[i+2])
        if(i-2>=0):
            nei.add(a[i-2])
        w=alphabet.difference(nei)
        q=list(w) 
        if(a[i]==a[i-1]):
            a[i]=q[j%len(q)]
            j=+1
            count+=1
        if(i-2>=0):
            if(a[i]==a[i-2]):
                a[i]=q[j%len(q)]
                j=j+1
                count+=1
    print(count)






        