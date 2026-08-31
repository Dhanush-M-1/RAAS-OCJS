def heapify(a,i,n):
    l = i
    lc=2*i +1
    rc=2*i +2
    
    if lc<n and int(a[lc])>int(a[l]):
        l=lc
    if rc<n and int(a[rc])>int(a[l]):
        l=rc
    
    if l!=i:
        a[l],a[i]=a[i],a[l]
        heapify(a,l,n)
        
s = input().replace('+',' ').split()

if len(s)==1:
    print(*s)
else:    
    for i in range(len(s)//2,-1,-1):
        heapify(s,i,len(s))
        
    for i in range(len(s)-1,0,-1):
        s[0],s[i]=s[i],s[0]
        heapify(s,0,i)
        
    print('+'.join(s))

    
    
    