#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using ld = long double;
vector<ll> v;
int main() {
  std::ios::sync_with_stdio(false);
  string s;
  ll n;
  cin >> n;
  cin >> s;
  for (int i = 0; i < n - 1; ++i) {
    if (s[i] > s[i + 1]) {
      cout << "YES" << endl;
      cout << (i + 1) << " " << (i + 2) << endl;
      return 0;
    }
  }
  cout << "NO" << endl;
}
