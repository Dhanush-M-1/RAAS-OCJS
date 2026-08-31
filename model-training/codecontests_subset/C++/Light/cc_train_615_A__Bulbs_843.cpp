#include <bits/stdc++.h>
using namespace std;
void fast_io() {
  cin.tie(0);
  ios::sync_with_stdio(false);
}
int main() {
  long long n, m;
  scanf("%lld", &n);
  scanf("%lld", &m);
  set<long long> s;
  for (long long i = 0; i <= n - 1; i++) {
    long long sz;
    scanf("%lld", &sz);
    for (long long i = 1; i <= sz; i++) {
      long long a;
      scanf("%lld", &a);
      s.insert(a);
    }
  }
  if (s.size() == m)
    cout << "YES";
  else
    cout << "NO";
  return 0;
}
