#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, ans = 0;
  cin >> n;
  vector<pair<int, int>> a(n);
  for (int i = 0; i < n; i++) {
    int a1, b;
    cin >> a1 >> b;
    a[i].first = a1;
    a[i].second = b;
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if (a[i].first == a[j].second && i != j) {
        ans++;
      }
    }
  }
  cout << ans;
  return 0;
}
