n,m=input().split();
n=int(n);
m=int(m);
a=[1]*(m+1);
for i in range(n):
    k=input().split();
    w=int(k[0]);
    for j in range(w):
        x=int(k[j+1]);
        m-=a[x];
        a[x]=0;

if m==0 :print('YES');
else :print('NO');
