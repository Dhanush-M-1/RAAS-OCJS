#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize "-O3"
const int mod = 1e9 + 7;
int sum(int a, int b) {
  int c = a + b;
  if (c >= mod) {
    c -= mod;
  }
  return c;
}
int dif(int a, int b) {
  int c = a - b;
  if (c < 0) {
    c += mod;
  }
  return c;
}
int mlt(int a, int b) {
  long long c = a * 1LL * b;
  return c % mod;
}
int ibit(int n, int i) { return ((n >> i) & 1); }
void outp1(vector<long long> &ou, string s = " ") {
  cerr << s << endl;
  for (int i = 0; i < ou.size(); i++) {
    cerr << ou[i] << ' ';
  }
  cerr << endl;
}
void outp1(vector<int> &ou, string s = " ") {
  cerr << s << endl;
  for (int i = 0; i < ou.size(); i++) {
    cerr << ou[i] << ' ';
  }
  cerr << endl;
}
void outp2(vector<vector<int>> &ou, string s = " ") {
  cerr << s << endl;
  for (int i = 0; i < ou.size(); i++) {
    for (int j = 0; j < ou[i].size(); j++) {
      cerr << ou[i][j] << ' ';
    }
    cerr << '\n';
  }
}
int bp(int x, int y) {
  if (y == 0) {
    return 1;
  }
  int a = 0;
  if (!(y % 2)) {
    a = bp(x, y / 2);
  }
  return (y % 2) ? mlt(bp(x, y - 1), x) : mlt(a, a);
}
int obr(int x) { return bp(x, mod - 2); }
const int maxn = 301;
int fact[maxn], ofact[maxn];
void prec() {
  fact[0] = 1;
  ofact[0] = 1;
  for (int i = 1; i < maxn; i++) {
    fact[i] = mlt(fact[i - 1], i);
  }
  ofact[maxn - 1] = obr(fact[maxn - 1]);
  for (int i = maxn - 2; i > 0; i--) {
    ofact[i] = mlt(ofact[i + 1], i + 1);
  }
}
int c(int a, int b) {
  return ((a <= b) && (a >= 0)) ? mlt(fact[b], mlt(ofact[a], ofact[b - a])) : 0;
}
int big_check(vector<int> &v, vector<vector<int>> &cols, int mx, int cand) {
  if (mx == cand) return 0;
  int n = v.size();
  vector<int> mxbal(n + 1, -1), mnbal(n + 1, -1);
  int bal = 0;
  mnbal[0] = 0;
  mxbal[0] = 0;
  for (int i = 0; i < n; i++) {
    if (v[i] == mx) bal++;
    if (v[i] == cand) bal--;
    if (bal >= 0) {
      if (mnbal[bal] == -1) mnbal[bal] = i + 1;
      mxbal[bal] = i + 1;
    }
  }
  int cr = 0;
  for (int i = 0; i <= n; i++)
    if (mnbal[i] != -1) cr = max(cr, mxbal[i] - mnbal[i]);
  return cr;
}
int BND = 400;
int small_check(vector<int> &v, vector<vector<int>> &cols, int mx, int cand) {
  if (mx == cand) return 0;
  if (cols[cand].size() == 0) return 0;
  int n = v.size();
  int sz = cols[cand].size();
  int ans = 0;
  for (int i = 0; i < cols[cand].size(); i++) {
    int pos = cols[cand][i];
    int posi =
        lower_bound(cols[mx].begin(), cols[mx].end(), pos) - cols[mx].begin();
    vector<int> addon(sz + 2, -1);
    for (int i = 0; i <= sz + 1; i++)
      if (posi > i) addon[i] = cols[mx][posi - i - 1];
    int bal = 0, where = pos;
    int candp = i, mxp = posi;
    while (true) {
      if (bal >= sz - i + 1) break;
      if (candp == cols[cand].size()) {
        if (mxp == cols[mx].size()) {
          where = n - 1;
          if (bal <= 0) ans = max(ans, where - addon[-bal]);
          break;
        } else {
          where = cols[mx][mxp] - 1;
          if (bal <= 0) ans = max(ans, where - addon[-bal]);
          bal++;
          mxp++;
        }
      } else {
        if (mxp == cols[mx].size()) {
          where = cols[cand][candp] - 1;
          if (bal <= 0) ans = max(ans, where - addon[-bal]);
          bal--;
          candp++;
        } else {
          if (cols[mx][mxp] < cols[cand][candp]) {
            where = cols[mx][mxp] - 1;
            if (bal <= 0) ans = max(ans, where - addon[-bal]);
            bal++;
            mxp++;
          } else {
            where = cols[cand][candp];
            bal--;
            candp++;
            if (bal <= 0) ans = max(ans, where - addon[-bal]);
          }
        }
      }
    }
  }
  return ans;
}
void solve(istream &cin = std::cin, ostream &cout = std::cout) {
  int n = 10;
  cin >> n;
  vector<int> v(n);
  vector<vector<int>> cols(n + 1);
  for (int i = 0; i < n; i++) {
    int x;
    cin >> x;
    v[i] = x;
    cols[x].push_back(i);
  }
  int mx = 0;
  for (int i = 1; i <= n; i++)
    if (cols[i].size() > cols[mx].size()) mx = i;
  int curr = 0;
  for (int i = 0; i < cols.size(); i++) {
    if (cols[i].size() > BND)
      curr = max(curr, big_check(v, cols, mx, i));
    else
      curr = max(curr, small_check(v, cols, mx, i));
  }
  cout << curr << '\n';
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int tests = 1;
  for (int i = 0; i < tests; i++) {
    solve();
  }
}
