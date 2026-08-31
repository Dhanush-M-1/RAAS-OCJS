#include <bits/stdc++.h>
using namespace std;
const int maxn = 100010;
const long long q[] = {1, 2, 4};
int main() {
  long long n, a, b, c;
  while (cin >> n >> a >> b >> c) {
    n *= 2;
    long long ans = 0;
    for (int i = 0; i <= a; i++) {
      for (int j = 0; j <= b; j++) {
        long long sum = q[0] * i + q[1] * j;
        if ((n - sum) >= 0 && (n - sum) / 4 <= c && (n - sum) % 4 == 0)
          ans += 1;
      }
    }
    cout << ans << endl;
  }
}
