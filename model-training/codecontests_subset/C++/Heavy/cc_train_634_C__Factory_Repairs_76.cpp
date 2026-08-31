#include <bits/stdc++.h>
using namespace std;
struct less_key {
  bool operator()(const pair<int64_t, int64_t>& p1,
                  const pair<int64_t, int64_t>& p2) {
    return p1.first < p2.first ||
           (p1.first == p2.first && p1.second > p2.second);
  }
};
struct pair_hash {
  std::size_t operator()(const pair<int64_t, int64_t>& k) const {
    return static_cast<size_t>(k.first ^ k.second);
  }
};
int64_t n, k, a, b, q;
int64_t sta[524300];
int64_t stb[524300];
int64_t N;
void build() {
  N = 1;
  while (N < n) {
    N <<= 1;
  }
  return;
}
int64_t find(int64_t st[], int64_t i, int64_t tl, int64_t tr, int64_t l,
             int64_t r) {
  if (l > tr || r < tl) {
    return 0;
  }
  if (l <= tl && tr <= r) {
    return st[i];
  }
  int64_t t1 = find(st, i * 2, tl, (tl + tr) / 2, l, r);
  int64_t t2 = find(st, i * 2 + 1, (tl + tr) / 2 + 1, tr, l, r);
  return t1 + t2;
}
void update(int64_t st[], int64_t i, int64_t tl, int64_t tr, int64_t pos,
            int64_t new_val) {
  if (tl == tr)
    st[i] = new_val;
  else {
    int64_t tm = (tl + tr) / 2;
    if (pos <= tm) {
      update(st, i * 2, tl, tm, pos, new_val);
    } else {
      update(st, i * 2 + 1, tm + 1, tr, pos, new_val);
    }
    st[i] = st[i * 2] + st[i * 2 + 1];
  }
}
int64_t find(int64_t st[], int64_t l, int64_t r) {
  if (r < l) {
    return 0;
  }
  return find(st, 1, 0, N - 1, l, r);
}
void update(int64_t st[], int64_t pos, int64_t new_val) {
  update(st, 1, 0, N - 1, pos, new_val);
}
int main() {
  ios_base::sync_with_stdio(false);
  cin >> n >> k >> a >> b >> q;
  build();
  for (int64_t i = 0; i < q; i++) {
    int64_t t;
    cin >> t;
    switch (t) {
      case 1: {
        int64_t d, x;
        cin >> d >> x;
        update(sta, d - 1, min(sta[N + d - 1] + x, a));
        update(stb, d - 1, min(stb[N + d - 1] + x, b));
        break;
      }
      case 2: {
        int64_t p;
        cin >> p;
        int64_t t1 = find(stb, 0, p - 1 - 1);
        int64_t t2 = find(sta, p - 1 + k, n - 1);
        cout << t1 + t2 << endl;
        break;
      }
    }
  }
  return 0;
}
