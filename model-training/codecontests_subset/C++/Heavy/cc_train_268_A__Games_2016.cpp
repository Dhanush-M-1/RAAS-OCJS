#include <bits/stdc++.h>
const long long INF = 1e18 + 123;
const long double EPS = 1e-9;
const int inf = 1e9 + 123;
const int MOD = 1e9 + 7;
const int N = 1e5 + 123;
const int M = 1e6 + 123;
const double pi = 3.14159265359;
using namespace std;
long long x, y, t, l, r;
long long p, py, q, k;
long long n, m, cal, ans, res;
string s;
bool visited(N);
vector<int> c;
vector<int> w;
vector<vector<int>> g;
void solve() {
  cin >> n;
  vector<int> h(n), a(n);
  for (long long i = 0; i < n; i++) {
    cin >> h[i] >> a[i];
    for (long long j = 0; j < i; j++) {
      if (h[i] == a[j]) {
        ans++;
      }
      if (a[i] == h[j]) {
        ans++;
      }
    }
  }
  cout << ans;
}
int main() {
  solve();
  return 0;
}
