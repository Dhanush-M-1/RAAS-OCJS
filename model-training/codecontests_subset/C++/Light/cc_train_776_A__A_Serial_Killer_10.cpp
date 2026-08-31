#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, j, k, l, m, n, p, x, y;
  string s1, s2, s3, s4;
  cin >> s1 >> s2;
  cin >> n;
  cout << s1 << " " << s2;
  cout << endl;
  for (i = 0; i < n; i++) {
    cin >> s3 >> s4;
    if (s3 == s1) {
      s1 = s4;
      cout << s1 << " " << s2;
    }
    if (s3 == s2) {
      s2 = s4;
      cout << s1 << " " << s2;
    }
    cout << endl;
  }
}
