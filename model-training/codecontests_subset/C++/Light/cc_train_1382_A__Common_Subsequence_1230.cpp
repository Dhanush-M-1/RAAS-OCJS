#include <bits/stdc++.h>
using namespace std;
void g_o_a_l() {
  long long n, m, q;
  string s;
  map<long long, long long> p, r;
  cin >> n >> m;
  for (int i = 0; i < n; i++) {
    cin >> q;
    ++p[q];
  }
  long long j = 0;
  for (int i = 0; i < m; i++) {
    cin >> q;
    ++r[q];
    if (p[q] > 0 && r[q] > 0) j = q;
  }
  if (j)
    cout << "YES"
         << "\n"
         << 1 << " " << j << "\n";
  else
    cout << "NO"
         << "\n";
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  ;
  int t = 1;
  cin >> t;
  while (t--) {
    g_o_a_l();
  }
  return 0;
}
