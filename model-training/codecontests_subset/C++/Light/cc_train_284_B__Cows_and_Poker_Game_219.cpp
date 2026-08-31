#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, ans = 0, cnt = 0;
  cin >> n;
  char a[n];
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  for (int i = 0; i < n; i++) {
    if (a[i] == 'A') {
      ans++;
    }
    if (a[i] == 'I') {
      cnt++;
    }
  }
  if (cnt == 0) {
    cout << ans;
  } else if (cnt == 1) {
    cout << 1;
  } else {
    cout << 0;
  }
  return 0;
}
