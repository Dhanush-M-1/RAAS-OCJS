#include <bits/stdc++.h>
using namespace std;
void solve() {
  int n;
  cin >> n;
  vector<int> v(n);
  int hund = 0, two = 0;
  for (int i = 0; i < (int)n; i++) {
    cin >> v[i];
    if (v[i] == 100)
      hund++;
    else
      two++;
  }
  int full = hund * 100 + two * 200;
  if (full % 200 != 0)
    cout << "NO\n";
  else {
    int half = full / 2;
    int ans = 0;
    for (int i = 0; i < (int)two + 1; i++)
      if (half - (i * 200) >= 0 && half - (i * 200) <= hund * 100) ans = 1;
    if (ans)
      cout << "YES\n";
    else
      cout << "NO\n";
  }
}
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(nullptr);
  auto start = std::chrono::high_resolution_clock::now();
  int t = 1;
  while (t--) solve();
  auto stop = std::chrono::high_resolution_clock::now();
  auto duration =
      std::chrono::duration_cast<std::chrono::nanoseconds>(stop - start);
  cerr << "\nTime taken : "
       << ((long double)duration.count()) / ((long double)1e9) << " s " << endl;
  return 0;
}
