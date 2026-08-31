#include <bits/stdc++.h>
using namespace std;
const long long INF = 2 * 1e9 + 100;
const long long M = 1e2 + 100;
const long long N = 1e6 + 100;
long long a[N];
vector<long long> v1, v2;
int main() {
  long long n;
  cin >> n;
  for (long long i = 0; i < n; i++) cin >> a[i];
  sort(a, a + n);
  long long t1 = 0, t2 = 0;
  for (long long i = 0; i < n; i++) {
    if (a[i] <= 500000)
      v1.push_back(a[i]);
    else
      v2.push_back(a[i]);
  }
  sort(v1.rbegin(), v1.rend());
  sort(v2.begin(), v2.end());
  t1 = (v1.empty() ? -INF : v1[0] - 1),
  t2 = (v2.empty() ? -INF : 1000000 - v2[0]);
  cout << max(t1, t2);
  return 0;
}
