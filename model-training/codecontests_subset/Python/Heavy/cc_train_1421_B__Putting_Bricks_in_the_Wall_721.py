for tt in range(int(input())):
    n=int(input())
    l=[]
    for i in range(n):
        l.append(list(input()))
    j=[]
    cnt=0
    if l[0][1]==l[1][0]:
        if l[n-1][n-2]==l[1][0]:
            cnt+=1
            j.append((n,n-1))
        if l[n-2][n-1]==l[1][0]:
            cnt+=1
            j.append((n-1,n))
    elif l[n-1][n-2]==l[n-2][n-1]:
        if l[0][1]==l[n-1][n-2]:
            cnt+=1
            j.append((1,2))
        if l[n-2][n-1]==l[1][0]:
            cnt+=1
            j.append((2,1))
    else:
        if l[0][1]=='1':
            cnt+=1
            j.append((1,2))
        else:
            cnt+=1
            j.append((2,1))
        if l[n-1][n-2]=='0':
            cnt+=1
            j.append((n,n-1))
        else:
            cnt+=1
            j.append((n-1,n))
    print(cnt)
    for i in j:
        print(i[0],i[1])
    
        
            
        
            
        
        
