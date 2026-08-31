#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 7;
const long long INF = 1e9 + 7;
const long double EPS = 1e-9;
const long long P = 485437;
const int C = 2016;
long long a, b;
pair<long long, long long> t[N];
void add(int i, int l, int r, int d, int x) {
  if (d < l || d >= r) return;
  if (l == r - 1) {
    t[i].first = min(b, t[i].first + x);
    t[i].second = min(a, t[i].second + x);
    return;
  }
  int m = (l + r) / 2;
  add(i * 2 + 1, l, m, d, x);
  add(i * 2 + 2, m, r, d, x);
  t[i].first = t[i * 2 + 1].first + t[i * 2 + 2].first;
  t[i].second = t[i * 2 + 1].second + t[i * 2 + 2].second;
}
long long sum(int i, int l, int r, int a, int b, bool f) {
  if (b <= l || a >= r) return 0;
  if (a <= l && r <= b) return (f) ? t[i].second : t[i].first;
  int m = (l + r) / 2;
  return sum(i * 2 + 1, l, m, a, b, f) + sum(i * 2 + 2, m, r, a, b, f);
}
int main() {
  ios_base::sync_with_stdio(0);
  int n, k, d, q, typ, x;
  cin >> n >> k >> a >> b >> q;
  for (int i = 0; i < q; i++) {
    cin >> typ;
    if (typ == 1) {
      cin >> d >> x;
      add(0, 0, n, d - 1, x);
    } else {
      cin >> d;
      cout << sum(0, 0, n, 0, d - 1, 0) + sum(0, 0, n, d + k - 1, n, 1) << endl;
    }
  }
  return 0;
}
