#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n;
  cin >> n;
  vector<int> a(n);
  int one = 0, two = 0;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    if (a[i] == 100) {
      one++;
    } else {
      two++;
    }
  }
  if (one % 2 == 0 && two % 2 == 0) {
    cout << "YES\n";
    return 0;
  }
  if (two % 2) {
    if (one % 2 == 0 && one > 0) {
      cout << "YES\n";
    } else {
      cout << "NO\n";
    }
  } else {
    if (one % 2 == 0 && one > 0) {
      cout << "YES\n";
    } else {
      cout << "NO\n";
    }
  }
}
