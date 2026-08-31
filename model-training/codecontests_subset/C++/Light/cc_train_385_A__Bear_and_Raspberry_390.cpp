#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:100000000000,100000000000")
const long long INF = 2009000999;
const float cp = 2 * acos(0.0);
const float eps = 1e-18;
const long long mod = 1000007;
using namespace std;
int main() {
  long long n, c, mx = 0;
  vector<long long> d;
  cin >> n >> c;
  d.resize(n);
  for (int(i) = 0; (i) < (n); i++) cin >> d[i];
  for (int(i) = 0; (i) < (n - 1); i++) {
    long long k = d[i];
    k -= d[i + 1] + c;
    mx = max(mx, k);
  }
  cout << mx;
}
