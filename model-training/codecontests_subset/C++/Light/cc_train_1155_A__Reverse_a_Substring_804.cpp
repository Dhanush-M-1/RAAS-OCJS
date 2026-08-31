#include <bits/stdc++.h>
using namespace std;
int main() {
  long long i, n, l, c = 0;
  cin >> n;
  string s;
  cin >> s;
  for (i = 0; i < n - 1; i++) {
    if (s[i] > s[i + 1]) {
      cout << "YES" << endl;
      cout << i + 1 << " " << i + 2 << endl;
      return 0;
    }
  }
  cout << "NO" << endl;
}
