#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f, MOD = 1e9 + 7;
long long _max[200100];
long long _min[200100];
int n;
void max_add(int i, long long x) {
  while (i <= n) {
    _max[i] += x;
    i += i & (-i);
  }
}
long long max_sum(int i) {
  long long sum = 0;
  while (i > 0) {
    sum += _max[i];
    i -= i & (-i);
  }
  return sum;
}
void min_add(int i, long long x) {
  while (i <= n) {
    _min[i] += x;
    i += i & (-i);
  }
}
long long min_sum(int i) {
  long long sum = 0;
  while (i > 0) {
    sum += _min[i];
    i -= i & (-i);
  }
  return sum;
}
int k, q;
long long a, b;
long long num[200100];
int main() {
  memset(_max, 0, sizeof(_max));
  memset(_min, 0, sizeof(_min));
  cin >> n >> k >> a >> b >> q;
  while (q--) {
    int cmd;
    cin >> cmd;
    if (cmd == 1) {
      int d;
      long long x;
      cin >> d >> x;
      if (num[d]) {
        max_add(d, -min(num[d], a));
        min_add(d, -min(num[d], b));
      }
      num[d] += x;
      max_add(d, min(num[d], a));
      min_add(d, min(num[d], b));
    } else {
      int p;
      cin >> p;
      long long ans = min_sum(p - 1);
      ans += max_sum(n) - max_sum(p + k - 1);
      cout << ans << endl;
    }
  }
  return 0;
}
