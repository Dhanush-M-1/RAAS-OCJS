#include <bits/stdc++.h>
using namespace std;
string a, b, c;
int main() {
  int n;
  cin >> a >> b;
  cout << a << " " << b << endl;
  cin >> n;
  while (n--) {
    cin >> c;
    if (c == a)
      cin >> a;
    else
      cin >> b;
    cout << a << " " << b << endl;
  }
  return 0;
}
