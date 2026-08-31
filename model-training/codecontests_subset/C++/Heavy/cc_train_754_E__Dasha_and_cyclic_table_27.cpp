#include <bits/stdc++.h>
using namespace std;
const int N = 404, M = 27;
int n, m, r, c;
char s[N][N], t[N][N];
bitset<N> ok[N], have_char[M][N];
int f(char c) { return c - 'a'; }
bitset<N> cyclic_shift(bitset<N> b, int len) {
  return (b >> (len % m)) | (b << ((m - (len % m))));
}
void act(int x, int y, char c) {
  for (int i = 0; i < n; i++)
    ok[i] &= cyclic_shift(have_char[f(c)][(i + x) % n], y);
}
void print(bitset<N> b) {
  for (int i = 0; i < m; i++) cout << b[i];
}
int main() {
  ios::sync_with_stdio(false), cin.tie(0);
  cin >> n >> m;
  for (int i = 0; i < n; i++) {
    ok[i].set();
    for (int j = 0; j < m; j++)
      cin >> s[i][j], have_char[f(s[i][j])][i][j] = true;
  }
  cin >> r >> c;
  for (int i = 0; i < r; i++)
    for (int j = 0; j < c; j++) {
      cin >> t[i][j];
      if (t[i][j] != '?') act(i, j, t[i][j]);
    }
  for (int i = 0; i < n; i++, cout << '\n') print(ok[i]);
  return 0;
}
