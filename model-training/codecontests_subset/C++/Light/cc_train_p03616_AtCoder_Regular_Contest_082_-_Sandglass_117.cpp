#include <iostream>
#include <string>
#include <vector>
#include <queue>
#include <deque>
#include <algorithm>
#include <set>
#include <map>
#include <bitset>
#include <cmath>
#include <functional>
#include <iomanip>
#define vll vector<ll>
#define vvvl vector<vvl>
#define vvl vector<vector<ll>>
#define VV(a, b, c, d) vector<vector<d> >(a, vector<d>(b, c))
#define VVV(a, b, c, d) vector<vvl>(a, vvl(b, vll (c, d)));
#define re(c, b) for(ll c=0;c<b;c++)
#define all(obj) (obj).begin(), (obj).end()
typedef long long int ll;
typedef long double ld;
using namespace std;

int main(int argc, char const *argv[]) {
  ll x, k;std::cin >> x >> k;
  multiset<vll> st;
  for(int i=0;i<k;i++){
    ll a;scanf("%lld", &a);
    st.insert(vll{a, -10000000000});
  }
  ll q;std::cin >> q;
  for(int i=0;i<q;i++){
    ll t, a;scanf("%lld %lld", &t, &a);
    st.insert(vll{t, a});
  }
  ll prev = 0;
  ll a = 0, b = x, c = 0, cnt = 0;

  for(auto v:st){
    ll sa = v[0] - prev;
    if(cnt%2){
      c += sa;
      if(b+c>x) b = x - c;
      if(a>b) a = b;
    }else{
      c -= sa;
      if(a+c<0) a = -c;
      if(a>b) b = a;
    }
    prev = v[0];
    if(v[1]==-10000000000) cnt++;
    else std::cout << max(a, min(b, v[1])) + c << '\n';
  }
  return 0;
}
