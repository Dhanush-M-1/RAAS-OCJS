#include <bits/stdc++.h>

#define ll long long
#define fi first
#define se second
#define mk make_pair
#define pb push_back
#define aprt(ns) for(auto n:ns)cout<<n<<' ';cout<<endl
#define prt(n) for(int i=0;i<n.size();i++)printf("%d%c",n[i],i==n.size()-1?'\n':' ');
#define for1(i,n) for(int i=0;i<n;i++)
#define all(t) t.begin(),t.end()
#define PQ priority_queue
#define pii pair<int,int>
#define pll pair<ll,ll>
#define dormir_11 ios::sync_with_stdio(0);cin.tie(0)

using namespace std;
const int mod = 1e9+7;
const int MAX = 1e6+5;
const double PI = 3.14159265358979323;
const double eps = 1e-8;
int gcd(int a, int b){return a%b==0? b: gcd(b, a%b);}
int fast_powr(int a,int b){ int ret=1;for(;b;b>>=1,a=1LL*a*a%mod)if(b&1)ret=1LL*ret*a%mod;return ret; }
int times;
int dir[4][2] = { {1,0},{0,-1},{0,1},{-1,0} };
char dirs[4]={'D','L','R','U'};
bool cmp(int a,int b){return a>b;}
void YorN(bool flag){if(flag)cout<<"YES"<<endl;else cout<<"NO"<<endl;}



int main(){

    cin>>times;
    while(times--){
        int cs,n,m;
        cin>>cs>>n>>m;
        bool flag=true;
        vector<int>ans(n+m);
        vector<int>a(n),b(m);
        for1(i,n)cin>>a[i];
        for1(i,m)cin>>b[i];
        int ai=0,bi=0,idx=0;
        while(ai<n||bi<m){
            if(ai<n&&a[ai]<=cs){
                ans[idx++]=a[ai];
                if(a[ai]==0)cs++;
                ai++;
            }else if(bi<m&&b[bi]<=cs){
                ans[idx++]=b[bi];
                if(b[bi]==0)cs++;
                bi++;
            }else{
                flag=false;
                break;
            }
        }
        //cout<<idx<<endl;
        if(flag){
            prt(ans);
        }else cout<<-1<<endl;
    }
    return 0;
}


/*
abcdefghijklmnopqrstuvwxyz



 */