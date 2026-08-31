#include <bits/stdc++.h>
using namespace std;
long long tc, n, a[100001], b[100001], cnt, last;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  for (int i = 0; i < n; ++i) {
    cin >> a[i] >> b[i];
  }
  last = a[0];
  cnt = 1;
  for (int i = 1; i < n - 1; ++i) {
    if (a[i] > (b[i] + last)) {
      cnt++;
      last = a[i];
    } else if ((i + 1) < n && (a[i] + b[i]) < a[i + 1]) {
      cnt++;
      last = a[i] + b[i];
    } else {
      last = a[i];
    }
  }
  if (n > 1) cnt++;
  cout << cnt;
}
