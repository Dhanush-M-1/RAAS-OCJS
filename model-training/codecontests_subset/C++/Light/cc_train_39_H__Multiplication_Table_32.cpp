#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  for (int i = 1; i < n; i++) {
    for (int j = 1; j < n; j++) {
      int res = i * j;
      string str;
      while (res != 0) {
        str += (res % n + '0');
        res /= n;
      }
      for (int i = str.size() - 1; i >= 0; i--) cout << str[i];
      cout << " ";
    }
    cout << endl;
  }
  return 0;
}
