#include <bits/stdc++.h>
using namespace std;
vector<long long> s;
vector<pair<long long, long long>> tree;
void build(long long l, long long r, long long v) {
  if (r - 1 == l) {
    tree[v] = {s[l], l};
    return;
  }
  long long m = (r + l) / 2;
  build(l, m, v * 2 + 1);
  build(m, r, v * 2 + 2);
  auto a = tree[v * 2 + 1];
  auto b = tree[v * 2 + 2];
  if (a.first < b.first) {
    tree[v] = a;
  } else {
    tree[v] = b;
  }
}
vector<long long> mod;
pair<long long, long long> get(long long l, long long r, long long u,
                               long long w, long long v) {
  if (r <= u || l >= w) {
    return {1e9, 0};
  }
  if (r <= w && l >= u) {
    return tree[v];
  }
  long long m = (r + l) / 2;
  auto a = get(l, m, u, w, v * 2 + 1);
  auto b = get(m, r, u, w, v * 2 + 2);
  if (a.first < b.first) {
    return {a.first + mod[v], a.second};
  } else {
    return {b.first + mod[v], b.second};
  }
}
void update(long long l, long long r, long long u, long long w, long long v,
            long long delt) {
  if (r <= u || l >= w) {
    return;
  }
  if (r <= w && l >= u) {
    mod[v] += delt;
    auto a = tree[v];
    tree[v] = {a.first + delt, a.second};
    return;
  }
  long long m = (r + l) / 2;
  update(l, m, u, w, v * 2 + 1, delt);
  update(m, r, u, w, v * 2 + 2, delt);
  auto a = tree[v * 2 + 1];
  auto b = tree[v * 2 + 2];
  if (a.first < b.first) {
    tree[v] = {a.first + mod[v], a.second};
  } else {
    tree[v] = {b.first + mod[v], b.second};
  }
}
signed main() {
  long long n;
  cin >> n;
  s.resize(n);
  for (long long i = 0; i < n; i++) {
    cin >> s[i];
  }
  tree.resize(4 * n);
  mod.resize(4 * n);
  build(0, n, 0);
  vector<long long> v(n);
  long long sum = 0;
  for (long long i = 1; i <= n; i++) {
    auto a = get(0, n, 0, n, 0);
    v[a.second] = i;
    update(0, n, a.second, a.second + 1, 0, 1e18 + 1);
    update(0, n, a.second + 1, n, 0, -i);
  }
  for (long long i = 0; i < n; i++) {
    cout << v[i] << " ";
  }
  return 0;
}
