#include <bits/stdc++.h>
using namespace std;
const int mx = 3e6 + 10;
int a[mx], b[mx];
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n, t;
  cin >> n;
  string s;
  cin >> s;
  int i, f = 0;
  for (i = 0; i < n - 1; i++) {
    if (s[i] > s[i + 1]) {
      f = 1;
      t = i;
      break;
    }
  }
  if (f == 0) {
    cout << "NO";
    return 0;
  }
  cout << "YES\n";
  if (t == 0)
    cout << 1 << " " << 2;
  else
    cout << t + 1 << " " << t + 2;
  return 0;
}
