#include <bits/stdc++.h>
using namespace std;
int dx[4] = {1, -1, 0, 0};
int dy[4] = {0, 0, 1, -1};
void solve() {
  long long int n, m;
  cin >> n >> m;
  map<long long int, long long int> um1, um2;
  for (int i = 0; i < (n); ++i) {
    long long int num;
    cin >> num;
    um1[num]++;
  }
  for (int i = 0; i < (m); ++i) {
    long long int num;
    cin >> num;
    um2[num]++;
  }
  for (auto it : um1) {
    if (um2[it.first] > 0) {
      cout << "YES" << '\n';
      cout << 1 << " ";
      cout << it.first << '\n';
      return;
    }
  }
  cout << "NO" << '\n';
}
int main() {
  int t;
  cin >> t;
  while (t--) {
    solve();
  }
  return 0;
}
