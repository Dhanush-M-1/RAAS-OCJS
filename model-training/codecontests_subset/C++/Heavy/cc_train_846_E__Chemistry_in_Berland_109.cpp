#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 5;
long long b[N];
long long a[N];
int x[N];
long long k[N];
int main() {
  int n;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    scanf("%lld", b + i);
  }
  for (int i = 1; i <= n; i++) {
    scanf("%lld", a + i);
  }
  for (int i = 2; i <= n; i++) {
    scanf("%d %lld", x + i, k + i);
  }
  for (int i = n; i >= 2; i--) {
    if (b[i] > a[i]) {
      b[x[i]] += b[i] - a[i];
    } else if (b[i] < a[i]) {
      if ((a[i] - b[i]) > 1000000000000000000 / k[i]) {
        cout << "NO" << endl;
        return 0;
      }
      a[x[i]] += (a[i] - b[i]) * k[i];
      if (a[x[i]] >= 5e17) {
        cout << "NO" << endl;
        return 0;
      }
    }
  }
  if (b[1] >= a[1]) {
    cout << "YES" << endl;
  } else {
    cout << "NO" << endl;
    return 0;
  }
}
