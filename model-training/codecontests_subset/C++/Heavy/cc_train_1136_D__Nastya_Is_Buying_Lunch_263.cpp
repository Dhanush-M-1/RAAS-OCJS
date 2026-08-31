#include <bits/stdc++.h>
using namespace std;
vector<long long> vec;
long long a[300001], p, ans = 0;
set<pair<long long, long long> > s;
int main() {
  long long n, m;
  scanf("%lld %lld", &n, &m);
  long long i, j, ans = 0;
  for (i = 1; i <= n; i++) scanf("%lld", &a[i]);
  p = a[n];
  for (i = 0; i < m; i++) {
    long long x, y;
    scanf("%lld %lld", &x, &y);
    s.insert(make_pair(x, y));
  }
  vec.push_back(a[n]);
  for (i = n - 1; i >= 1; i--) {
    long long now = a[i];
    int check = 1;
    for (j = 0; j < vec.size(); j++) {
      if (s.count(make_pair(now, vec[j])) == 0) {
        check = 0;
        break;
      }
    }
    if (check) {
      ans++;
    } else
      vec.push_back(now);
  }
  printf("%lld", ans);
}
