#include <bits/stdc++.h>
using namespace std;
int main() {
  ifstream fin("input.txt", ios::in);
  ios_base::sync_with_stdio(false);
  cout.tie(0);
  cin.tie(0);
  cout << setprecision(10);
  cout << fixed;
  string a, b;
  cin >> a >> b;
  int n;
  cin >> n;
  cout << a << " " << b << endl;
  while (n--) {
    string x, y;
    cin >> x >> y;
    if (a == x) {
      a = y;
    } else {
      b = y;
    }
    cout << a << " " << b << endl;
  }
}
