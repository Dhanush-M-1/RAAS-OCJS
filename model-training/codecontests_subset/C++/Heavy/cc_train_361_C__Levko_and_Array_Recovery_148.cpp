#include <bits/stdc++.h>
using namespace std;
ifstream fin("in.in");
ofstream fout("out.out");
const int N = 5000 + 10, inf = 1000000000;
int n, m, a[N], d[N][N];
vector<pair<pair<int, int>, pair<int, int> > > mx;
bool check(int l, int r, int x, int t) {
  for (int i = l; i <= r; i++)
    if (a[i] >= x - d[t][i]) return true;
  return false;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin >> n >> m;
  for (int i = 1; i <= n; i++) a[i] = inf;
  for (int T = 1; T <= m; T++) {
    int t, l, r, x;
    cin >> t >> l >> r >> x;
    for (int i = 1; i <= n; i++) d[T][i] = d[T - 1][i];
    if (t == 1) {
      for (int i = l; i <= r; i++) d[T][i] += x;
      continue;
    }
    if (!check(l, r, x, T)) {
      cout << "NO";
      return 0;
    }
    for (int i = l; i <= r; i++) a[i] = min(a[i], x - d[T][i]);
    mx.push_back(make_pair(make_pair(l, r), make_pair(x, T)));
  }
  for (int i = 0; i < mx.size(); i++)
    if (!check(mx[i].first.first, mx[i].first.second, mx[i].second.first,
               mx[i].second.second)) {
      cout << "NO";
      return 0;
    }
  cout << "YES" << endl;
  for (int i = 1; i <= n; i++) cout << a[i] << ' ';
  return 0;
}
