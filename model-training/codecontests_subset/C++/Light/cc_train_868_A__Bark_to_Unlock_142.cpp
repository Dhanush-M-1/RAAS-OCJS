#include <bits/stdc++.h>
using namespace std;
int main(int argc, char const *argv[]) {
  string password;
  cin >> password;
  int n;
  cin >> n;
  vector<string> a(n, "");
  for (int i = 0; i < n; ++i) {
    cin >> a[i];
    if (a[i] == password) {
      cout << "YES\n";
      return 0;
    }
  }
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < n; ++j) {
      string s = a[i] + a[j];
      if (s.find(password) < 4) {
        cout << "YES\n";
        return 0;
      }
    }
  }
  cout << "NO\n";
  return 0;
}
