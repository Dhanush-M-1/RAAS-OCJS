def smallest(a):
    
    l = -1
    p = -1    
    f = [0]*100

    a = list(a)

    for q in a:
        f[ord(q)-ord('A')]+=1
    
    i=0;
    while(f[i]==0 and i<26):
        i+=1
        
    for j in range(0,len(a)):
        if l==-1 and (ord(a[j]) - ord('A'))== i:
            f[i]-=1
            while(f[i]==0 and i<26):
                i+=1
        elif ord(a[j]) - ord('A') == i:
            l = j
        elif l==-1:
            p = j
            l = 0
        
    

    
    if l!=-1 and p!=-1:
        a[p] , a[l] = a[l] , a[p]
    
    
    
    
    return ''.join(a)
 
for _ in range(int(input())):
    x,y = input().split()
    x = smallest(x)
    if x>=y:
        print("---")        
    else:
        print(x)
