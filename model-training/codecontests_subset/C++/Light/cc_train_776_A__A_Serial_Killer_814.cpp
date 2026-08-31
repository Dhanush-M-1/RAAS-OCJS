#include <bits/stdc++.h>
using namespace std;
map<string, int> mp;
string a, b;
int main() {
  while (cin >> a >> b) {
    int n;
    cin >> n;
    string n1 = a;
    string n2 = b;
    cout << a << " " << b << endl;
    for (int i = 0; i < n; i++) {
      string x, y;
      cin >> x >> y;
      if (x == n1) {
        cout << y << " " << n2 << endl;
        n1 = y;
      } else if (x == n2) {
        cout << n1 << " " << y << endl;
        n2 = y;
      }
    }
  }
  return 0;
}
