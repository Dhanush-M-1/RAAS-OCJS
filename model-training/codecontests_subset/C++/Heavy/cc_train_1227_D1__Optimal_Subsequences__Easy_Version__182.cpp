#include <bits/stdc++.h>
using namespace std;
const int INF = 2e9;
void solve() {
  int n, k, m, pos;
  cin >> n;
  vector<int> a(n);
  for (int i = 0; i < n; i++) cin >> a[i];
  cin >> m;
  for (int _ = 0; _ < m; _++) {
    cin >> k >> pos;
    vector<int> ind;
    set<int> s;
    for (int i = 0; i < k; i++) {
      int maxi = -1;
      for (int j = 0; j < n; j++) {
        if (s.find(j) != s.end()) continue;
        if (maxi == -1)
          maxi = j;
        else if (a[maxi] < a[j]) {
          maxi = j;
        }
      }
      s.insert(maxi);
    }
    int h = 1;
    for (auto i : s) {
      if (h == pos) cout << a[i] << endl;
      h++;
    }
  }
  exit(0);
}
int main() {
  int t = 1;
  for (int i = 0; i < t; i++) solve();
  return 0;
}
