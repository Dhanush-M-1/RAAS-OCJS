#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int n;
  cin >> n;
  vector<int> a(n);
  for (int i = 0; i < n; ++i) {
    cin >> a[i];
  }
  sort((a).begin(), (a).end());
  vector<int> b(n - 1);
  for (int i = 0; i < n - 1; ++i) {
    cin >> b[i];
  }
  sort((b).begin(), (b).end());
  bool f = 0;
  for (int i = 0; i < n - 1; ++i) {
    if (b[i] != a[i]) {
      cout << a[i] << endl;
      f = 1;
      break;
    }
  }
  if (!f) {
    cout << a[n - 1] << endl;
  }
  f = 0;
  vector<int> c(n - 2);
  for (int i = 0; i < n - 2; ++i) {
    cin >> c[i];
  }
  sort((c).begin(), (c).end());
  for (int i = 0; i < n - 2; ++i) {
    if (c[i] != b[i]) {
      cout << b[i] << endl;
      f = 1;
      break;
    }
  }
  if (!f) cout << b[n - 2] << endl;
  return 0;
}
