#include <bits/stdc++.h>
using namespace std;

int X,n,q;
int r[100001],t[100000],a[100000];

int main() {
    scanf("%d%d",&X,&n);
    for(int i=1;i<=n;i++) scanf("%d",r+i);
    scanf("%d",&q);
    for(int i=0;i<q;i++) scanf("%d%d",t+i,a+i);

    int sl=0,sr=X,ll=0,rr=X;
    for(int i=0,j=1;i<q;i++) {
        for(;j<=n && r[j]<=t[i];j++) {
            int d=r[j]-r[j-1];
            if(j%2==1) {
                sl += max(d-ll,0);
                sl = min(sl,sr);
                ll = max(ll-d,0);
                rr = max(rr-d,0);
            } else {
                sr -= max(d-(X-rr), 0);
                sr = max(sl,sr);
                rr = min(rr+d,X);
                ll = min(ll+d,X);
            }
        }
        a[i] = max(a[i],sl);
        a[i] = min(a[i],sr);

        int v=ll+(a[i]-sl);
        if(j%2==1) v-=t[i]-r[j-1];
        else v+=t[i]-r[j-1];
        v = min(v,X); v=max(v,0);
        printf("%d\n",v);
    }
    
    return 0;
}
