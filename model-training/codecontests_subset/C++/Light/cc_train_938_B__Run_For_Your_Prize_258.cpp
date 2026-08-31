#include <bits/stdc++.h>
using namespace std;
const long long INF = 1e9 + 10, MAX = 1e6 + 1e4, MOD = 1e9 + 7, MAXL = 25;
void OUT(long double o, int x) {
  cout << fixed << setprecision(x) << o;
  return;
}
long long a[MAX];
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long n;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    long long x;
    cin >> x;
    a[x] = 1;
  }
  long long x = 0;
  for (int i = 1; i < 500000; i++) {
    if (a[1 + i] || a[1000000 - i]) x = i;
  }
  cout << x;
  return 0;
}
