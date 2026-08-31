#include <bits/stdc++.h>
using namespace std;
int main() {
  string a, b;
  cin >> a >> b;
  int n;
  cin >> n;
  string a1, b1;
  cout << a << " " << b << '\n';
  while (n--) {
    cin >> a1 >> b1;
    if (a == a1)
      swap(a, b1);
    else
      swap(b, b1);
    cout << a << " " << b << '\n';
  }
  return 0;
}
