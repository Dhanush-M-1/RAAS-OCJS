def countFreq(arr):
    
    n=len(arr)
  
    mp = dict() 

    for i in range(n): 
        if arr[i] in mp.keys(): 
            mp[arr[i]] += 1
        else: 
            mp[arr[i]] = 1
        
    return mp


for _ in range(int(input())):
    n,m=map(int,input().split())
    a=list(map(int,input().split()))
    b=list(map(int,input().split()))
    l=[]
    
    an=countFreq(a)
    bm=countFreq(b)
    

    for key in an.keys(): 
        if key in bm:
            l.append(key)
            break
    if len(l)==0:
        print("NO")
    else:
        print("YES")
        print(len(l),*l)