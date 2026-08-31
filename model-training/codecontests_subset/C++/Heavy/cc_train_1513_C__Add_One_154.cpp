#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
#define mod 1000000007
//typedef unsigned long long int ull;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    vector<vector<ll>> v(10,vector<ll> (200001,0));
    ll A[10];ll B[10] = {0};
    ll maxx = 200000;
    for(int I=0;I<10;++I){
        for(int j=0;j<10;++j){
            if(j==I)A[j] = 1;
            else A[j]=0;
        }
        for(ll k=0;k<maxx;++k){
            for(int i=0;i<10;++i){
                if(i==0)B[0] = (A[9])%mod;
                else if(i==1)B[1] = (A[0] + A[9])%mod;
                else B[i] = (A[i-1])%mod;
            }
            ll count =0;
            for(int i=0;i<10;++i){A[i] = B[i];count = (count + A[i])%mod;}
            v[I][k+1] = count;
        }
    }
    int t=1;cin>>t;
    while(t--){
        string s;ll m;
        cin>>s>>m;
        ll ans = 0;
        for(int i=0;i<(int)s.length();++i){
            ans = (ans + v[s[i]-'0'][m])%mod;
        }
        //cout<<"here ";
        cout<<ans<<endl;


        /*
        ll a[10] = {0}, b[10] = {0};
        for(int i=0;i<(int)s.length();++i){
            a[s[i]-'0']++;
        }
        //for(int i=0;i<10;++i)cout<<a[i]<<" ";
        while(m--){
            for(int i=0;i<10;++i){
                if(i==0)b[0] = (a[9])%mod;
                else if(i==1)b[1] = (a[0] + a[9])%mod;
                else b[i] = (a[i-1])%mod;
            }
            for(int i=0;i<10;++i)a[i] = b[i];
        }
        ll ans = 0;
        for(int i=0;i<10;++i){
            ans = (ans + a[i])%mod;
        }
        //cout<<"here  ";
        cout<<ans<<endl;
        */





    }
    return 0;
}
