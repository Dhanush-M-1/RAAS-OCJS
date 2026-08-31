#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, te, h = 0, t;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> te;
    if (te == 100) {
      h++;
    }
  }
  t = n - h;
  if (t % 2 == 0) {
    if (h % 2 == 0) {
      cout << "YES\n";
    } else {
      cout << "NO\n";
    }
  } else {
    h = h - 2;
    if (h < 0) {
      cout << "NO\n";
    } else if (h % 2 == 0) {
      cout << "YES\n";
    } else {
      cout << "NO\n";
    }
  }
  return 0;
}
