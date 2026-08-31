#include <bits/stdc++.h>
using namespace std;
int main() {
  string s1, s2;
  cin >> s1 >> s2;
  int n, i, k;
  cin >> n;
  cout << s1 << " " << s2 << endl;
  for (i = 0; i < n; i++) {
    string s3, s4;
    cin >> s3 >> s4;
    if (s3 == s1) k = 1;
    if (s3 == s2) k = 2;
    if (k == 1) cout << s4 << " " << s2 << endl;
    if (k == 2) cout << s1 << " " << s4 << endl;
    if (k == 1) s1 = s4;
    if (k == 2) s2 = s4;
  }
}
