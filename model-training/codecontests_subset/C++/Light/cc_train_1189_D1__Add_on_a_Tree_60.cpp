#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long n, l, r, cnt = 0;
  cin >> n;
  vector<long long> v[n + 1];
  bool ok = true;
  for (long long i = 0; i < n - 1; ++i) {
    cin >> l >> r;
    v[l].push_back(r);
    v[r].push_back(l);
  }
  for (long long i = 1; i <= n; ++i) {
    if (v[i].size() == 2) ok = false;
  }
  cout << ((ok) ? "YES\n" : "NO\n");
  return 0;
}
