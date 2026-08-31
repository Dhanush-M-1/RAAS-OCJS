#include <bits/stdc++.h>
using namespace std;
int a[200001];
pair<int, int> aTmp[200001];
int b[200001];
int kthLargest(int n, int k) {
  vector<int> c(n);
  for (int i = 0; i < n; ++i) {
    c[i] = b[i];
  }
  sort(c.begin(), c.end());
  return c[k - 1];
}
int main() {
  std::ios::sync_with_stdio(false);
  cin.tie(0);
  int n;
  cin >> n;
  for (int i = 0; i < n; ++i) {
    cin >> a[i];
    aTmp[i].second = -i;
    aTmp[i].first = a[i];
  }
  sort(aTmp, aTmp + n, greater<pair<int, int>>());
  for (int i = 0; i < n; ++i) {
    b[i] = -aTmp[i].second;
  }
  int q;
  cin >> q;
  while (q--) {
    int k, p;
    cin >> k >> p;
    cout << a[kthLargest(k, p)] << endl;
  }
}
