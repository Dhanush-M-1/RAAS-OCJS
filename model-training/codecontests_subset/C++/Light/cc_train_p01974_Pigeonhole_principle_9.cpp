#include<bits/stdc++.h>
#define vi vector<int>
#define vvi vector<vector<int> >
#define vl vector<ll>
#define vvl vector<vector<ll>>
#define vb vector<bool>
#define vc vector<char>
#define vs vector<string>
using ll = long long;
using ld =long double;
#define int ll
#define INF 1e9
#define EPS 0.0000000001
#define rep(i,n) for(int i=0;i<n;i++)
#define loop(i,s,n) for(int i=s;i<n;i++)
#define all(in) in.begin(), in.end()
template<class T, class S> void cmin(T &a, const S &b) { if (a > b)a = b; }
template<class T, class S> void cmax(T &a, const S &b) { if (a < b)a = b; }
#define MAX 9999999
int dx[]={0,0,1,-1};
int dy[]={1,-1,0,0};
int W,H;
bool inrange(int x,int y){return (0<=x&&x<W)&&(0<=y&&y<H);}
using namespace std;
typedef pair<int, int> pii;
typedef pair<int,pii> piii;
#define MP make_pair
signed main(){
    int n;cin>>n;
    vector<int>v(n);rep(i,n)cin>>v[i];
    rep(i,n)rep(j,n)if(i!=j)if(abs(v[i]-v[j])%(n-1)==0)return cout<<v[i]<<" "<<v[j]<<endl,0;
}

