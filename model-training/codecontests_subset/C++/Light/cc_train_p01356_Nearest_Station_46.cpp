#include<bits/stdc++.h>
using namespace std;

using ll=__int128;

using ll2=long long;

const ll INF=1e15;

ll powi(ll x,ll k){
    ll res=1;
    while(k){
        if(k&1) res*=x;
        if(res>INF) return INF;
        x*=x;
        k>>=1;
    }
    return res;
}
int main(){
    ll2 nn,mm,aa,bb,pp,qq;
    cin>>nn>>mm>>aa>>bb>>pp>>qq;
    ll n=nn,m=mm,a=aa,b=bb,p=pp,q=qq;
    if(a>=2 || b>=2){
        int tn=min(n,ll(41));
        int half=min(tn/2,20);
        vector<ll> vec(1<<half);
        for(int i=0;i<(1<<half);i++){
            ll val=0;
            for(int j=0;j<half;j++){
                if((i>>j)&1){
                    val+=p*powi(a,j)+q*powi(b,j);
                }
                if(val>=INF){
                    break;
                }
            }
            vec[i]=val;

        }
        int rest=tn-half;
        vector<ll> s(1<<rest);
        for(int i=0;i<(1<<rest);i++){
            ll val=0;
            for(int j=0;j<rest;j++){
                if((i>>j)&1){
                    val+=p*powi(a,half+j)+q*powi(b,half+j);
                }
                if(val>=INF){
                    break;
                }
            }
            s[i]=val;
        }
        sort(s.begin(),s.end());
        ll2 res=m;
        for(int i=0;i<vec.size();i++){
            auto it=lower_bound(s.begin(),s.end(),m-vec[i]);
            if(it!=s.end()){
                res=min(res,abs(ll2(m-vec[i]-*it)));
            }
            if(it!=s.begin()){
                it--;
                res=min(res,abs(ll2(m-vec[i]-*it)));
            }
        }
        cout<<res<<endl;
    }
    else{
        if((p+q)*n>=m){
            cout<<ll2(min(m%(p+q),(p+q)-m%(p+q)))<<endl;
        }
        else{
            cout<<ll2(m-(p+q)*n)<<endl;
        }
    }
    return 0;
}
