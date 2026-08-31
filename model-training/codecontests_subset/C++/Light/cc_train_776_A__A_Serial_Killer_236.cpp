#include <bits/stdc++.h>
using namespace std;
int main() {
  string s1, s2;
  cin >> s1 >> s2;
  cout << s1 << " " << s2 << "\n";
  int n;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    string s3, s4;
    cin >> s3 >> s4;
    if (s3 == s1) {
      s1 = s4;
      cout << s1 << " " << s2 << "\n";
    } else {
      s2 = s4;
      cout << s1 << " " << s2 << "\n";
    }
  }
}
