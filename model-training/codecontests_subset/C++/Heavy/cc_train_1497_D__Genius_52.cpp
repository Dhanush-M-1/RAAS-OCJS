#include<bits/stdc++.h>
using namespace std;
#define lli long long int
#define lld long double
#define ul  unsigned long int
#define pii pair<int,int>
#define pll pair<lli, lli>
#define vi  vector<int>
#define vii vector<pair<int,int>>
#define vll vector<lli>
#define pb  push_back
#define mpr  make_pair
#define ss  second
#define ff first
#define INF 1000000001
#define inf1 1000000000000000001
#define pie 3.14159265358979323846264338327950L
#define all(x) x.begin(),x.end()
#define fast ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL)
#define testcase() int tc;cin>>tc;while(tc--)
#define clean(x,y) memset(x,y,sizeof(x))
#define ee cout<<endl

template<typename A> ostream& operator<<(ostream &cout, vector<A> const &v) {
	cout << "["; for(int i = 0; i < v.size(); i++) {if (i) cout << ", "; cout << v[i];} return cout << "]";
}
template<typename A, typename B> ostream& operator<<(ostream &cout, pair<A, B> const &p) { return cout << "(" << p.ff << ", " << p.ss << ")"; }
template<typename A, typename B> istream& operator>>(istream& cin, pair<A, B> &p) {
	cin >> p.first;
	return cin >> p.second;
}
int dx[] = {-1, 0, 1, 0};
int dy[] = {0, 1, 0, -1};
void caseNumber(int x){printf("Case %d: ",x);}
void yes(){cout<<"YES\n";}
void no(){cout<<"NO\n";}
int gray_code(int n) {return n ^ (n >> 1);}
int turnOn(int x,int pos) {return x | (1<<pos);}
int turnOff(int x,int pos){return x & !(1<<pos);}
bool isOn(int x,int pos) {return (bool)(x & (1<<pos));}
/// RULESSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS////
/// READ THEM ALOUD......................................................................................................
/// 1. Read the problem at least twice
/// 2. Brute force if contraints r low
/// 3. Check base cases or break case if found any T-T
/// 4. Can u force it into some algorithms?
/// 5. Can u relate it to some previous stuff?
/// 6. :D :) :V :3

lli const mod= 1e9+7;
lli const inf=1e9+9;
//lli const mod=998244353;
lli const MAX=1000005;
lli const maxn=2e5+9;


void solve()
{

    int n;cin>>n;
    vector<lli>a(n),dp(n),cost(n);
    for(int i=0;i<n;i++)cin>>a[i];
    for(int i=0;i<n;i++)cin>>cost[i];
    for(int j=0;j<n;j++)
    {
        for(int i=j-1;i>=0;i--)
        {
            if(a[i]==a[j])continue;
            lli dpi=dp[i],dpj=dp[j];
            dp[i]=max(dp[i],dpj+abs(cost[i]-cost[j]));
            dp[j]=max(dp[j],dpi+abs(cost[i]-cost[j]));
        }
    }
    cout<< *max_element(all(dp))<<endl;
}
int main()
{
    fast;
    testcase()solve();
}
