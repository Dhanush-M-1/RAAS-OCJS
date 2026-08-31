#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 1, base = (1 << 19);
int n, p[N], inv_t[2 * base + 1], where[N], pref;
long long pos_t[2 * base + 1];
void add(int pos) {
  pos += base;
  while (pos) {
    inv_t[pos]++;
    pos /= 2;
  }
}
int sum(int l, int r) {
  l += base;
  r += base;
  int res = inv_t[l];
  if (l != r) {
    res += inv_t[r];
  }
  while (l / 2 != r / 2) {
    if (l % 2 == 0) {
      res += inv_t[l + 1];
    }
    if (r % 2 == 1) {
      res += inv_t[r - 1];
    }
    l /= 2;
    r /= 2;
  }
  return res;
}
int find_med(int id, int k) {
  if (id >= base) {
    return id - base;
  }
  if (inv_t[id * 2] + pref >= k) {
    return find_med(id * 2, k);
  }
  pref += inv_t[id * 2];
  return find_med(id * 2 + 1, k);
}
void ins(int pos, long long val) {
  pos += base;
  while (pos) {
    pos_t[pos] += val;
    pos /= 2;
  }
}
long long pos_q(int l, int r) {
  l += base;
  r += base;
  long long res = pos_t[l];
  if (l != r) {
    res += pos_t[r];
  }
  while (l / 2 != r / 2) {
    if (l % 2 == 0) {
      res += pos_t[l + 1];
    }
    if (r % 2 == 1) {
      res += pos_t[r - 1];
    }
    l /= 2;
    r /= 2;
  }
  return res;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  for (int i = 0; i < n; ++i) {
    cin >> p[i];
    where[p[i]] = i;
  }
  long long inv = 0;
  for (int i = 1; i <= n; ++i) {
    long long l = sum(0, where[i]);
    long long r = sum(where[i], n - 1);
    inv += r;
    add(where[i]);
    ins(where[i], where[i]);
    int med = find_med(1, (i - 1) / 2 + 1);
    pref = 0;
    l = sum(0, med) - 1;
    r = sum(med, n - 1) - 1;
    long long cost = -pos_q(0, med) + pos_q(med, n - 1) +
                     (long long)med * (l - r) - r * (r + 1LL) / 2LL -
                     l * (l + 1LL) / 2LL;
    cout << inv + cost << ' ';
  }
}
