#include <bits/stdc++.h>
using namespace std;
int main() {
  string s1, s2;
  cin >> s1 >> s2;
  int n;
  cin >> n;
  cout << s1 << " " << s2 << endl;
  for (int i = 0; i < n; i++) {
    string a, b;
    cin >> a >> b;
    if (a == s1) {
      s1 = b;
    } else
      s2 = b;
    cout << s1 << " " << s2 << endl;
  }
}
