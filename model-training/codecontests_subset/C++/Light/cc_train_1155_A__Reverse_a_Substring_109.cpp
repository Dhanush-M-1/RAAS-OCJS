#include <bits/stdc++.h>
using namespace std;
int a[300005];
int c[300005];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n, m, b, x = 0, y, z, i, p, q;
  cin >> n;
  int cc[2];
  char s[300005];
  cin >> s;
  for (i = 1; i < n; i++) {
    if (s[i] < s[i - 1]) {
      cout << "YES" << endl;
      cout << i << " " << i + 1 << endl;
      return 0;
    }
  }
  cout << "NO" << endl;
}
