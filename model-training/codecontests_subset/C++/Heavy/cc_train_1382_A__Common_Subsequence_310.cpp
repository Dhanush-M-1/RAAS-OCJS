#include <bits/stdc++.h>
using namespace std;
void fast() {
  ios_base::sync_with_stdio(NULL);
  cin.tie(0);
  cout.tie(0);
}
void online_judge() {
  freopen("input.txt", "r", stdin);
  freopen("output.txt", "w", stdout);
}
const int flag_max = 0x3f3f3f3f;
const long long OO = 1e9 + 9;
const double EPS = (1e-7);
int dcmp(double x, double y) { return fabs(x - y) <= EPS ? 0 : x < y ? -1 : 1; }
long long gcd(long long a, long long b) { return !b ? a : gcd(b, a % b); }
long long lcm(long long a, long long b) { return (a / gcd(a, b)) * b; }
int main() {
  fast();
  int testcase;
  cin >> testcase;
  while (testcase--) {
    int n, m;
    cin >> n >> m;
    int firstarr[n];
    int secondarr[m];
    for (int i = 0; i < n; i++) {
      cin >> firstarr[i];
    }
    for (int i = 0; i < m; i++) {
      cin >> secondarr[i];
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (firstarr[i] == secondarr[j]) {
          cout << "YES\n";
          cout << 1 << ' ' << firstarr[i] << '\n';
          goto nex;
        }
      }
    }
    cout << "NO\n";
  nex:
    continue;
  }
  return 0;
}
