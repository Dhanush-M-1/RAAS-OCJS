#include <bits/stdc++.h>
using namespace std;
long long n, fwk[2][200001], ps[200001] = {}, pv[200001] = {}, to1 = 0, to2 = 0;
set<long long> s;
set<long long>::iterator it;
void upd(int x, int t, long long v) {
  for (; x <= n; x += x & (-x)) {
    fwk[t][x] += v;
  }
}
long long qry(int x, int t) {
  long long to = 0;
  for (; x; x -= x & (-x)) {
    to += fwk[t][x];
  }
  return to;
}
long long sm(long long n) { return n * (n + 1) / 2; }
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  for (int i = 0; i < n; i++) {
    int x;
    cin >> x;
    ps[x] = i;
  }
  for (int i = 1; i <= n; i++) {
    if (i == 1) {
      it = s.insert(ps[i]).first;
    } else if (i % 2) {
      s.insert(ps[i]);
      if (ps[i] > *it) {
        it = next(it);
      }
    } else {
      s.insert(ps[i]);
      if (ps[i] < *it) {
        it = prev(it);
      }
    }
    upd(ps[i] + 1, 0, 1);
    upd(ps[i] + 1, 1, ps[i]);
    to1 = (i % 2) * (*it) -
          (2 * sm((i - 1) / 2) + ((i % 2 == 0) ? (i / 2) : 0)) -
          2 * qry((*it) + 1, 1) + qry(n, 1);
    to2 += (long long)(i - qry(ps[i] + 1, 0));
    cout << to1 + to2;
    if (i < n) {
      cout << " ";
    }
  }
  cout << "\n";
  return 0;
}
