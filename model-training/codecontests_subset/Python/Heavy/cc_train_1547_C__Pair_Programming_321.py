T=int(input());
for t in range(T):
    input();
    [k,n,m]=list(map(int,input().split()));
    a=list(map(int,input().split()));
    b=list(map(int,input().split()));
    f=True;
    i=0;j=0;
    c=[];
    while(i<n and j<m):
        if(a[i]==0):k+=1;c.append(a[i]);i+=1;
        elif(b[j]==0):k+=1;c.append(b[j]);j+=1;
        elif(a[i]>k and b[j]>k):print(-1);f=False;break;
        else:
            if(a[i]>k):c.append(b[j]);j+=1;
            else:c.append(a[i]);i+=1;
    if(f):
        while(i<n):
            if(a[i]==0):k+=1;c.append(a[i]);i+=1;
            elif(a[i]>k):print(-1);f=False;break;
            else:c.append(a[i]);i+=1;
        while(j<m):
            if(b[j]==0):k+=1;c.append(b[j]);j+=1;
            elif(b[j]>k):print(-1);f=False;break;
            else:c.append(b[j]);j+=1;
    if(f):print(*c);
    
    
    