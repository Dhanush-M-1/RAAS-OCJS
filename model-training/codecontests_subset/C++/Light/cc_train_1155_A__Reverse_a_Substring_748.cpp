#include <bits/stdc++.h>
using namespace std;
int n;
string str;
int main() {
  cin >> n;
  cin >> str;
  for (int i = 0; i < n - 1; i++) {
    if (str[i] > str[i + 1]) {
      cout << "YES" << endl;
      cout << i + 1 << ' ' << i + 2 << endl;
      return 0;
    }
  }
  cout << "NO" << endl;
  return 0;
}
