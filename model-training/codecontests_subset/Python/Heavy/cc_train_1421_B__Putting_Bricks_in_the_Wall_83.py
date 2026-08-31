n = int(input())
for j in range(n):
    
    n = int(input())
    f=[]
    for j in range(n):
        l = input()
        if n==3:
            if j==0:
                f.append(int(l[1]))
                
            if j==1:
                f.append(int(l[0]))
                f.append(int(l[n-1]))
            if j==n-1:
                f.append(int(l[n-2]))
            
        else:
            if j==0:
                f.append(int(l[1]))
                
            if j==1:
                f.append(int(l[0]))
            if j==n-1:
                f.append(int(l[n-2]))
            if j==n-2:
                f.append(int(l[n-1]))
    
    cnt=0
    cnt1=0
 
    if f[0]==0:
        cnt+=1
    else:
        cnt1+=1
    if f[1]==0:
        cnt+=1
    else:
        cnt1+=1
    if f[2]==1:
        cnt+=1
    else:
        cnt1+=1
    if f[3]==1:
        cnt+=1
    else:
        cnt1+=1
    if cnt>=cnt1:
        print(cnt1)
        if f[0]==1:
            print(1,2)
        if f[1]==1:
            print(2,1)
        if f[2]==0:
            print(n-1,n)
        if f[3]==0:
            print(n,n-1)

    else:
        print(cnt)
        if f[0]==0:
            print(1,2)
        if f[1]==0:
            print(2,1)
        if f[2]==1:
            print(n-1,n)
        if f[3]==1:
            print(n,n-1)


    
    