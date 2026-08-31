#include <bits/stdc++.h>
using namespace std;
const int S = 6;
const int P = 28;
map<int, pair<int, int> > od;
vector<int> get_poss() {
  set<int> poss;
  for (int i = 0; i <= S; i++)
    for (int j = 0; i + j <= S; j++) {
      poss.insert(i * 7 + j * 4);
      od[i * 7 + j * 4] = make_pair(i, j);
    }
  return vector<int>(poss.begin(), poss.end());
}
vector<int> comb = get_poss();
const int K = 21;
const int D = 10;
int tab[6][K];
void solve(long long s) {
  vector<int> poss[K][D];
  int cyfry[K];
  int z = 0;
  while (s) {
    int r = s % 10;
    cyfry[z] = r;
    s /= 10;
    if (z) {
      for (typeof((comb).begin()) it = ((comb).begin()); it != (comb).end();
           ++it) {
        for (int i = 0; i < (10); ++i) {
          if (!poss[z][i].empty())
            if ((i + *it % 10) % 10 == r) {
              poss[z + 1][(*it + i) / 10].push_back(*it);
            }
        }
      }
    } else {
      for (typeof((comb).begin()) it = ((comb).begin()); it != (comb).end();
           ++it)
        if (*it % 10 == r) {
          poss[1][*it / 10].push_back(*it);
        }
    }
    z++;
  }
  if (!poss[z][0].empty()) {
    int cyf = 0;
    for (int i = 0; i < (6); ++i)
      for (int j = 0; j < (K); ++j) tab[i][j] = 0;
    while (z - 1 >= 0) {
      int w = poss[z][cyf][0];
      pair<int, int> c = od[w];
      for (int i = 0; i < (c.first); ++i) tab[i][z - 1] = 7;
      for (int i = 0; i < (c.second); ++i) tab[i + c.first][z - 1] = 4;
      cyf = (10 + cyfry[z - 1] - w % 10) % 10;
      z--;
    }
    long long ans[6];
    for (int i = 0; i < (6); ++i) {
      long long pot = 1;
      ans[i] = 0LL;
      for (int j = 0; j < (K); ++j) {
        ans[i] += tab[i][j] * pot;
        pot *= 10;
      }
      cout << ans[i] << " ";
    }
    cout << endl;
    return;
  }
  cout << -1 << endl;
}
int main() {
  ios::sync_with_stdio(0);
  get_poss();
  long long a;
  int t;
  cin >> t;
  for (int i = 0; i < (t); ++i) {
    cin >> a;
    solve(a);
  }
  return 0;
}
