#include <bits/stdc++.h>
using namespace std;
void solve() {
  long long n, k, ans = 1e10;
  cin >> n >> k;
  vector<long long> alice, bob, both, prb, pra, prboth;
  for (long long i = 1; i <= n; i++) {
    long long t, a, b;
    cin >> t >> a >> b;
    if (a && b)
      both.push_back(t);
    else if (a)
      alice.push_back(t);
    else if (b)
      bob.push_back(t);
  }
  sort(alice.begin(), alice.end());
  sort(bob.begin(), bob.end());
  sort(both.begin(), both.end());
  for (long long i = 0; i < signed(bob.size()); i++) {
    if (!i)
      prb.push_back(bob[i]);
    else
      prb.push_back(prb.back() + bob[i]);
  }
  for (long long i = 0; i < signed(alice.size()); i++) {
    if (!i)
      pra.push_back(alice[i]);
    else
      pra.push_back(pra.back() + alice[i]);
  }
  for (long long i = 0; i < signed(both.size()); i++) {
    if (!i)
      prboth.push_back(both[i]);
    else
      prboth.push_back(prboth.back() + both[i]);
  }
  if (signed(alice.size()) >= k && signed(bob.size()) >= k)
    ans = min(ans, prb[k - 1] + pra[k - 1]);
  for (long long i = 0; i < k && i < signed(both.size()); i++) {
    long long x = k - i - 1;
    if (signed(alice.size()) >= x && signed(bob.size()) >= x && x > 0)
      ans = min(ans, prboth[i] + pra[x - 1] + prb[x - 1]);
    if (i == k - 1) ans = min(ans, prboth[i]);
  }
  cout << ((ans == 1e10) ? -1 : ans) << "\n";
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  long long t = 1;
  while (t--) solve();
  return 0;
}
