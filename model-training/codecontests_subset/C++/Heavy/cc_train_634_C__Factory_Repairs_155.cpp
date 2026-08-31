#include <bits/stdc++.h>
using namespace std;
int n;
int st[2][200005];
void init() { memset(st, 0, sizeof(st)); }
int ask(int pos, int t) {
  int tt = 0;
  for (++pos; pos; pos -= (pos & (-pos))) tt += st[t][pos];
  return tt;
}
void upd(int pos, int v, int t) {
  for (++pos; pos <= n; pos += (pos & (-pos))) st[t][pos] += v;
  return;
}
int main() {
  ios::sync_with_stdio(false);
  cout.setf(ios::fixed);
  cout.precision(20);
  init();
  int N, k, a, b, q, t, d, h;
  cin >> N >> k >> a >> b >> q;
  n = N + 10;
  while (q--) {
    cin >> t >> d;
    if (t == 1) {
      cin >> h;
      int tmp = ask(d, 0) - ask(d - 1, 0);
      int tmp2 = ask(d, 1) - ask(d - 1, 1);
      upd(d, -tmp, 0);
      upd(d, -tmp2, 1);
      upd(d, (b < tmp + h ? b : tmp + h), 0);
      upd(d, (a < tmp2 + h ? a : tmp2 + h), 1);
    } else {
      cout << ask(N, 1) - ask(d + k - 1, 1) + ask(d - 1, 0) << '\n';
    }
  }
  return 0;
}
