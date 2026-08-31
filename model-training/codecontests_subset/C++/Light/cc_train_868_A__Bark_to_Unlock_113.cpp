#include <bits/stdc++.h>
using namespace std;
int main() {
  string pw;
  cin >> pw;
  int n;
  cin >> n;
  vector<string> v(n);
  for (long p = 0; p < n; p++) {
    cin >> v[p];
  }
  bool found(false);
  for (long a = 0; a < n; a++) {
    if (found) {
      break;
    }
    for (long b = 0; b < n; b++) {
      string s = v[a] + v[b];
      if (s.find(pw) != std::string::npos) {
        found = true;
        break;
      }
    }
  }
  cout << (found ? "YES" : "NO") << endl;
  return 0;
}
