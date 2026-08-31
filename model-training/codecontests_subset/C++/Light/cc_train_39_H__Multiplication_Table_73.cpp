#include <bits/stdc++.h>
using namespace std;
string ans;
int n;
string zjz(int a) {
  if (a == 0) {
    return "";
  } else {
    return zjz(a / n) + char(a % n + '0');
  }
}
int main() {
  int t;
  cin >> n;
  for (int i = 1; i < n; i++) {
    for (int j = 1; j < n; j++) {
      t = i * j;
      ans = zjz(t);
      cout << ans;
      if (ans.size() == 1) {
        cout << "   ";
      } else {
        cout << "  ";
      }
    }
    cout << endl;
  }
}
