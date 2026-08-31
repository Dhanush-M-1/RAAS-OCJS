#include <bits/stdc++.h>
using namespace std;
struct node {
  int x;
  int y;
} a[100050];
int main() {
  int n;
  int ans = 0;
  cin >> n;
  for (int i = 1; i <= n; i++) cin >> a[i].x >> a[i].y;
  a[0].x = -2100000000;
  a[n + 1].x = 2100000000;
  for (int i = 1; i <= n; i++) {
    if (a[i].x - a[i].y > a[i - 1].x) {
      ans++;
      continue;
    }
    if (a[i].x + a[i].y < a[i + 1].x) {
      a[i].x += a[i].y;
      ans++;
    }
  }
  cout << ans << endl;
}
