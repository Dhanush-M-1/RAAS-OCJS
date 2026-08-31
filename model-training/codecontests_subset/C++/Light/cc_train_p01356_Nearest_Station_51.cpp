#include <bits/stdc++.h>

#define REP(i,n) for(ll i=0;i<(ll)(n);i++)

using namespace std;
typedef long long ll;
typedef __int128_t dll;

int main() {
  ll n,m,a,b,p,q;
  cin>>n>>m>>a>>b>>p>>q;
  if (a == b && b == 1) {
    if (n > m/(p+q))
      cout << min(m%(p+q), ((p+q)-(m%(p+q)))%(p+q)) << endl;
    else
      cout << m-(p+q)*n << endl;
    return 0;
  }
  vector<ll> nums;
  dll pa = p, qb = q;
  REP(i,n) {
    if (pa + qb >= 2*m) break;
    nums.push_back(pa+qb);
    pa *= a;
    qb *= b;
  }
  int l = nums.size();
  int s1 = l/2, s2=l-s1;;
  vector<ll> lsr(begin(nums),begin(nums)+s1);
  vector<ll> gtr(begin(nums)+s1,end(nums));
  vector<ll> l1(1<<s1),l2(1<<s2);
  REP(i,1<<s1) REP(j,s1)
    if((i>>j)&1) l1[i] += lsr[j];
  REP(i,1<<s2) REP(j,s2)
    if((i>>j)&1) l2[i] += gtr[j];
  sort(begin(l2),end(l2));
  ll mn = m;
  REP(i,1<<s1) {
    auto itr = lower_bound(begin(l2),end(l2),m-l1[i]);
    if(itr!=end(l2)) mn=min(mn,(l1[i]+*itr)-m);
    if(itr!=begin(l2)) mn=min(mn,m-(l1[i]+*prev(itr)));
  }
  cout << mn << endl;
  return 0;
}