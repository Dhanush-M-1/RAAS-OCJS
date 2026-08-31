t=int(input());
for i in range(t):
    n=int(input());
    s=list(map(int,input().split()));
    c=0;
    for i in range(n-2):
        j=i+1;
        for k in range(j+1,n):
            if(s[i]+s[j]>s[-1]):
                c=-1;
                break;
            elif(s[i]+s[j]<=s[k]):
                c=1;
                break;
        if(c==1 or c==-1):
            break;
    if(c==1):
        print(i+1,j+1,k+1);
    elif(c==-1):
        print(-1);

