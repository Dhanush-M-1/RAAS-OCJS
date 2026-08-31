#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  string s1, s2, s3, s4;
  cin >> s1 >> s2;
  int n;
  cin >> n;
  while (n--) {
    cout << s1 << " " << s2 << "\n";
    cin >> s3 >> s4;
    if (s3 == s1) {
      s1 = s4;
    } else {
      s2 = s4;
    }
  }
  cout << s1 << " " << s2 << "\n";
}
