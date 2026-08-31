#include <bits/stdc++.h>
using namespace std;
int main() {
  string a;
  cin >> a;
  int n;
  cin >> n;
  bool aa = 0, bb = 0;
  for (int i = 0; i < n; i++) {
    string s;
    cin >> s;
    if (s == a) {
      cout << "YES" << endl;
      return 0;
    }
    if (s[0] == a[1]) aa = 1;
    if (s[1] == a[0]) bb = 1;
  }
  if (aa && bb) {
    cout << "YES" << endl;
  } else
    cout << "NO" << endl;
}
