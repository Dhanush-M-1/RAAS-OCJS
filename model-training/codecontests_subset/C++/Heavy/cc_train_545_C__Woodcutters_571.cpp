#include <bits/stdc++.h>
using namespace std;
const double pi = acos(-1.0);
const long long INF = 2e18;
void print(int a[], int n) {
  for (int i = 0; i < n; i++) cout << a[i] << " ";
  cout << "\n";
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int tc = 1;
  while (tc--) {
    int n;
    cin >> n;
    int x[n], h[n];
    for (int i = 0; i < (n); i++) cin >> x[i] >> h[i];
    int ans = 0;
    if (n == 1)
      ans = 1;
    else
      ans = 2;
    int right = 0;
    for (int i = 1; i <= (n - 2); i++) {
      int tem = x[i] - h[i];
      if (!((tem <= x[i - 1]) or tem <= right)) {
        ans++;
        right = x[i];
      } else {
        tem = x[i] + h[i];
        if (tem < x[i + 1]) ans++, right = tem;
      }
    }
    cout << ans;
  }
}
