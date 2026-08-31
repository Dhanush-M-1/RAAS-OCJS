#include <bits/stdc++.h>
using namespace std;
const double PI = acos(-1.0);
string letter = "URDL";
vector<pair<int, int>> mv = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
int id(char c) { return letter.find(c); }
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.precision(17);
  int n, k = 0;
  cin >> n;
  vector<int> a(n);
  for (int i = 0; i < (n); i++) {
    cin >> a[i];
    k = max(a[i], k);
  }
  while (1) {
    int c = 0;
    for (int i = 0; i < (n); i++) {
      c += k - 2 * a[i];
    }
    if (c > 0) {
      break;
    }
    k++;
  }
  cout << k << endl;
  ;
  return 0;
}
