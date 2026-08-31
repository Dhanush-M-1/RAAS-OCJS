#include <bits/stdc++.h>
using namespace std;
const int MOD = 1e9 + 7;
const int INF = 2e9 + 7;
const long long INFL = 8e18L + 7;
const double INFD = 1e300;
void run();
int main() {
  if (strlen("") > 0) {
    freopen(
        ""
        ".in",
        "r", stdin);
    freopen(
        ""
        ".out",
        "w", stdout);
  }
  run();
  return 0;
}
const int N = 1e6 + 7;
int n, k;
bool a[N];
int b[N];
int num[2];
void run() {
  a[0] = 1;
  for (int i = 1;;) {
    string s;
    cin >> s;
    if (s == "=") {
      k = i;
      break;
    } else if (s != "?") {
      a[i] = s == "+";
      ++i;
    }
  }
  cin >> n;
  int p = accumulate(a, a + k, 0);
  int m = k - p;
  int summin = 1 * p - n * m;
  int summax = n * p - 1 * m;
  bool ok = summin <= n && n <= summax;
  printf("%s\n", ok ? "Possible" : "Impossible");
  if (ok) {
    for (int i = 0; i < k; ++i) b[i] = a[i] ? 1 : -n;
    int sum = accumulate(b, b + k, 0);
    for (int i = 0; i < k; ++i)
      if (sum + n - 1 <= n) {
        b[i] = a[i] ? n : 1;
        sum += n - 1;
      } else {
        b[i] += n - sum;
        break;
      }
    printf("%d", b[0]);
    for (int i = 1; i < k; ++i) printf(" %c %d", a[i] ? '+' : '-', abs(b[i]));
    printf(" = %d\n", n);
  }
}
