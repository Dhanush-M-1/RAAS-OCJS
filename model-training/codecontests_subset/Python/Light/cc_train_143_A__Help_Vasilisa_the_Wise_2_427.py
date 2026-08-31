l=[]
for i in range(3) :
    l+=list(map(int,input().split()))
for i in range(1,10) :
    for j in range(1,10) :
        for i1 in range(1,10) :
            for j1 in range(1,10) :
                if i+j==l[0] and i1+j1==l[1] and i+j1==l[4] and i+i1==l[2] and j+j1==l[3] and j+i1==l[5]  :
                    
                    l1=[i,j,i1,j1]
                    if len(set(l1))==4 :
                        print(i,j)
                        print(i1,j1)
                        exit()
                    
print(-1)
                    
