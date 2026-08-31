#include <bits/stdc++.h>
using namespace std;
string a;
int main() {
  int n;
  cin >> n;
  cin >> a;
  int flg = 0;
  int p, q;
  for (int i = 1; i < n; i++) {
    if (a[i] >= a[i - 1]) {
      continue;
    } else {
      flg = 1;
      p = i + 1;
      q = i;
      break;
    }
  }
  if (flg) {
    cout << "YES\n";
    cout << q << " " << p << endl;
  } else {
    cout << "NO\n";
  }
  return 0;
}
