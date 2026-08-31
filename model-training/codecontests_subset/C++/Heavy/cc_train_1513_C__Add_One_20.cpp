#include<bits/stdc++.h>
#define int long long
#define ld long double

#define all(X) (X).begin(), (X).end()
#define reset(X) memset(X, 0, sizeof(X))
#define mp(a, b) make_pair(a, b)
#define pb push_back
#define endl '\n'
#define ff first
#define ss second


using namespace std;
const int mod=1e9+7;
 // const int mod=998244353;
 // const int mod=1e9+9;
const int INF=4e18+10;
// const int INF=4e18+10;


typedef pair<int, int> pii;

int power(int a, int b, int in_mod)
{
    int ans=1;
    int prod=a;
    while(b)
    {
        if(b%2)
            ans=(ans*prod)%in_mod;
        prod=(prod*prod)%in_mod;
        b/=2;
    }
    return ans;
}
int mod_inv(int q, int in_mod)
{

    return power(q, in_mod-2,in_mod);
}

int gcd(int a,int b){
    if(b==0) return a;
    return gcd(b,a%b);
}

int fact(int n,int in_mod){
    int f=1;
    for(int i=1;i<=n;i++) f=(f*i)%in_mod;
    return f;
}
int ncr(int n,int r,int in_mod){
    return (((fact(n,in_mod)*mod_inv(fact(r,in_mod),in_mod))%in_mod)*mod_inv(fact(n-r,in_mod),in_mod))%in_mod;
}
int val[10][200005];
const int M = 200005;
void solve()
{
    //write code here
    string s;
    cin>>s;
    int m;
    cin>>m;
    int cnt[10]={};
    for(int i=0;i<s.size();i++){
        cnt[s[i]-'0']++;
    }
    int ans=0;
    for(int i=0;i<10;i++){
        ans+=(val[i][m]*cnt[i])%mod;
        ans%=mod;
    }
    cout<<ans<<endl;
}

signed main()

{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cout<<fixed<<setprecision(10);
    #ifndef ONLINE_JUDGE
    if(fopen("INPUT.txt","r"))
    {
        freopen ("INPUT.txt" , "r" , stdin);
        freopen ("OUTPUT.txt" , "w" , stdout);
    }
    #endif
    auto clk=clock();
    mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
    // -------------------------------------Code starts here---------------------------------------------------------------------


    for(int d=0;d<10;d++){
            int cnt[10]={};
            cnt[d]=1;
             for(int i=1;i<M;i++){
                 int temp[10]={};
                 for(int j=0;j<9;j++){
                     temp[j+1]=cnt[j]%mod;
                 }
                 temp[0]+=cnt[9];
                 temp[0]%=mod;
                 temp[1]+=cnt[9];
                 temp[1]%=mod;
                 int tot=0;
                 for(int j=0;j<10;j++) {
                     cnt[j]=temp[j];
                     tot+=cnt[j];
                     tot%=mod;
                 }
                 val[d][i]=tot;
             }
    }
    int t=1;
    cin>>t;
    for(int test=1;test<=t;test++)
    {
        // cout<<"Case #"<<test<<": ";
        // cout<<endl;
        solve();
        // cout<<endl;

    }

    // -------------------------------------Code ends here------------------------------------------------------------------


    clk = clock() - clk;
    cerr << fixed << setprecision(6) << "Time: " << ((long double)clk)/CLOCKS_PER_SEC << "\n";
    return 0;
}
/*
1.do not use bitshift (1<<int) because it gives value in int and not in long long 
2.check that for loops of i,j,k are properly declared
3.donot delete elements from map,set while looping in it
4.in a map's vector ,ie,map<int,vector<int>> mp,when you sort each vector in a loop it may not get sorted outside the scope of the loop so take care
*/