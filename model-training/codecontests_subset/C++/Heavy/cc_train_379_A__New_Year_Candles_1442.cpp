#include <bits/stdc++.h>
using namespace std;
struct team {
  int ans;
  bool ok;
};
long long n, cnt = 0, m, q;
string p, s;
inline bool check(long long& n) {
  long long t = (long long)sqrt((long double)n);
  if (t * t != n) return false;
  n = t;
  if (n == 2)
    return true;
  else if (n < 2 || n % 2 == 0)
    return false;
  t = (long long)sqrt((long double)n);
  for (long long i = 3; i <= t; i += 2)
    if (n % i == 0) return false;
  return true;
}
inline void doing() {
  cin >> m >> n;
  cnt += m;
  while (m >= n) {
    cnt += m / n;
    m = m % n + m / n;
  }
  cout << cnt;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  doing();
}
