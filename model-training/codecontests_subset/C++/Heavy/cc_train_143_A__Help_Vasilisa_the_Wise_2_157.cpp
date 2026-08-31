#include <bits/stdc++.h>
using namespace std;
inline double MTD(const double minutes) { return minutes / 60; }
inline double rad(const double deg) {
  return (deg * (long double)acos(-1.0) / 180.0);
}
inline double deg(double rad) {
  if (rad < 0) rad += 2 * (long double)acos(-1.0);
  return (rad * 180) / (long double)acos(-1.0);
}
FILE *fptr = fopen("output.txt", "r");
int a[3][3];
map<int, int> m;
bool check(int x, int b, int c, int d) {
  m.clear();
  if (x + b != a[0][0]) return false;
  if (x + c != a[1][0]) return false;
  if (x + d != a[2][0]) return false;
  if (b + d != a[1][1]) return false;
  if (b + c != a[2][1]) return false;
  if (c + d != a[0][1]) return false;
  m[x]++;
  m[b]++;
  m[c++];
  m[d++];
  if (m.size() != 4) return false;
  return true;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  for (int i = 0; i < 3; i++)
    for (int j = 0; j < 2; j++) cin >> a[i][j];
  for (int i = 1; i <= 9; i++)
    for (int j = 1; j <= 9; j++)
      for (int k = 1; k <= 9; k++)
        for (int l = 1; l <= 9; l++)
          if (check(i, j, k, l)) {
            cout << i << ' ' << j << endl << k << ' ' << l;
            return 0;
          }
  cout << -1;
  return 0;
}
