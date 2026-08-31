n=list(map(int,input().split()))
li=[]
for i in range(n[0]):
    k=list(map(int,input().split()))
    for j in range(1,len(k)):
        if k[j] not in li:
            li.append(k[j])
if len(li)==n[1]:
    print('YES')
else:
    print('NO')
        
    
    
    

      
                
           