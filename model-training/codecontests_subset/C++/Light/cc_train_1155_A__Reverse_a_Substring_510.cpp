#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  int n;
  cin >> n;
  cin >> s;
  string s1 = s;
  sort(s.begin(), s.end());
  if (s1 == s) {
    cout << "NO";
  } else {
    for (int i = 0; i < n; i++) {
      if (s[i] != s1[i]) {
        for (int j = i + 1; i < n; j++) {
          if (s1[i] > s1[j]) {
            cout << "YES" << endl;
            cout << i + 1 << " " << j + 1;
            return 0;
          }
        }
      }
    }
  }
  return 0;
}
