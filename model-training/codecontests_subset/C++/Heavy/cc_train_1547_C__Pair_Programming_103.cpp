#include<bits/stdc++.h>
using namespace std;
using ll = long long;
ll MOD=1000000007;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    ll t;
    cin>>t;
    while(t--) {
        ll k,n,m,f=1;
        cin>>k>>n>>m;
        ll a[n],b[m],c[n+m];
        ll max1=0,c0=0;
        for(auto &y:a){cin>>y;}
        for(auto &y:b){cin>>y;}
        
        ll i=0,j=0,p=0;
        while(f && p<n+m){
        if(i<n && j<m && a[i]>k && b[j]>k)f=0;
        if((i==n && j<m && b[j]>k) or (j==m && i<n && a[i]>k))f=0;
        while(i<n && a[i] <= k){if(!a[i])k++;c[p++]=a[i++];}
        while(j<m && b[j] <= k){if(!b[j])k++;c[p++]=b[j++];}
        if(p<n+m && a[i]>k && b[j]>k )f=0;
        }
        // for(auto y:c)cout<<y<<" ";
        if(f==0)cout<<-1;
        else for(auto y:c)cout<<y<<" ";
        cout<<endl;
    }
}
        