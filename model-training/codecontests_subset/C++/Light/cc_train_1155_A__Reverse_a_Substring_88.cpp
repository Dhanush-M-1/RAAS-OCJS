#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  int n;
  cin >> n;
  string s;
  cin >> s;
  for (int i = 0; i < n - 1; ++i) {
    if (s[i] > s[i + 1]) {
      cout << "YES\n" << i + 1 << " " << i + 2;
      return 0;
    }
  }
  cout << "NO";
  return 0;
}
