#include <bits/stdc++.h>
using namespace std;
int i, j, k;
int main() {
  int n;
  cin >> n;
  pair<int, int> a[n], seg[n];
  for (i = 0; i < n; ++i) cin >> a[i].first >> a[i].second;
  int z = 2;
  seg[0] = make_pair(a[0].first - a[0].second, a[0].first);
  seg[n - 1] = make_pair(a[n - 1].first, a[n - 1].second + a[n - 1].first);
  for (i = 1; i < n - 1; ++i) {
    int l = a[i].first - a[i].second, r = a[i].second + a[i].first;
    if (l > seg[i - 1].second)
      seg[i] = make_pair(l, a[i].first), ++z;
    else if (r < a[i + 1].first)
      seg[i] = make_pair(a[i].second, r), ++z;
    else
      seg[i] = make_pair(a[i].first, a[i].first);
  }
  if (n == 1) z = 1;
  cout << z << endl;
}
