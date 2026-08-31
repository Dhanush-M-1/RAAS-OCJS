cas=int(input());
while cas:
    cas-=1;
    n=int(input());
    r=list(map(int,input().split()));
    c=list(map(int,input().split()));
    a=list(zip(r,c));
    a.sort();
    now=0;
    pre=0;
    pr=1;
    pz=0;
    ans=0;
    for i in range(n):
        tmp=a[i];
        now=tmp[0]-tmp[1];
        zu=now//2;
        if(pre==now and now%2==0):
            ans+=tmp[0]-pr;
        if(pre!=now and zu!=pz):
            ans+=zu-pz;
        pre=now;
        pr=tmp[0];
        pz=zu;
    print(ans);
