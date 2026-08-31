#include <bits/stdc++.h>
using namespace std;
void solve();
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  srand(time(0));
  solve();
  return 0;
}
long long max(long long a, long long b) {
  if (a > b) return a;
  return b;
}
long long min(long long a, long long b) {
  if (a < b) return a;
  return b;
}
long long n;
vector<vector<long long> > a(200001);
void solve() {
  cin >> n;
  for (long long i = 0; i < n - 1; i++) {
    long long u, v;
    cin >> u >> v;
    u--, v--;
    a[u].push_back(v);
    a[v].push_back(u);
  }
  if (n == 2) {
    cout << "YES";
    return;
  }
  for (long long i = 0; i < n; i++) {
    if (a[i].size() == 2) {
      cout << "NO";
      return;
    }
  }
  cout << "YES";
}
