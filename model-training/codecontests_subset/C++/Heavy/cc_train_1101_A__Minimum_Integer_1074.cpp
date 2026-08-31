#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 5;
const int mod = 1e9 + 7;
struct edge {
  int from, to;
  double value;
  edge(int f, int t, double v) { from = f, to = t, value = v; }
};
int n, m;
vector<edge> s;
bool cmp(edge x, edge y) { return x.value < y.value; }
bool cmp1(int x, int y) { return x > y; }
long long ans = 0;
int main() {
  int T;
  cin >> T;
  while (T--) {
    int l, r, d;
    scanf("%d%d%d", &l, &r, &d);
    if (d < l) {
      ans = d;
    } else {
      long long k = ceil((double)r / (double)d);
      ans = (k)*d;
      if (ans == r) {
        ans += d;
      }
    }
    cout << ans << endl;
  }
  return 0;
}
