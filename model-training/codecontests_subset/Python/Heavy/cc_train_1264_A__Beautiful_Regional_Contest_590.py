t = int(input())
for _ in range(t):
    n = int(input())
    l = list(map(int,input().split()))
    if(n//2<3):
        print(0,0,0)
        continue
    i = n//2 - 1
    while(l[i]==l[i+1] and i>0):
        i-=1
    if(i+1<3):
        print(0,0,0)
        continue
    if(len(set(l[0:(i+1)]))<3):
        print(0,0,0)
        continue
    else:
        l1 = l[0:(i+1)]
        g=1
        k=0
        while(k<len(l1) and l1[k]==l1[k+1]):
            g+=1
            k+=1
        k+=1
        s=1
        while(s<=g):
            s=s+1
            k+=1
        k+=1
        while(k<len(l1) and l1[k-1]==l1[k]):
            s+=1
            k+=1
        b = len(l1)-g-s
        if(g>=s or g>=b):
            print(0,0,0)
            continue
        print(g,s,b)
            
            
    
        
