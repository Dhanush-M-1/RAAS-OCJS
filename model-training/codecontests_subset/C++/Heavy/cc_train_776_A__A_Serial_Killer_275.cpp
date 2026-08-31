#include <bits/stdc++.h>
using namespace std;
string s[1000000];
int main() {
  string s1, s2, s3, s4;
  cin >> s1 >> s2;
  int n;
  cin >> n;
  cout << s1 << " " << s2 << endl;
  while (n--) {
    cin >> s3 >> s4;
    if (s3 == s1) {
      cout << s4 << " " << s2 << endl;
      s1 = s4;
      s2 = s2;
      continue;
    } else if (s3 == s2) {
      cout << s1 << " " << s4 << endl;
      s1 = s1;
      s2 = s4;
      continue;
    } else if (s4 == s1) {
      cout << s3 << " " << s2 << endl;
      s1 = s3;
      s2 = s2;
      continue;
    } else if (s4 == s2) {
      cout << s1 << " " << s3 << endl;
      s1 = s1;
      s2 = s3;
      continue;
    }
  }
  return 0;
}
