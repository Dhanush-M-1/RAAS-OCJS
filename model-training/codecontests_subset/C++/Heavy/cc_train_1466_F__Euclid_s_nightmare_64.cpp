#include<bits/stdc++.h>
using namespace std;
const int N=5e5+5;
int n,m;
#define P pair<int,int>
P a[N];
int ans[N],nans;
const int mod=1e9+7;
P b[N];
int insert(int x,int y){
        if(b[x].first==x&&b[x].second==y)return -1;
        if(b[x].first==0){
                b[x]=P(x,y);
                return y;
        }else{
                int l=y,r=b[x].second;
                if(l==0){
                        int t=insert(r,l);
                        if(t!=-1)b[x].second=max(b[x].second,t);
                        return t;
                }
                if(r==0){
                        int t=insert(l,r);
                        if(t!=-1)b[x].second=max(b[x].second,t);
                        return t;
                }
                if(l>r)swap(l,r);
                int tmp=insert(l,r);
                if(tmp!=-1)b[x].second=max(b[x].second,tmp);
        }
}
int main(){
        ios::sync_with_stdio(0),cin.tie(0),cout.tie(0);
        cin>>n>>m;
        for(int i=1;i<=n;i++){
                int cnt;
                cin>>cnt;
                if(cnt>=1)cin>>a[i].first;
                if(cnt>=2){
                        cin>>a[i].second;
                        if(a[i].first>a[i].second)swap(a[i].first,a[i].second);
                }
        }
        for(int i=1;i<=n;i++)if(insert(a[i].first,a[i].second)!=-1)ans[++nans]=i;
        long long base=1;
        for(int i=1;i<=nans;i++)base=base*2%mod;
        cout<<base<<" "<<nans<<endl;
        for(int i=1;i<=nans;i++)cout<<ans[i]<<" ";cout<<endl;
        return 0;
}