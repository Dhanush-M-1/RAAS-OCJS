#include <bits/stdc++.h>
using namespace std;
void solve() {
  long long n;
  cin >> n;
  vector<long long> v1(n);
  vector<long long> v2(n - 1);
  vector<long long> v3(n - 2);
  for (long long i = 0; i < n; i++) cin >> v1[i];
  for (long long i = 0; i < n - 1; i++) cin >> v2[i];
  for (long long i = 0; i < n - 2; i++) cin >> v3[i];
  unordered_map<long long, long long> m1;
  unordered_map<long long, long long> m2;
  unordered_map<long long, long long> m3;
  for (long long i = 0; i < n; i++) m1[v1[i]]++;
  for (long long i = 0; i < n - 1; i++) m2[v2[i]]++;
  for (long long i = 0; i < n - 2; i++) m3[v3[i]]++;
  for (long long i = 0; i < n; i++) {
    if (m1[v1[i]] != m2[v1[i]]) {
      cout << v1[i] << "\n";
      break;
    }
  }
  for (long long i = 0; i < n - 1; i++) {
    if (m2[v2[i]] != m3[v2[i]]) {
      cout << v2[i] << "\n";
      break;
    }
  }
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  int t = 1;
  while (t--) {
    solve();
  }
  return 0;
}
