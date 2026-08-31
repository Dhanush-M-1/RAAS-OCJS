#include <bits/stdc++.h>
using namespace std;
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
const long long maxn = 3e6;
const long long mod = 1e9 + 7;
const long double PI = acos((long double)-1);
long long pw(long long a, long long b, long long md = mod) {
  long long res = 1;
  while (b) {
    if (b & 1) {
      res = (a * res) % md;
    }
    a = (a * a) % md;
    b >>= 1;
  }
  return (res);
}
int n, q;
int a[maxn];
int srt[maxn];
bool comp(int i, int j) { return (a[i] < a[j]); }
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> q;
  while (q--) {
    cin >> n;
    for (int i = 1; i <= n; i++) {
      cin >> a[i];
      srt[i] = i;
    }
    sort(srt + 1, srt + 1 + n, comp);
    int x = a[srt[1]], y = a[srt[2]], z = a[srt[n]];
    if (z < x + y) {
      cout << -1 << '\n';
      continue;
    } else {
      int b[] = {srt[1], srt[2], srt[n]};
      sort(b, b + 3);
      cout << b[0] << ' ' << b[1] << ' ' << b[2] << '\n';
    }
  }
  return (0);
}
