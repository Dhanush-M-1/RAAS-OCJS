#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  cerr.tie(nullptr);
  int n;
  cin >> n;
  string s;
  cin >> s;
  int a = 0, b = 0;
  for (auto& i : s) {
    if (i == '8')
      ++a;
    else
      ++b;
  }
  int sol = 0;
  while (a) {
    if (b >= 10) {
      b -= 10;
      --a;
      ++sol;
    } else {
      if (b + a - 1 >= 10) {
        a -= (11 - b);
        b = 0;
        ++sol;
      } else {
        break;
      }
    }
  }
  cout << sol << '\n';
}
