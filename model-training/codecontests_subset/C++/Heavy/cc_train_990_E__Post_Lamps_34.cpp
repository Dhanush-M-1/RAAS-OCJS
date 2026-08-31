#include <bits/stdc++.h>
using namespace std;
using ll = long long;
int main() {
  ios_base::sync_with_stdio(false);
  int n, m, k, p, mg = -1;
  cin >> n >> m >> k;
  vector<int> back(n + 1);
  for (int i = 0; i < n + 1; ++i) back[i] = i;
  while (m--) {
    cin >> p;
    if (p == 0) {
      cout << "-1\n";
      return 0;
    }
    back[p] = back[p - 1];
  }
  for (int i = 1; i < n; ++i) mg = max(mg, i - back[i]);
  mg++;
  vector<ll> prz(n);
  ll ans = 1LL << 60;
  for (int i = 0; i < k; ++i) {
    ll cost;
    int jmp = i + 1;
    cin >> cost;
    if (jmp < mg) continue;
    int x = 0;
    ll ile = 0;
    while (x < n) {
      x = back[min(n, x + jmp)];
      ile++;
    }
    ans = min(ans, ile * cost);
  }
  cout << (ans == 1LL << 60 ? -1 : ans) << endl;
}
