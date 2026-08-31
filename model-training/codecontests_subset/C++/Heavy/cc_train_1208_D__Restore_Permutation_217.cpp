#include <bits/stdc++.h>
using namespace std;
const int N = 222222;
int p[N], a[N], streee[N << 2];
long long s[N], stree[N << 2];
int n;
void supdate(int x, int v, int l, int r, int pos) {
  if (l == r) {
    streee[pos] += v;
    return;
  }
  int m = l + (r - l) / 2;
  if (x <= m) {
    supdate(x, v, l, m, pos * 2 + 1);
  } else {
    supdate(x, v, m + 1, r, pos * 2 + 2);
  }
  streee[pos] = streee[pos * 2 + 1] + streee[pos * 2 + 2];
}
int squery(int i, int l, int r, int pos) {
  if (l == r) {
    return l;
  }
  int m = l + (r - l) / 2;
  if (i > streee[2 * pos + 1]) {
    return squery(i - streee[2 * pos + 1], m + 1, r, pos * 2 + 2);
  }
  return squery(i, l, m, pos * 2 + 1);
}
long long build(int l, int r, int pos) {
  if (l == r) {
    stree[pos] = a[l];
    return stree[pos];
  }
  int m = l + r >> 1;
  long long x = build(l, m, pos * 2 + 1);
  long long y = build(m + 1, r, pos * 2 + 2);
  stree[pos] = x + y;
  return stree[pos];
}
void update(int i, int cl, int cr, int pos) {
  if (cl == i && cr == i) {
    stree[pos] = 0;
    return;
  }
  int m = cl + cr >> 1;
  if (i <= m) {
    update(i, cl, m, pos * 2 + 1);
  } else {
    update(i, m + 1, cr, pos * 2 + 2);
  }
  stree[pos] = stree[pos * 2 + 1] + stree[pos * 2 + 2];
}
long long query(int l, int r, int cl, int cr, int pos) {
  if (cl > r || cr < l) {
    return 0;
  } else if (cl >= l && cr <= r) {
    return stree[pos];
  }
  int m = cl + cr >> 1;
  long long x = query(l, r, cl, m, pos * 2 + 1);
  long long y = query(l, r, m + 1, cr, pos * 2 + 2);
  return x + y;
}
int solve(long long sum, int si) {
  int l = 1, r = si;
  while (l < r) {
    int i = l + r >> 1;
    int ii = squery(i, 1, n, 0);
    long long curr = query(0, ii - 1, 1, n, 0);
    if (curr < sum) {
      l = i + 1;
    } else {
      r = i;
    }
  }
  return squery(l, 1, n, 0);
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cin >> n;
  for (int i = (1); i <= (n); i++) {
    cin >> s[i];
    a[i] = i;
    supdate(i, 1, 1, n, 0);
  }
  build(1, n, 0);
  for (int i = (n); i >= (1); i--) {
    p[i] = solve(s[i], i);
    update(p[i], 1, n, 0);
    supdate(p[i], -1, 1, n, 0);
  }
  for (int i = (1); i <= (n); i++) {
    cout << p[i] << " ";
  }
  cout << "\n";
  return 0;
}
