#include <bits/stdc++.h>
using namespace std;
int t, m, d[107], cnt = 0, temp, curr;
string s;
void solve() {
  cin >> s;
  if (s == "alloc") {
    cin >> curr;
    int j, k;
    for (j = 0, k = -1; j < m; ++j) {
      if (j - k == curr && !d[j]) {
        break;
      } else if (d[j]) {
        k = j;
      }
    }
    if (j - k == curr && j < m) {
      cout << ++cnt << endl;
      for (int l = k + 1; l <= j; ++l) {
        d[l] = cnt;
      }
    } else {
      cout << "NULL" << endl;
    }
  }
  if (s == "erase") {
    cin >> curr;
    int p = 0;
    for (int j = 0; j < m; ++j) {
      if (d[j] == curr && curr) {
        d[j] = 0, p = 1;
      }
    }
    if (!p) {
      cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
    }
  }
  if (s == "defragment") {
    for (int j = 0, k = 0; j < m; ++j) {
      if (d[j]) {
        temp = d[k], d[k] = d[j], d[j] = temp, k++;
      }
    }
  }
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> t >> m;
  while (t--) solve();
  return 0;
}
