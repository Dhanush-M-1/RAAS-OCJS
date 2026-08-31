#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int arr[200005];
ll nax,nim;
int n,m;
ll max(ll a,ll b){
    return (a<b)?b:a;
}

ll min(ll a,ll b){
    return (a<b)?a:b;
}




int main(){
    int t;cin>>t;
    while(t--){
        cin>>n>>m;
        ll nax=LONG_MIN;
        ll s=0;
        set<pair<ll,ll>> record;
        for(int i=1;i<=n;i++){
            cin>>arr[i];
            s+=arr[i];
            if(s>nax){
                nax=s;
                record.insert(make_pair(nax,i-1));
            }
        }
        
        while(m--){
            int x;cin>>x;
            if(s<=0&&x>nax){
                cout<<"-1 ";continue;
            }
            int round=0;
            if(nax<x){
                int k=x-nax+s-1;
                
                round=k/s;
                
                x=x-round*s;
                
            }
            
            auto k=record.lower_bound(make_pair(x,-1));
            cout<<round*1ll*n+(*k).second<<" ";
        }
        cout<<"\n";
    }
    
}