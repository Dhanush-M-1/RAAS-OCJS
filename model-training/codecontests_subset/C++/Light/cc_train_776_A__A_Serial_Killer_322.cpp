#include <bits/stdc++.h>
const int INF = 10e9 + 7;
using namespace std;
int main() {
  string s1 = "", s2 = "", s3 = "", s4 = "", s;
  cin >> s1 >> s2;
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cout << s1 << " " << s2 << endl;
    cin >> s3 >> s4;
    if (s3 == s1) {
      s1 = s4;
      continue;
    }
    if (s3 == s2) {
      s2 = s4;
      continue;
    }
    if (s4 == s1) {
      s1 = s3;
      continue;
    }
    if (s4 == s2) {
      s2 = s3;
      continue;
    }
  }
  cout << s1 << " " << s2 << endl;
}
