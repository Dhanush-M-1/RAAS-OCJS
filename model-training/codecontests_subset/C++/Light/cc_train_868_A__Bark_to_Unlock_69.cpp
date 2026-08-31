#include <bits/stdc++.h>
using namespace std;
int main() {
  string ans, iptco;
  cin >> ans;
  int num;
  cin >> num;
  string *ptr = new string[num];
  for (int i = 0; i < num; i++) {
    cin >> ptr[i];
    if (ptr[i] == ans) {
      cout << "YES\n";
      delete[] ptr;
      return 0;
    }
  }
  for (int i = 0; i < num; i++) {
    for (int j = 0; j < num; j++) {
      iptco = ptr[i] + ptr[j];
      if (iptco[1] == ans[0] && iptco[2] == ans[1]) {
        cout << "YES\n";
        delete[] ptr;
        return 0;
      }
    }
  }
  delete[] ptr;
  cout << "No\n";
  return 0;
}
