#include<iostream>
#include<algorithm>
#include<cstring>
#include<map>
using namespace std;
#define ll long long
#define maxn 200005
ll t,n,m,a[maxn],k;
map<ll,ll> v;
ll bs(ll c){
ll l=0,r=k;
while(l<r){
ll m=(l+r)/2;
   if(a[m]>=c) r=m;
   else l=m+1;
}
if(r==k) return -1;
return v[a[l]];
}
int main(){
    cin>>t;
    while(t--){
        //cout<<' '<<t<<endl;
        cin>>n>>m;
        ll res=0;
        v.clear();k=0;
        for(int i=1;i<=n;i++){
            ll c;cin>>c;
            res+=c;
            if(res>=0&&!v[res]){
            if(!k||(res>a[k-1])){
            v[res]=i;
            a[k++]=res;
            }
            }
        }
        for(int i=0;i<m;i++){
            ll c,p,h=0;cin>>c;
            if(res<=0) p=bs(c);
            else{
            if(c>a[k-1]){
               h=(c-a[k-1])/res;
               if((c-a[k-1])%res) h+=1;
               c-=h*res;
            }
               p=bs(c);
               if(p!=-1) p+=h*n;
            }
            if(p!=-1) p-=1;
            cout<<p<<' ';
        }
        cout<<endl;
    }
return 0;
}
