#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  string s;
  cin >> s;
  int count = 0;
  for (int i = 0; i < s.size(); i++) {
    if (s[i] == '8') {
      count++;
    }
  }
  if (n == 11 && count >= 1) {
    cout << 1 << "\n";
  } else {
    int a = n / 11;
    if (count >= a) {
      cout << a << "\n";
    } else {
      cout << count << "\n";
    }
  }
  return 0;
}
