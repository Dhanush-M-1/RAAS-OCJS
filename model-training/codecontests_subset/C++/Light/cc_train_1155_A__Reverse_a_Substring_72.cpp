#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  string str;
  cin >> n >> str;
  char ch = str[0];
  for (int i = 1; i < n; i++) {
    if (str[i] < ch) {
      cout << "YES" << endl;
      for (int j = 0; j < n; j++) {
        if (str[i] < str[j]) {
          cout << j + 1 << " " << i + 1 << endl;
          exit(0);
        }
      }
    }
    ch = max(ch, str[i]);
  }
  cout << "NO" << endl;
  return 0;
}
