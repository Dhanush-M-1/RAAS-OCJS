/**   D Bag*/
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef unsigned long long ull;
#define fr(iter,n)  for(ll iter=0;iter<n;++iter)
#define forr(iter,s,e) for(ll iter=s;iter<e;++iter)
#define ufr(iter,s,e)  for(ll iter=s;iter>=e;--iter)
#define MOD       (ll)1000000007
#define pii       pair<ll,ll>
#define vi        vector<ll>
#define vd        vector<double>
#define vpi       vector<pii>
#define vs        vector<string>
#define pb        push_back
#define pob       pop_back
#define ub        upper_bound
#define lb        lower_bound
#define eb        emplace_back
#define pf        push_front
#define pof       pop_front
#define mp(x,y)   make_pair(x,y)
#define all(a)    a.begin(),a.end()
#define ff        first
#define ss        second
#define lcm(a,b)  (a*b)/__gcd(a,b)
#define mem(a,val) memset(a,val,sizeof(a))
#define trace1(x)                   cerr<<#x<<": "<<x<<endl
#define trace2(x, y)                cerr<<#x<<": "<<x<<" | "<<#y<<": "<<y<<endl
#define trace3(x, y, z)             cerr<<#x<<": "<<x<<" | "<<#y<<": "<<y<<" | "<<#z<<": "<<z<<endl
#define trace4(a, b, c, d)          cerr<<#a<<": "<<a<<" | "<<#b<<": "<<b<<" | "<<#c<<": "<<c<<" | "<<#d<<": "<<d<<endl
#define trace5(a, b, c, d, e)       cerr<<#a<<": "<<a<<" | "<<#b<<": "<<b<<" | "<<#c<<": "<<c<<" | "<<#d<<": "<<d<<" | "<<#e<< ": "<<e<<endl
#define trace6(a, b, c, d, e, f)    cerr<<#a<<": "<<a<<" | "<<#b<<": "<<b<<" | "<<#c<<": "<<c<<" | "<<#d<<": "<<d<<" | "<<#e<< ": "<<e<<" | "<<#f<<": "<<f<<endl
#define trace7(a, b, c, d, e, f, g) cerr<<#a<<": "<<a<<" | "<<#b<<": "<<b<<" | "<<#c<<": "<<c<<" | "<<#d<<": "<<d<<" | "<<#e<< ": "<<e<<" | "<<#f<<": "<<f<<" | "<<#g<<": "<<g<<endl
#define trace(v) for(auto it=v.begin();it!=v.end();it++)cerr<<*it<<" ";cerr<<endl;
#define zoom      ios_base::sync_with_stdio(false);cin.tie(NULL);
#define piii pair< ll, pair<ll, ll > >




ll power(ll a, ll b, ll p){
  ll res = 1;
  a = a%p;
  while(b > 0){
    if(b&1){
      res = ((res%p) * (a%p))%p;
    }
    b /= 2;
    a = ((a%p)*(a%p))%p;
  }
  return res;
}

ll fact[200005];

ll ncr(ll a, ll b){
  if(a < b){
    return 0LL;
  }
  if(a == b){
    return 1LL;
  }
  ll ans = fact[a];
  ll den = (fact[b]*fact[a - b])%MOD;
  den = (power(den, MOD - 2, MOD));
  ans = (ans * den)%MOD;
  return ans;
  // ll ans = 1;
  // ll cnt = 1;
  // for(ll i = a - b + 1; i <= a; i ++){
  //   ans *= i;
  //   ans /= cnt;
  //   cnt ++;
  // }
  // return ans;
}

void add(vi& a, vi& b){
  // a = a + b
  fr(i, a.size()){
    a[i] = (a[i] + b[i])%MOD;
  }
  return;
}

inline void do_op(vector<vi>& dp, vi& cnt){
  vi new_cnt(11);
  for(ll i = 1; i <= 10; i ++){
    for(ll j = 1; j <= 10; j ++){
      new_cnt[i] = (new_cnt[i] + dp[i][j]*cnt[j])%MOD;
    }
  }
  cnt = new_cnt;
}

inline void op_10_5(vi &cnt){
  vector<vi> dp(11);
  // Hard code
  dp[1] = {0, 651904299, 285978270, 759489075, 969290391, 521867181, 810068539, 294376709, 604618109, 408984056, 641652427}; 
  dp[2] = {0, 50636476, 651904299, 285978270, 759489075, 969290391, 521867181, 810068539, 294376709, 604618109, 408984056}; 
  dp[3] = {0, 13602158, 50636476, 651904299, 285978270, 759489075, 969290391, 521867181, 810068539, 294376709, 604618109}; 
  dp[4] = {0, 898994818, 13602158, 50636476, 651904299, 285978270, 759489075, 969290391, 521867181, 810068539, 294376709}; 
  dp[5] = {0, 104445241, 898994818, 13602158, 50636476, 651904299, 285978270, 759489075, 969290391, 521867181, 810068539}; 
  dp[6] = {0, 331935713, 104445241, 898994818, 13602158, 50636476, 651904299, 285978270, 759489075, 969290391, 521867181}; 
  dp[7] = {0, 491157565, 331935713, 104445241, 898994818, 13602158, 50636476, 651904299, 285978270, 759489075, 969290391}; 
  dp[8] = {0, 728779459, 491157565, 331935713, 104445241, 898994818, 13602158, 50636476, 651904299, 285978270, 759489075}; 
  dp[9] = {0, 45467338, 728779459, 491157565, 331935713, 104445241, 898994818, 13602158, 50636476, 651904299, 285978270}; 
  dp[10] = {0, 285978270, 759489075, 969290391, 521867181, 810068539, 294376709, 604618109, 408984056, 641652427, 10251872}; 
  do_op(dp, cnt);
  return;
}

inline void op_10_4(vi &cnt){
  vector<vi> dp(11);
  // Hard code
  dp[1] = {0, 700725413, 513422121, 202657640, 646409750, 70321224, 933251429, 490798159, 929577963, 6573970, 149613446}; 
  dp[2] = {0, 156187416, 700725413, 513422121, 202657640, 646409750, 70321224, 933251429, 490798159, 929577963, 6573970}; 
  dp[3] = {0, 936151933, 156187416, 700725413, 513422121, 202657640, 646409750, 70321224, 933251429, 490798159, 929577963}; 
  dp[4] = {0, 420376115, 936151933, 156187416, 700725413, 513422121, 202657640, 646409750, 70321224, 933251429, 490798159}; 
  dp[5] = {0, 424049581, 420376115, 936151933, 156187416, 700725413, 513422121, 202657640, 646409750, 70321224, 933251429}; 
  dp[6] = {0, 3572646, 424049581, 420376115, 936151933, 156187416, 700725413, 513422121, 202657640, 646409750, 70321224}; 
  dp[7] = {0, 716730974, 3572646, 424049581, 420376115, 936151933, 156187416, 700725413, 513422121, 202657640, 646409750}; 
  dp[8] = {0, 849067390, 716730974, 3572646, 424049581, 420376115, 936151933, 156187416, 700725413, 513422121, 202657640}; 
  dp[9] = {0, 716079761, 849067390, 716730974, 3572646, 424049581, 420376115, 936151933, 156187416, 700725413, 513422121}; 
  dp[10] = {0, 513422121, 202657640, 646409750, 70321224, 933251429, 490798159, 929577963, 6573970, 149613446, 551111967};
  do_op(dp, cnt);
  return;
}


inline void op_10_3(vi &cnt){
  vector<vi> dp(11);
  // Hard code
  dp[1] = {0, 206671027, 618188410, 427909462, 149392123, 964816865, 37540036, 142216143, 257687866, 485793807, 129104111}; 
  dp[2] = {0, 614897918, 206671027, 618188410, 427909462, 149392123, 964816865, 37540036, 142216143, 257687866, 485793807}; 
  dp[3] = {0, 743481673, 614897918, 206671027, 618188410, 427909462, 149392123, 964816865, 37540036, 142216143, 257687866}; 
  dp[4] = {0, 399904009, 743481673, 614897918, 206671027, 618188410, 427909462, 149392123, 964816865, 37540036, 142216143}; 
  dp[5] = {0, 179756179, 399904009, 743481673, 614897918, 206671027, 618188410, 427909462, 149392123, 964816865, 37540036}; 
  dp[6] = {0, 2356894, 179756179, 399904009, 743481673, 614897918, 206671027, 618188410, 427909462, 149392123, 964816865}; 
  dp[7] = {0, 114208981, 2356894, 179756179, 399904009, 743481673, 614897918, 206671027, 618188410, 427909462, 149392123}; 
  dp[8] = {0, 577301585, 114208981, 2356894, 179756179, 399904009, 743481673, 614897918, 206671027, 618188410, 427909462}; 
  dp[9] = {0, 46097865, 577301585, 114208981, 2356894, 179756179, 399904009, 743481673, 614897918, 206671027, 618188410}; 
  dp[10] = {0, 618188410, 427909462, 149392123, 964816865, 37540036, 142216143, 257687866, 485793807, 129104111, 77566916};
  do_op(dp, cnt);
  return;
}

inline void op_10_2(vi &cnt){
  vector<vi> dp(11);
  // Hard code
  dp[1] = {0, 12, 11, 45, 120, 210, 252, 210, 120, 45, 10}; 
  dp[2] = {0, 55, 12, 11, 45, 120, 210, 252, 210, 120, 45}; 
  dp[3] = {0, 165, 55, 12, 11, 45, 120, 210, 252, 210, 120}; 
  dp[4] = {0, 330, 165, 55, 12, 11, 45, 120, 210, 252, 210}; 
  dp[5] = {0, 462, 330, 165, 55, 12, 11, 45, 120, 210, 252}; 
  dp[6] = {0, 462, 462, 330, 165, 55, 12, 11, 45, 120, 210}; 
  dp[7] = {0, 330, 462, 462, 330, 165, 55, 12, 11, 45, 120}; 
  dp[8] = {0, 165, 330, 462, 462, 330, 165, 55, 12, 11, 45}; 
  dp[9] = {0, 56, 165, 330, 462, 462, 330, 165, 55, 12, 11}; 
  dp[10] = {0, 11, 45, 120, 210, 252, 210, 120, 45, 10, 2}; 
  do_op(dp, cnt);
  return;
}

inline void op_10(vi &cnt){
  vi new_cnt;
  new_cnt = cnt;
  for(ll j = 1; j <= 10; j ++){
    if(j == 9){
      new_cnt[j] = (new_cnt[j] + cnt[1] + cnt[j + 1])%MOD;
    }else if(j == 10){
      new_cnt[j] = (new_cnt[j] + cnt[1])%MOD;
    }else{
      new_cnt[j] = (new_cnt[j] + cnt[j + 1]);
    }
  }
  cnt = new_cnt;
}

inline void op_1(vi &cnt){
  vi new_cnt(11);
  for(ll j = 1; j <= 10; j ++){
    if(j == 1){
      new_cnt[10] = (new_cnt[10] + cnt[j])%MOD;
      new_cnt[9] = (new_cnt[9] + cnt[j])%MOD;
    }else{
      new_cnt[j - 1] = (new_cnt[j - 1] + cnt[j])%MOD;
    }
  }
  cnt = new_cnt;
}


void solve()
{
  ll n, m;
  cin >> n >> m;
  vi cnt(11);
  ll sz = 0, nn = n;
  while(nn){
    ll digit = nn%10;
    sz ++;
    cnt[10 - digit] ++;
    nn /= 10;
  }
  ll pw = 5LL;
  while(pw >= 0){
    ll div = (ll)powl(10, pw);
    ll times = m/div;
    while(times--){
      switch(pw) {
         case 5LL  :
            op_10_5(cnt);
            break; //optional
         case 4LL  :
            op_10_4(cnt);
            break; //optional
         case 3LL  :
            op_10_3(cnt);
            break; //optional
         case 2LL  :
            op_10_2(cnt);
            break; //optional
         case 1LL  :
            op_10(cnt);
            break; //optional
         case 0LL  :
            op_1(cnt);
            break; //optional
        
         // you can have any number of case statements.
         default : //Optional
            break;
      }
    }
    m %= div;
    pw --;
  }

  ll sum = 0;
  fr(i, 11){
    sum = (sum + cnt[i])%MOD;
  }
  cout << sum << "\n";
}
 
 
 
int main()
{
 
  #ifndef ONLINE_JUDGE
  freopen("input.txt","r",stdin);
  freopen("output.txt","w",stdout);
  #endif

  ll mx = (ll)2e5 + 5LL;
  vector< vi > dp(11, vi(mx));

  vi cnt(11);
  cnt[1] = 1;

  dp[1][0] = 1;
  fr(i, mx - 1){
    op_1(cnt);
    fr(j, 11){
      dp[1][i + 1] += cnt[j];
      dp[1][i + 1] %= MOD;
    }
  }



  forr(i, 2, 11){
    dp[i][0] = 1;
    forr(j, 1, mx){
      dp[i][j] = dp[i - 1][j - 1];
    }
  }

  // forr(i, 1, 11){
  //   cerr << i << " => ";
  //   fr(j, 25){
  //     cerr << dp[i][j] << " ";
  //   }
  //   cerr << "\n";
  // }
  
  // fact[0] = 1; 
  // for(ll i = 1; i < 200005; i ++){
  //   fact[i] = (fact[i - 1]* i)% MOD;
  // }
  
  zoom;

  int t;
  cin>>t;
  // t=1;
  fr(t1,t)
  {
    // cout<<"Case #"<<t1+1<<": ";
    // solve();
    ll n, m;
    cin >> n >> m;
    string s = to_string(n);
    // trace2(s, m);
    ll sum = 0;
    fr(i, s.size()){
      sum = (sum + dp[10 - (ll)(s[i] - '0')][m])%MOD;
    }
    cout << sum << "\n";
    // // cout<<'\n';
  }
  return 0;
}


