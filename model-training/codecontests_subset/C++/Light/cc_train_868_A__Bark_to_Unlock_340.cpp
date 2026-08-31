#include <bits/stdc++.h>
using namespace std;
const int maxn = 110;
int n, k;
string t, s[maxn];
bool ans, a, b;
int main() {
  string t;
  cin >> t >> n;
  for (int i = 0; i < n; i++) {
    cin >> s[i];
    if (s[i] == t) {
      ans = 1;
    }
    if (s[i][0] == t[1]) {
      a = 1;
    }
    if (s[i][1] == t[0]) {
      b = 1;
    }
    ans |= a && b;
  }
  if (ans) {
    cout << "YES\n";
  } else {
    cout << "NO\n";
  }
}
