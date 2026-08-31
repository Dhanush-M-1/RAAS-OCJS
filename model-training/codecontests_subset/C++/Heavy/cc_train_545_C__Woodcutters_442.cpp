#include <bits/stdc++.h>
using namespace std;
const int INF = 1e9;
const long double EPS = 1e-11;
template <class T>
T &chmin(T &a, const T &b) {
  return a = min(a, b);
}
template <class T>
T &chmax(T &a, const T &b) {
  return a = max(a, b);
}
const int64_t INFLL = 1e18;
int n;
const int MAX_N = 100010;
int64_t x[MAX_N], h[MAX_N];
int ans[2][2];
int main() {
  cin >> n;
  x[0] = -INFLL;
  h[0] = 0;
  for (int i = (1); i < (int)(n + 1); ++i) cin >> x[i] >> h[i];
  x[n + 1] = INFLL;
  h[n + 1] = 0;
  for (int i = (1); i < (int)(n + 1); ++i) {
    int64_t pl = x[i - 1];
    int64_t pr = x[i - 1] + h[i - 1];
    int64_t l = x[i] - h[i];
    int64_t r = x[i] + h[i];
    ans[i & 1][0] = ans[i & 1][1] =
        max(ans[(i + 1) & 1][0], ans[(i + 1) & 1][1]);
    if (pl < l) chmax(ans[i & 1][0], ans[(i + 1) & 1][0] + 1);
    if (pr < l) chmax(ans[i & 1][0], ans[(i + 1) & 1][1] + 1);
    if (r < x[i + 1]) ans[i & 1][1]++;
  }
  cout << max(ans[n & 1][0], ans[n & 1][1]) << endl;
  return 0;
}
