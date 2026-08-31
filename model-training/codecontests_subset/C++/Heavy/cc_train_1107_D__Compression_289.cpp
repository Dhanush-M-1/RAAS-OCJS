#include <bits/stdc++.h>
using namespace std;
const int N = 5201;
bitset<N> a[N];
int n;
int s[N][N];
void p() {
  for (int i = 0; i < n; i++)
    for (int j = 0; j < n; j++) cout << (a[i][j] ? 1 : 0) << " \n"[j == n - 1];
}
void load(int ix) {
  string s;
  cin >> s;
  for (int i = 0; i < (n / 4); i++) {
    int x = isdigit(s[i]) ? (s[i] - '0') : (s[i] - 'A' + 10);
    for (int j = 3; j >= 0; j--, x >>= 1)
      a[ix][4 * i + j] = (x & 1) ? true : false;
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  for (int i = 0; i < n; i++) load(i);
  for (int i = 0; i < n; i++)
    for (int j = 0; j < n; j++)
      s[i + 1][j + 1] = s[i + 1][j] + s[i][j + 1] - s[i][j] + (a[i][j] ? 1 : 0);
  int x;
  for (x = n; x > 1; x--) {
    if (n % x != 0) continue;
    bool isOk = true;
    for (int i = 0; i + x <= n && isOk; i += x)
      for (int j = 0; j + x <= n && isOk; j += x) {
        int z = s[i + x][j + x] - s[i + x][j] - s[i][j + x] + s[i][j];
        isOk = (z == x * x || z == 0);
      }
    if (isOk) break;
  }
  cout << x << '\n';
  return 0;
}
