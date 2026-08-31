#include <bits/stdc++.h>
using namespace std;
const int MAX_N = 1000005;
int n, r, c;
string str;
string s[MAX_N];
int sum[MAX_N];
int siz[MAX_N];
int to[MAX_N];
int f[MAX_N][21];
int calc(int l, int r) { return sum[r] - sum[l - 1] + (r - l); }
int main() {
  cin >> n >> r >> c;
  for (int i = 1; i <= n; i++) cin >> s[i];
  for (int i = 1; i <= n; i++) siz[i] = s[i].size();
  for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + siz[i];
  int pt = 1;
  for (int i = 1; i <= n; i++) {
    if (siz[i] > c) {
      to[i] = -1;
      continue;
    }
    while (pt < n && calc(i, pt + 1) <= c) pt++;
    to[i] = pt;
  }
  for (int i = 1; i <= n; i++) f[i][0] = to[i] + 1;
  for (int j = 1; j <= 20; j++) {
    for (int i = 1; i <= n; i++) {
      f[i][j] = f[f[i][j - 1]][j - 1];
    }
  }
  int lb = 1, ub = 0;
  for (int i = 1; i <= n; i++) {
    int pt = i;
    int skip = r;
    for (int j = 20; j >= 0; j--) {
      if (f[pt][j] && skip >= (1 << j)) {
        pt = f[pt][j];
        skip -= (1 << j);
      }
    }
    if (pt - i > ub - lb + 1) {
      ub = pt - 1;
      lb = i;
    }
  }
  string str;
  for (int i = lb; i <= ub; i++) {
    if (!str.empty() && str.size() + 1 + s[i].size() > c) {
      cout << str << endl;
      str = "";
    }
    if (str.empty())
      str += s[i];
    else if (!str.empty() && str.size() + 1 + s[i].size() <= c)
      str += ' ' + s[i];
  }
  if (!str.empty()) cout << str << endl;
  return 0;
}
