#include <bits/stdc++.h>
using namespace std;
const double EPS = 1e-9;
const long long INF = 1e17;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(nullptr);
  cout.tie(nullptr);
  string a, b;
  cin >> a >> b;
  int n;
  cin >> n;
  cout << a << " " << b << "\n";
  for (int i = 0; i < n; i++) {
    string aa, bb;
    cin >> aa >> bb;
    if (aa == a) {
      a = bb;
    } else {
      b = bb;
    }
    cout << a << " " << b << "\n";
  }
  return 0;
}
