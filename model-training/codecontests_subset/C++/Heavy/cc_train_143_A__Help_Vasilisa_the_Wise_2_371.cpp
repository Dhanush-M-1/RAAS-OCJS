#include <bits/stdc++.h>
using namespace std;
const int OO = (int)1e8;
const double EPS = 1e-11;
int diri[] = {0, 1, -1, 0};
int dirj[] = {1, 0, 0, -1};
int arr[30];
map<char, string> m;
int main() {
  int a, b, c, d, e, f;
  cin >> a >> b >> c >> d >> e >> f;
  for (int i = 1; i < 10; ++i) {
    for (int j = 1; j < 10; ++j) {
      for (int k = 1; k < 10; ++k) {
        for (int l = 1; l < 10; ++l) {
          set<int> s;
          s.insert(i);
          s.insert(j);
          s.insert(k);
          s.insert(l);
          if ((int)s.size() != 4) continue;
          if (i + j == a && k + l == b && i + k == c && j + l == d &&
              i + l == e && j + k == f) {
            cout << i << " " << j << endl << k << " " << l << endl;
            goto out;
          }
        }
      }
    }
  }
  cout << -1;
out:;
  return 0;
}
