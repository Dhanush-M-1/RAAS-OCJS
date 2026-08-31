#include <bits/stdc++.h>
using namespace std;
long bst, bp, qpos;
long n, r, c, sz[2000000], rr, span;
long ans[1100000][23];
string st[1100000];
long nlfl, ql;
double explen;
void do_nline(long i) {
  nlfl = 1;
  cout << endl;
  ql = 0;
  explen = sz[i];
}
int main() {
  ios_base::sync_with_stdio(0);
  cin >> n >> r >> c;
  for (int i = 1; i <= n; i++) {
    cin >> st[i];
    sz[i] = st[i].size();
  }
  rr = n;
  for (int i = n; i; --i) {
    span += sz[i] + 1;
    if (rr == i) span = sz[i];
    while (span > c) {
      if (rr > i)
        span -= (sz[rr] + 1);
      else
        span -= sz[rr];
      --rr;
    }
    ans[i][0] = rr;
  }
  for (int pw = 0; pw <= 22; pw++) ans[n + 1][pw] = n;
  for (long pw = 1; pw <= 22; pw++)
    for (long i = n; i >= 1; --i)
      ans[i][pw] = max(i - 1, ans[ans[i][pw - 1] + 1][pw - 1]);
  bst = -1000;
  bp = 0;
  for (int i = 1; i <= n; i++) {
    qpos = i - 1;
    for (int pw = 20; pw >= 0; --pw)
      if (r & (1 << pw)) qpos = ans[qpos + 1][pw];
    span = qpos - i + 1;
    if (span > bst) {
      bst = span;
      bp = i;
    }
  }
  ql = 0;
  nlfl = 1;
  for (int i = bp; i < bp + bst; i++) {
    explen = ql + sz[i];
    if (i > bp) explen++;
    if (explen > c) {
      do_nline(i);
    }
    if (nlfl == 0) cout << " ";
    cout << st[i];
    nlfl = 0;
    ql = explen;
  }
  cout << endl;
  cin.get();
  cin.get();
  return 0;
}
