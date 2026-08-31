#include <bits/stdc++.h>
using namespace std;
const int maxn=1e5+10;
int n,m,X,l=0,r,x=0,k=1,s=-1,tmp=0,tim,A,a[maxn];
inline int calc(int l,int r,int x){
    return max(l,min(r,x));
}
int main(){
    scanf("%d%d",&X,&n);
    for (int i=1; i<=n; i++) scanf("%d",&a[i]);
    r=X;
    scanf("%d",&m);
    for (int i=1; i<=m; i++){
        scanf("%d%d",&tim,&A);
        while(k<=n && a[k]<=tim){
            int d=s*(a[k]-tmp);
            tmp=a[k];
            x+=d;
            k++;
            s*=-1;
            l=calc(0,X,l+d);
            r=calc(0,X,r+d);
        }
        int p=tim-tmp;
        A=calc(l,r,A+x);
        A=calc(0,X,A+s*p);
        printf("%d\n",A);
    }
    return 0;
}
