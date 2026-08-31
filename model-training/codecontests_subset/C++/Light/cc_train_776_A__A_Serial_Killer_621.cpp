#include <bits/stdc++.h>
using namespace std;
const int inf = (int)1e9;
const int mod = inf + 7;
const double eps = 1e-9;
const double pi = acos(-1.0);
int n;
string a, b, second[10020], t[10020];
int main() {
  ios_base::sync_with_stdio(0), cin.tie(0);
  cin >> a >> b;
  cin >> n;
  for (int i = 0; i < n; ++i) {
    cin >> second[i] >> t[i];
  }
  for (int i = 0; i < n; ++i) {
    if (a == second[i]) {
      a = t[i];
      cout << second[i] << " " << b << endl;
    } else {
      if (a == t[i]) {
        a = second[i];
        cout << t[i] << " " << b << endl;
      } else {
        if (b == second[i]) {
          b = t[i];
          cout << a << " " << second[i] << endl;
        } else {
          b = second[i];
          cout << a << " " << t[i] << endl;
        }
      }
    }
  }
  cout << a << " " << b << endl;
}
