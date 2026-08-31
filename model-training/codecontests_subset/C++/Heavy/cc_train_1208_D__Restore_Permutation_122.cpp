#include <bits/stdc++.h>
using namespace std;
vector<long long> tree;
vector<long long> s;
vector<long long> p;
long long build(long long L, long long R, long long v) {
  if (R - L == 1) {
    return tree[v] = L + 1;
  } else {
    return tree[v] = build(L, (L + R) / 2, v * 2 + 1) +
                     build((L + R) / 2, R, v * 2 + 2);
  }
}
long long get(long long L, long long R, long long v, long long sum) {
  if (R - L == 1) {
    return L;
  }
  if (tree[v * 2 + 1] <= sum) {
    return get((L + R) / 2, R, v * 2 + 2, sum - tree[v * 2 + 1]);
  } else {
    return get(L, (L + R) / 2, v * 2 + 1, sum);
  }
}
long long sset(long long L, long long R, long long v, long long x) {
  if (R - L == 1) {
    return tree[v] = 0;
  }
  if (x < (L + R) / 2) {
    return tree[v] = sset(L, (L + R) / 2, v * 2 + 1, x) + tree[v * 2 + 2];
  } else {
    return tree[v] = sset((L + R) / 2, R, v * 2 + 2, x) + tree[v * 2 + 1];
  }
}
int32_t main() {
  long long N;
  cin >> N;
  tree.resize(N * 4);
  s.resize(N);
  p.resize(N);
  for (long long i = 0; i < N; i++) {
    cin >> s[i];
  }
  build(0, N, 0);
  for (long long i = N - 1; i >= 0; i--) {
    p[i] = get(0, N, 0, s[i]);
    sset(0, N, 0, p[i]);
    p[i]++;
  }
  for (auto i : p) {
    cout << i << " ";
  }
  cout << endl;
}
