#include <bits/stdc++.h>
using namespace std;
const int MX = 1e5 + 1;
double a[MX];
long long p[MX], k[MX];
int main() {
  long long n, in;
  cin >> n;
  for (int i = 1; i <= n; i++) cin >> a[i];
  for (int i = 1; i <= n; i++) cin >> in, a[i] -= in;
  for (int i = 2; i <= n; i++) cin >> p[i] >> k[i];
  for (int i = n; i >= 2; i--)
    a[i] < 0 ? a[p[i]] += a[i] * k[i] : a[p[i]] += a[i];
  cout << (a[1] < 0 ? "NO" : "YES");
}
