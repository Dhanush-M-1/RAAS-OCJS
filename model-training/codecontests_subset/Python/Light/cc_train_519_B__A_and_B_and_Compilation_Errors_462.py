n,l = int(input()),[]
for i in range(3):
 l.append(list(map(int,input().split())))
i,j,k=sorted(l[0]),sorted(l[1]),sorted(l[2])
for m in range(n):
    if m <n-1:
     if i[m]!=j[m]:
        print(i[m])
        break
    else:
        print(i[m])
        
for p in range(n-1):
    if p < n-2:
     if j[p]!=k[p]:
        print(j[p])
        break
    else:
        print(j[p])
        

    
    
