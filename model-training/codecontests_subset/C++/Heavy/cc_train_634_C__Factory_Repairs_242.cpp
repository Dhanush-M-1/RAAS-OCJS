#include <bits/stdc++.h>
using namespace std;
const int INF = int(1e9);
struct debugger {
  template <typename T>
  debugger& operator,(const T& v) {
    cerr << v << " ";
    return *this;
  }
} dbg;
int n, k, A, B, q;
vector<pair<int, int> > st;
pair<int, int> merge(pair<int, int> p1, pair<int, int> p2) {
  pair<int, int> ans = {p1.first + p2.first, p1.second + p2.second};
  return ans;
}
void update(int p, int L, int R, int pos, int val) {
  if (pos < L || pos > R) return;
  if (pos == L && pos == R) {
    st[p].first = min(A, st[p].first + val);
    st[p].second = min(B, st[p].second + val);
    return;
  }
  int mid = (L + R) / 2;
  update(p * 2, L, mid, pos, val);
  update(p * 2 + 1, mid + 1, R, pos, val);
  st[p] = merge(st[p * 2], st[p * 2 + 1]);
}
pair<int, int> query(int p, int L, int R, int i, int j) {
  if (i > R || j < L) return {0, 0};
  if (i <= L && j >= R) return st[p];
  int mid = (L + R) / 2;
  pair<int, int> p1 = query(p * 2, L, mid, i, j);
  pair<int, int> p2 = query(p * 2 + 1, mid + 1, R, i, j);
  return merge(p1, p2);
}
int main() {
  cin >> n >> k >> A >> B >> q;
  st.assign(4 * n, {0, 0});
  while (q--) {
    int type;
    cin >> type;
    if (type == 1) {
      int pos, val;
      cin >> pos >> val;
      pos--;
      update(1, 0, n - 1, pos, val);
    } else {
      int pos;
      cin >> pos;
      pos--;
      pair<int, int> fh = {0, 0}, sh = {0, 0};
      if (pos) fh = query(1, 0, n - 1, 0, pos - 1);
      if (pos + k < n) sh = query(1, 0, n - 1, pos + k, n - 1);
      int res = fh.second + sh.first;
      cout << res << endl;
    }
  }
  return 0;
}
