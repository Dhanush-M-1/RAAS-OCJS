#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n;
  cin >> n;
  string s;
  cin >> s;
  int pos = 0;
  for (long long i = 0; i < n - 1; i++) {
    if (s[i] > s[i + 1]) {
      cout << "YES" << endl;
      cout << i + 1 << " " << i + 2;
      pos = 1;
      break;
    }
  }
  if (pos == 0) cout << "NO";
  return 0;
}
