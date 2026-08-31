#include <bits/stdc++.h>
using namespace std;
vector<string> split(const string& s, char c) {
  vector<string> v;
  stringstream ss(s);
  string x;
  while (getline(ss, x, c)) v.emplace_back(x);
  return move(v);
}
void err(vector<string>::iterator it) {}
template <typename T, typename... Args>
void err(vector<string>::iterator it, T a, Args... args) {
  cerr << it->substr((*it)[0] == ' ', it->length()) << " = " << a << '\n';
  err(++it, args...);
}
const int NMAX = 405;
bitset<NMAX> bt[NMAX][NMAX][26], ans;
int n, m, r, c;
string a[NMAX], b[NMAX];
void Prep() {
  for (int i = 0; i < n; i++)
    for (int s = 0; s < m; s++)
      for (int j = 0; j < m; j++) bt[i][s][a[i][j] - 'a'].set((j - s + m) % m);
}
void Go(int poz) {
  ans.set();
  for (int i = 0; i < r; i++) {
    int row = (poz + i) % n;
    for (int j = 0; j < c; j++)
      if (b[i][j] != '?') ans &= bt[row][j % m][b[i][j] - 'a'];
  }
}
int main() {
  cin.sync_with_stdio(false);
  int i, j;
  cin >> n >> m;
  for (i = 0; i < n; i++) cin >> a[i];
  cin >> r >> c;
  for (i = 0; i < r; i++) cin >> b[i];
  Prep();
  for (i = 0; i < n; i++) {
    Go(i);
    for (j = 0; j < m; j++) cout << ans[j];
    cout << "\n";
  }
  return 0;
}
