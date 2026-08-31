#include <bits/stdc++.h>
using namespace std;
struct state {
  int i, j, dp, cp;
  state() {}
  state(int _i, int _j, int _dp, int _cp) : i(_i), j(_j), dp(_dp), cp(_cp) {}
};
state go[50][50][4][2];
pair<int, int> dirs[] = {make_pair(0, 1), make_pair(1, 0), make_pair(0, -1),
                         make_pair(-1, 0)};
int main(void) {
  int m, n;
  cin >> m >> n;
  vector<string> s(m);
  for (int i = 0; i < m; i++) cin >> s[i];
  for (int i = 0; i < m; i++) {
    for (int j = 0; j < s[i].size(); j++) {
      for (int k = 0; k < 4; k++) {
        pair<int, int> cpos(i, j);
        pair<int, int> pcpos(cpos);
        while (cpos.first >= 0 && cpos.first < m && cpos.second >= 0 &&
               cpos.second < s[cpos.first].size() &&
               s[i][j] == s[cpos.first][cpos.second]) {
          pcpos = cpos;
          cpos.first += dirs[k].first;
          cpos.second += dirs[k].second;
        }
        for (int l = 0; l < 2; l++) {
          int dir2 = (4 + k + (l ? -1 : 1)) % 4;
          pair<int, int> dpos(pcpos);
          pair<int, int> pdpos(dpos);
          while (dpos.first >= 0 && dpos.first < m && dpos.second >= 0 &&
                 dpos.second < s[dpos.first].size() &&
                 s[i][j] == s[dpos.first][dpos.second]) {
            pdpos = dpos;
            dpos.first += dirs[dir2].first;
            dpos.second += dirs[dir2].second;
          }
          dpos = make_pair(pdpos.first + dirs[k].first,
                           pdpos.second + dirs[k].second);
          if (dpos.first >= 0 && dpos.first < m && dpos.second >= 0 &&
              dpos.second < s[dpos.first].size() &&
              s[dpos.first][dpos.second] != '0') {
            go[i][j][k][l] = state(dpos.first, dpos.second, k, l);
          } else {
            if (l) {
              go[i][j][k][l] = state(i, j, k, !l);
            } else {
              go[i][j][k][l] = state(i, j, (k + 1) % 4, !l);
            }
          }
        }
      }
    }
  }
  state st(0, 0, 0, 1);
  for (int step = 0; step < n; step++) {
    st = go[st.i][st.j][st.dp][st.cp];
  }
  cout << s[st.i][st.j];
}
