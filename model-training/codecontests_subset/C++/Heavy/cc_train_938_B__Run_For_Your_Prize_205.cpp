#include <bits/stdc++.h>
using namespace std;
bool cmpf(float a, float b, float epsilon) {
  return (fabs(a - b) <= epsilon * max(fabs(a), fabs(b)));
}
long long int fpow(long long int n, long long int k, long long int p) {
  long long int r = 1;
  for (; k; k >>= 1) {
    if (k & 1) r = r * n % p;
    n = n * n % p;
  }
  return r;
}
long long int inv(long long int a, long long int p) {
  return fpow(a, p - 2, p);
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long int t, n, m, k, d, di, ti, si, cnt, temp, i, j, l, r;
  cin >> n;
  std::vector<long long int> v1, v2;
  for (i = 0; i < n; i++) {
    cin >> m;
    if (m <= 500000)
      v1.push_back(m);
    else
      v2.push_back(1000001 - m);
  }
  ti = 0;
  di = 0;
  sort(v1.begin(), v1.end());
  sort(v2.begin(), v2.end());
  if (v1.size() != 0) ti = v1[v1.size() - 1];
  if (v2.size() != 0) di = v2[v2.size() - 1];
  cout << max(ti, di) - 1;
  return 0;
}
