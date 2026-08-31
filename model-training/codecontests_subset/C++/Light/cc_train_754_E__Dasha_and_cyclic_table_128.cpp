#include <bits/stdc++.h>
const long long INF = 4e18L + 1;
const int IINF = 1e9 + 1;
const int limit = 1048576;
using namespace std;
template <class TH>
void _dbg(const char* sdbg, TH h) {
  cerr << sdbg << '=' << h << endl;
}
template <class TH, class... TA>
void _dbg(const char* sdbg, TH h, TA... a) {
  while (*sdbg != ',') cerr << *sdbg++;
  cerr << '=' << h << ',';
  _dbg(sdbg + 1, a...);
}
const int M = 26;
const int N = 403;
bitset<N> G[M][N];
char P[N][N];
bitset<N> R[N];
bitset<N> shift(bitset<N>& row, int l, int k) {
  bitset<N> rez = (row >> k);
  rez |= (row << (l - k));
  (rez);
  return rez;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int n, m;
  cin >> n >> m;
  vector<string> input(n);
  for (auto& row : input) {
    cin >> row;
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      G[input[i][j] - 'a'][i][j] = 1;
    }
  }
  int r, c;
  cin >> r >> c;
  for (int x = 0; x < r; x++) {
    cin >> P[x];
  }
  for (int i = 0; i < n; i++) {
    R[i] = ~R[i];
  }
  for (int x = 0; x < r; x++) {
    for (int y = 0; y < c; y++) {
      if (P[x][y] == '?') {
        continue;
      }
      for (int i = 0; i < n; i++) {
        int ii = (i + x) % n;
        (x, y, i, ii, P[x][y]);
        R[i] &= shift(G[P[x][y] - 'a'][ii], m, y % m);
      }
    }
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      cout << (R[i][j] ? '1' : '0');
    }
    cout << "\n";
  }
}
