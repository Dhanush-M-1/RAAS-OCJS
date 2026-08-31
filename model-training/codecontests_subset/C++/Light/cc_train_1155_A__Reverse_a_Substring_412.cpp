#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  string str;
  cin >> n >> str;
  for (int i = 1; i < n; ++i) {
    if (str[i - 1] > str[i]) {
      cout << "YES\n" << i << ' ' << i + 1;
      return 0;
    }
  }
  cout << "NO\n";
  return 0;
}
