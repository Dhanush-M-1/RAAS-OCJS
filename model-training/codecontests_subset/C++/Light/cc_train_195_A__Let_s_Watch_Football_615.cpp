#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,avx2,fma")
#pragma GCC optimize("unroll-loops")
using namespace std;
long long int MOD = 1000000007;
double eps = 1e-12;
vector<vector<long long int>> mat(1001, vector<long long int>(1001, 0));
vector<vector<bool>> vis(1001, vector<bool>(1001, false));
void solve() {
  float a, b, c;
  cin >> a >> b >> c;
  if ((int)a < (int)b)
    cout << "0";
  else {
    int tot = ceil(c * a / b);
    cout << tot - (int)c;
  }
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int t = 1;
  while (t--) {
    solve();
  }
}
