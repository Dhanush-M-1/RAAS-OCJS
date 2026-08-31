#include <bits/stdc++.h>
using namespace std;
long n, k, a[1000001], d[1000001], vt[1000001];
vector<long> g[1000001];
void nhap() {
  cin >> n >> k;
  for (int i = 1; i <= n; ++i) cin >> a[i];
  for (int i = 1; i <= k; ++i) {
    long x, y;
    cin >> x >> y;
    g[y].push_back(x);
  }
}
void sol() {
  long kq = 0, sl = 0;
  for (int i = n; i >= 1; --i) {
    if (vt[a[i]] == sl - kq && i != n)
      ++kq;
    else
      for (int j = 0; j < g[a[i]].size(); ++j) vt[g[a[i]][j]]++;
    ++sl;
  }
  cout << kq;
}
int main(int argc, const char* argv[]) {
  nhap();
  sol();
  return 0;
}
