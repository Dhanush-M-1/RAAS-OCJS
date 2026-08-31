#include <bits/stdc++.h>
#define rep(i,s,t) for (auto i=s; i<=t ;i++)
#define per(i,s,t) for (auto i=s; i>=t; i--)
using namespace std;
const int maxn=1e5+10;
int n,m,a[maxn];
int X,L,R,tmp=0,k=0,s=-1,x=0,tim,A,d,p,ans;
inline int mami(int l,int r,int x){
    return max(l,min(r,x));
}
void fun(){
    while(k<n&&a[k+1]<=tim){
        d=s*(a[k+1]-tmp);
        s*=-1;
        x+=d;
        tmp=a[k+1];
        L=mami(0,X,L+d);
        R=mami(0,X,R+d);
        k++;
    }
}
int main(){
    scanf("%d%d",&X,&n);
    L=0,R=X;
    rep(i,1,n) scanf("%d",&a[i]);
    scanf("%d",&m);
    rep(i,1,m){
        scanf("%d%d",&tim,&A);
        fun();
        p=tim-tmp;
        ans=mami(L,R,A+x);
        ans=mami(0,X,ans+s*p);
        printf("%d\n",ans);
    }
    return 0;
}