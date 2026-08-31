#include <bits/stdc++.h>
using namespace std;
long long gcd(long long a, long long b) { return b == 0 ? a : gcd(b, a % b); }
long long powmod(long long a, long long b) {
  long long res = 1;
  if (a >= 1000000007) a %= 1000000007;
  for (; b; b >>= 1) {
    if (b & 1) res = res * a;
    if (res >= 1000000007) res %= 1000000007;
    a = a * a;
    if (a >= 1000000007) a %= 1000000007;
  }
  return res;
}
static bool cmp(pair<long long, long long>& a, pair<long long, long long>& b) {
  return (a.second == b.second) ? a.first > b.first : a.second < b.second;
}
void solve() {
  set<string> s;
  string s1;
  cin >> s1;
  string s2;
  cin >> s2;
  s.insert(s1);
  s.insert(s2);
  cout << s1 << " " << s2 << endl;
  long long q;
  cin >> q;
  while (q--) {
    string x, y;
    cin >> x >> y;
    auto it = s.find(x);
    auto it2 = s.find(y);
    if (it != s.end()) {
      s.erase(x);
      s.insert(y);
    }
    if (it2 != s.end()) {
      s.erase(y);
      s.insert(x);
    }
    for (auto x : s) {
      cout << x << " ";
    }
    cout << endl;
  }
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  { solve(); }
  cerr << "time taken : " << (float)clock() / CLOCKS_PER_SEC << " secs"
       << "\n";
  return 0;
}
