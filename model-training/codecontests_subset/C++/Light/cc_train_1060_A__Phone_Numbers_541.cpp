#include <bits/stdc++.h>
using namespace std;
template <class T>
T gcd(T a, T b) {
  return b ? gcd(b, a % b) : a;
}
const double EPS = 1e-9;
const double PI = acos(-1.);
const int INF = 1e9;
const long long MOD = 1e9 + 7;
const int MAXN = 1e5 + 5;
char s[MAXN];
void solve() {
  int n;
  scanf("%d%s", &n, &s[0]);
  int cnt8 = 0;
  for (int i = (0); i < (int)(n); i++) {
    if (s[i] == '8') {
      cnt8++;
    }
  }
  int ans = min(cnt8, n / 11);
  printf("%d\n", ans);
}
int main() {
  int t = 1;
  while (t--) {
    solve();
  }
}
