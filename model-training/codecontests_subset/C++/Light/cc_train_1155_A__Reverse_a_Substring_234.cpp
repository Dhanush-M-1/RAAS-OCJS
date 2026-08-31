#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n, m, i, x = 0, c = 0;
  string s;
  cin >> n >> s;
  for (i = 0; i < s.size() - 1; i++) {
    if (s[i] > s[i + 1]) {
      cout << "YES" << endl << i + 1 << " " << i + 2 << endl;
      return 0;
    }
  }
  cout << "NO" << endl;
  return 0;
}
