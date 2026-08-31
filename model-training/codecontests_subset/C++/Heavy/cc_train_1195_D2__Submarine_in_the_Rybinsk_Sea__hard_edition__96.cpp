#include <bits/stdc++.h>
using namespace std;
const int md = 998244353;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int n;
  cin >> n;
  vector<int> a(n);
  for (int i = 0; i < n; ++i) {
    cin >> a[i];
  }
  auto get_len = [&](int x) {
    int res = 0;
    while (x > 0) {
      res += 1;
      x /= 10;
    }
    return res;
  };
  vector<int> len(n);
  vector<int> cnt(11, 0);
  for (int i = 0; i < n; ++i) {
    len[i] = get_len(a[i]);
    cnt[len[i]] += 1;
  }
  vector<long long> p(21);
  p[0] = 1;
  for (int i = 1; i < 21; ++i) {
    p[i] = p[i - 1] * 10 % md;
  }
  long long ans = 0;
  auto geti = [&](int a, int b, int id) {
    if (a == b) {
      return id * 2 + 1;
    }
    if (a < b) {
      return id * 2 + 1;
    }
    if (a > b) {
      if (id >= b) {
        return b + id;
      }
      return id * 2 + 1;
    }
    return 1;
  };
  auto getj = [&](int a, int b, int id) {
    if (a == b) {
      return id * 2;
    }
    if (a < b) {
      return id * 2;
    }
    if (a > b) {
      if (id >= b) {
        return b + id;
      }
      return id * 2;
    }
    return 1;
  };
  for (int i = 0; i < n; ++i) {
    vector<int> b;
    for (int j = 0; j < len[i]; ++j) {
      b.push_back(a[i] % 10);
      a[i] /= 10;
    }
    for (int j = 0; j < len[i]; ++j) {
      for (int t = 1; t < 11; ++t) {
        ans = (ans + p[geti(len[i], t, j)] * b[j] * cnt[t] % md) % md;
        ans = (ans + p[getj(len[i], t, j)] * b[j] * cnt[t] % md) % md;
      }
    }
  }
  cout << ans << '\n';
  return 0;
}
