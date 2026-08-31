#include <bits/stdc++.h>
using namespace std;
int a[100006];
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int n;
  int maxx = 0, minn = 1000005;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    if (a[i] <= 500000 && a[i] >= maxx)
      maxx = a[i];
    else if (a[i] >= 500000 && a[i] <= minn)
      minn = a[i];
  }
  int t = max(maxx - 1, 1000000 - minn);
  cout << t << endl;
  return 0;
}
