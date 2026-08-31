#include<bits/stdc++.h>
using namespace std;
#define endl "\n"
//const int mo=998244353;
#define ll long long
#define all(v) (v).begin(), (v).end()
#define forn(i, n) for (int i = 0; (i) != (n); (i)++)
#define mxn 400005
//#define for((int i=0);i<n;i++) for(i,n)
#define vi vector<int>
#define vl vector<long long>
int fact[mxn];
int inv[mxn];
const int N= 1e5+5;
int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    #ifndef ONLINE_JUDGE
     freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
   #endif
   int t;
   cin>>t;
   while(t--){
       int n;
       cin>>n;
       vector<int> tag(n+1);
       vector<int> score(n+1);
       for(int i=1;i<=n;i++){
           cin>>tag[i];
       }
       for(int i=1;i<=n;i++){
           cin>>score[i];
       }
       vector<long long> dp(n+1);
       for(int big=1;big<=n;big++){
           for(int x=big-1;x>=1;x--){
               if(tag[big]!=tag[x])
               {
               long long bign=max( dp[big], dp[x]+abs(score[x]-score[big]));
               long long xn=max(dp[x],dp[big]+abs(score[x]-score[big]));
               dp[big]=bign;
               dp[x]=xn;
               }
           }
       }
       cout<<*max_element(all(dp))<<endl;

         


   }
}