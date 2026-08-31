#include <bits/stdc++.h>
using namespace std;
int main() {
  int a;
  cin >> a;
  string s;
  cin >> s;
  int x = 0;
  for (int i = 0; i < a - 1; i++) {
    if (s[i] > s[i + 1]) {
      cout << "YES" << endl;
      cout << i + 1 << " " << i + 2;
      return 0;
    }
  }
  cout << "NO";
}
