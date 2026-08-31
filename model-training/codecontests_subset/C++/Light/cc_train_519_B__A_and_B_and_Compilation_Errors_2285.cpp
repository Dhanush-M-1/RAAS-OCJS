#include <bits/stdc++.h>
using namespace std;
int32_t main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  ;
  long long n, x;
  cin >> n;
  map<long long, long long> m, m1, m2;
  for (long long i = 0; i < n; i++) {
    cin >> x;
    m[x]++;
  }
  for (long long i = 0; i < n - 1; i++) {
    cin >> x;
    m1[x]++;
  }
  for (auto i : m) {
    if (m[i.first] != m1[i.first]) cout << i.first << "\n";
  }
  for (long long i = 0; i < n - 2; i++) {
    cin >> x;
    m2[x]++;
  }
  for (auto i : m1) {
    if (m2[i.first] != m1[i.first]) cout << i.first << "\n";
  }
  return 0;
}
