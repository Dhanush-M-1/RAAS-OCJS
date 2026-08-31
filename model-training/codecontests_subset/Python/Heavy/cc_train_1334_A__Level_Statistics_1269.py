T = int(input(""))
for _ in range(T):
    n = int(input(""))
    arp =[]
    arc = []
    for i in range(n):
        
 
        p,c = map(int,input().split())
        arp.append(p)
        arc.append(c)
    ans = "YES"
 
    for j in range(n):
        if arc[j] > arp[j]:
            ans = "NO"
            break
 
        
    for x in range(1,n):
        #print(x)
        if n != 1:
            if arp[x] < arp[x-1]:
                ans = "NO"
                break
 
        if  n != 1:
            if arc[x] < arc[x-1]:
            
                ans = "NO"
                break
 
        if arc[x]== arc[x-1]+1 and arp[x]<=arp[x-1]:
            ans = "NO"
            break
 
        if arc[x]- arc[x-1] > arp[x] - arp[x-1]:
            
            ans = "NO"
            break
        
        
 
    print(ans)				
		