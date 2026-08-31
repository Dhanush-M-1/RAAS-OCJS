#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  int n, i;
  string str, cpy;
  cin >> n;
  cin >> str;
  cpy = str;
  reverse(cpy.begin(), cpy.end());
  sort(cpy.begin(), cpy.end());
  if (cpy == str) {
    cout << "NO";
    return 0;
  } else {
    for (i = 0; str[i]; i++) {
      if (str[i] > str[i + 1]) {
        cout << "YES\n";
        cout << i + 1 << ' ' << i + 2;
        return 0;
      }
    }
  }
}
