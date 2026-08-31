#include <bits/stdc++.h>
using namespace std;
const int N = 1e6;
const int lg = 20;
int n, R, c;
vector<string> li;
int par[N + 5][lg + 2];
void make_sparse() {
  for (int i = 1; i < lg; i++) {
    for (int j = 0; j <= n; j++) {
      par[j][i] = par[par[j][i - 1]][i - 1];
    }
  }
}
int get_uj(int x) {
  for (int i = 0; i < lg; i++) {
    if ((1 << i) & R) {
      x = par[x][i];
    }
  }
  return x;
}
int main() {
  cin >> n >> R >> c;
  for (int i = 0; i < n; i++) {
    string s;
    cin >> s;
    li.push_back(s);
  }
  c++;
  int r = -1;
  int cur = 0;
  for (int i = 0; i < n; i++) {
    while (cur <= c && r < n) {
      r++;
      if (r == n) break;
      cur += li[r].size() + 1;
    }
    par[i][0] = r;
    cur -= li[i].size() + 1;
  }
  par[n][0] = n;
  make_sparse();
  int ans = 0;
  for (int i = 0; i < n; i++) {
    ans = max(ans, get_uj(i) - i);
  }
  for (int i = 0; i < n; i++) {
    if (get_uj(i) - i == ans) {
      int lol = get_uj(i);
      bool spas = 0;
      int cur = 0;
      int bef = i;
      for (int j = i; j < lol; j++) {
        if (cur != 0) cout << " ";
        cout << li[j];
        cur += li[j].size() + 1;
        if (par[bef][0] - 1 == j) {
          cur = 0;
          cout << endl;
          bef = par[bef][0];
        }
      }
      break;
    }
  }
  return 0;
}
