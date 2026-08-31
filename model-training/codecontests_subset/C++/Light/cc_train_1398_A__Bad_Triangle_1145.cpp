#include <bits/stdc++.h>
using namespace std;
using PII = pair<long long, long long>;
const int maxn = 1e5 + 5;
const long long mod = 1e9 + 7;
int a[maxn];
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0), cout.tie(0);
  int T = 1;
  cin >> T;
  while (T--) {
    int n;
    cin >> n;
    for (int i = 1; i <= n; i++) {
      cin >> a[i];
    }
    if (a[1] + a[2] > a[n])
      cout << -1 << '\n';
    else
      cout << "1 2 " << n << '\n';
  }
}
