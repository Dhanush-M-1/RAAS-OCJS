#include <bits/stdc++.h>
using namespace std;
inline int nxt() {
  int x;
  scanf("%d", &x);
  return x;
}
int main() {
  mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
  int n = nxt();
  vector<int> a(n);
  for (int i = 0; i < n; ++i) {
    a[i] = nxt();
  }
  int s = accumulate((a).begin(), (a).end(), 0);
  int k = *max_element((a).begin(), (a).end());
  int t = k * n;
  int need = 2 * s + 1;
  if (need > t) {
    k += (need - t + n - 1) / n;
  }
  printf("%d\n", k);
  return 0;
}
