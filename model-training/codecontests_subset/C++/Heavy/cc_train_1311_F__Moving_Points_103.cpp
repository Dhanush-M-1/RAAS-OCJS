#include <bits/stdc++.h>
using namespace std;
vector<pair<long long, long long>> t;
pair<long long, long long> get(long long v, long long l, long long r,
                               long long a, long long b) {
  if (l > b || a > r) {
    return {0, 0};
  }
  if (a <= l && r <= b) {
    return t[v];
  }
  long long m = (l + r) / 2;
  pair<long long, long long> tmp = get(2 * v, l, m, a, b),
                             tmp2 = get(2 * v + 1, m + 1, r, a, b);
  return {tmp.first + tmp2.first, tmp.second + tmp2.second};
}
void update(long long v, long long l, long long r, long long i, long long x) {
  if (l > i || i > r) {
    return;
  }
  if (l == r) {
    t[v] = {t[v].first + x, t[v].second + 1};
    return;
  }
  long long m = (l + r) / 2;
  update(2 * v, l, m, i, x);
  update(2 * v + 1, m + 1, r, i, x);
  t[v].first = t[2 * v].first + t[2 * v + 1].first;
  t[v].second = t[2 * v].second + t[2 * v + 1].second;
}
signed main() {
  long long n;
  cin >> n;
  long long q = 1 << (long long)ceil(log2(n));
  t.resize(2 * q);
  vector<pair<long long, long long>> x(n);
  for (long long i = 0; i < n; ++i) {
    cin >> x[i].first;
  }
  for (long long i = 0; i < n; ++i) {
    cin >> x[i].second;
  }
  sort(x.begin(), x.end());
  vector<long long> a(n);
  for (long long i = 0; i < n; ++i) {
    a[i] = x[i].second;
  }
  unordered_map<long long, long long> b;
  sort(a.begin(), a.end());
  a.resize(unique(a.begin(), a.end()) - a.begin());
  for (long long i = 0; i < a.size(); ++i) {
    b[a[i]] = i;
  }
  vector<long long> c(n);
  for (long long i = 0; i < n; ++i) {
    c[i] = b[x[i].second];
  }
  long long now = 0;
  long long sum = 0, kol = 0;
  for (long long i = 0; i < n; ++i) {
    if (x[i].second < 0) {
      sum += x[i].first;
      ++kol;
      continue;
    }
    if (x[i].second > 0) {
      pair<long long, long long> tmp = get(1, 0, q - 1, 0, c[i]);
      now += tmp.second * x[i].first - tmp.first;
      update(1, 0, q - 1, c[i], x[i].first);
    } else {
      now += kol * x[i].first - sum;
      sum += x[i].first;
      ++kol;
    }
  }
  t.assign(2 * q, {0, 0});
  sum = 0;
  kol = 0;
  for (long long i = n - 1; i >= 0; --i) {
    if (x[i].second > 0) {
      sum += x[i].first;
      ++kol;
      continue;
    }
    if (x[i].second < 0) {
      pair<long long, long long> tmp = get(1, 0, q - 1, c[i], n - 1);
      now += tmp.first - tmp.second * x[i].first;
      update(1, 0, q - 1, c[i], x[i].first);
    } else {
      now += sum - kol * x[i].first;
    }
  }
  long long nowl = 0, koll = 0, nowr = 0, kolr = 0;
  for (long long i = 0; i < n; ++i) {
    if (x[i].second > 0) {
      now += koll * x[i].first - nowl;
      ++kolr;
      nowr += x[i].first;
    } else if (x[i].second < 0) {
      ++koll;
      nowl += x[i].first;
    }
  }
  cout << now;
  return 0;
}
