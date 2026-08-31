#include <bits/stdc++.h>
using namespace std;
signed main() {
  long long n;
  cin >> n;
  string str;
  cin >> str;
  for (long long i = 1; i < n; i++) {
    if (str[i] < str[i - 1]) {
      cout << "YES\n";
      cout << i << " " << i + 1 << "\n";
      return 0;
    }
  }
  cout << "NO\n";
}
