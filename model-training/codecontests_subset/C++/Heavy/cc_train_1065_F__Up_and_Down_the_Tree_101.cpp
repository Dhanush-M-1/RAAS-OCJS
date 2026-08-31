#include <bits/stdc++.h>
#pragma GCC optimize("O3")
#pragma GCC optimize("unroll-loops")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
using namespace std;
using ii = pair<int, int>;
using ll = long long;
using db = long double;
using PT = pair<ll, ll>;
const int N = 1e6 + 5, K = 105, MOD = 1e9 + 7;
const ll MX = 1e15;
bool leaf[N];
vector<int> adj[N];
int n, k;
struct num {
  int goUp, retVal, nonRetVal;
  num() {}
};
num dfs(int u) {
  num ret;
  if (leaf[u]) {
    ret.goUp = k;
    ret.retVal = 1;
    ret.nonRetVal = 1;
    return ret;
  }
  vector<num> canReturn;
  vector<num> canNotReturn;
  for (auto v : adj[u]) {
    auto x = dfs(v);
    x.goUp--;
    if (x.goUp >= 0) {
      canReturn.push_back(x);
    } else
      canNotReturn.push_back(x);
  }
  ret.goUp = 0;
  ret.retVal = 0;
  ret.nonRetVal = 0;
  for (auto x : canReturn) {
    ret.goUp = max(x.goUp, ret.goUp);
    ret.retVal += x.retVal;
  }
  ret.nonRetVal = ret.retVal;
  int mx = 0;
  for (auto x : canNotReturn) {
    mx = max(mx, x.nonRetVal);
  }
  ret.nonRetVal += mx;
  for (auto x : canReturn) {
    ret.nonRetVal = max(ret.nonRetVal, ret.retVal - x.retVal + x.nonRetVal);
  }
  return ret;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  memset(leaf, 1, sizeof leaf);
  cin >> n >> k;
  for (int i = 2, p; i <= n; i++) {
    cin >> p;
    leaf[p] = false;
    adj[p].push_back(i);
  }
  auto ans = dfs(1);
  cout << ans.nonRetVal << '\n';
  return 0;
}
