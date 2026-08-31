#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 5;
int n, r, c, len[N], ans[N][20], opt[N];
string s[N];
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cin >> n >> r >> c;
  for (int i = (0); i < (n); i++) {
    cin >> s[i];
    len[i] = s[i].length();
  }
  int j = 0, L = -1;
  ans[n][0] = n;
  for (int i = (0); i < (n); i++) {
    while (j < n && L + len[j] + 1 <= c) {
      L += len[j] + 1;
      j++;
    }
    ans[i][0] = j;
    if (r & 1) {
      opt[i] = j;
    } else {
      opt[i] = i;
    }
    L -= len[i] + 1;
  }
  for (int l = (1); l < (20); l++) {
    for (int i = (0); i < (n); i++) {
      ans[i][l] = ans[ans[i][l - 1]][l - 1];
    }
    ans[n][l] = n;
    if ((r >> l) & 1) {
      for (int i = (0); i < (n); i++) {
        opt[i] = ans[opt[i]][l];
      }
    }
  }
  int mx = -1, idx = 0;
  for (int i = (0); i < (n); i++) {
    if (opt[i] - i > mx) {
      mx = opt[i] - i;
      idx = i;
    }
  }
  for (int i = (0); i < (r); i++) {
    for (int j = (idx); j < (ans[idx][0]); j++) {
      cout << s[j];
      if (j < ans[idx][0] - 1) cout << ' ';
    }
    cout << '\n';
    idx = ans[idx][0];
    if (ans[idx][0] == idx) break;
  }
}
