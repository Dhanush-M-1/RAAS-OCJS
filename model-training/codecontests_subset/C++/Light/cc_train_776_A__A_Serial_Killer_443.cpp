#include <bits/stdc++.h>
using namespace std;
int main() {
  string s1, s2, s3, s4;
  int n, i;
  cin >> s1 >> s2;
  cout << s1 << " " << s2 << endl;
  cin >> n;
  for (i = 1; i <= n; i++) {
    cin >> s3 >> s4;
    if (s3 == s1) {
      s1 = s4;
    } else if (s3 == s2) {
      s2 = s4;
    }
    cout << s1 << " " << s2 << endl;
  }
}
