#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n;
  cin >> n;
  long long ans = 0;
  for (int i = 0; i < n; i++) {
    long long x;
    cin >> x;
    long long a = abs(x - 1), b = abs(1000000 - x);
    long long c = min(a, b);
    ans = max(c, ans);
  }
  cout << ans;
}
