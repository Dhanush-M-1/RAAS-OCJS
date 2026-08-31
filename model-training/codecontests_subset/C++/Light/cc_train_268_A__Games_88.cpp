#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int a[101] = {0}, b[101];
  int ans = 0;
  for (int i = 0; i < n; i++) {
    int x, y;
    cin >> x >> y;
    b[i] = x;
    a[y]++;
  }
  for (int i = 0; i < n; i++) ans += a[b[i]];
  cout << ans;
}
