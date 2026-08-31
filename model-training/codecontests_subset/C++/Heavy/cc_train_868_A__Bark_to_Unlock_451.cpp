#include <bits/stdc++.h>
using namespace std;
string p, s[101], r, r2;
int main() {
  int n;
  cin >> p >> n;
  for (int i = 0; i < n; i++) cin >> s[i];
  for (int i = 0; i <= n - 1; i++) {
    r = s[i], r2 = p;
    sort(r.begin(), r.end());
    sort(r2.begin(), r2.end());
    if (r == r2) return cout << "YES", 0;
    for (int j = i + 1; j < n; j++) {
      r = s[j];
      r2 = p;
      sort(r.begin(), r.end());
      sort(r2.begin(), r2.end());
      if (r == r2) return cout << "YES", 0;
      if (s[i][0] == p[1] && s[j][1] == p[0]) return cout << "YES", 0;
      if (s[i][1] == p[0] && s[j][0] == p[1]) return cout << "YES", 0;
    }
  }
  cout << "NO";
}
