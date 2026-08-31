#include <bits/stdc++.h>
using namespace std;
const int M = INT32_MAX;
const int NMAX = 10007;
int main() {
  cin.tie(0);
  cin.sync_with_stdio(0);
  cout.precision(30);
  string z[2];
  cin >> z[0] >> z[1];
  int n;
  cin >> n;
  cout << z[1] << ' ' << z[0] << endl;
  for (int i = 0; i < n; i++) {
    string k, next;
    cin >> k >> next;
    if (k == z[1])
      z[1] = next;
    else
      z[0] = next;
    cout << z[1] << ' ' << z[0] << endl;
  }
  return 0;
};
