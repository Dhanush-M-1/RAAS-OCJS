#include <bits/stdc++.h>
using namespace std;
const long long int N = 1e5 + 1;
void solve() {
  long long int n, m, k, p = 0, q = 0, s = 0, c = 0, i, j;
  cin >> n;
  map<int, int> m1, m2, m3;
  for (long long int i = 0; i < n; i++) cin >> p, m1[p]++;
  for (long long int i = 0; i < n - 1; i++) cin >> p, m3[p]++;
  for (long long int i = 0; i < n - 2; i++) cin >> p, m2[p]++;
  for (auto it : m3) {
    m1[it.first] -= it.second;
  }
  for (auto it : m1)
    if (it.second > 0) {
      cout << it.first << "\n";
      break;
    }
  for (auto it : m2) {
    m3[it.first] -= it.second;
  }
  for (auto it : m3)
    if (it.second > 0) {
      cout << it.first << "\n";
      break;
    }
  return;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int t = 1;
  while (t--) {
    solve();
  }
  return 0;
}
