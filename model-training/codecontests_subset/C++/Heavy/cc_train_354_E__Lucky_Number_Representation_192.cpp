#include <bits/stdc++.h>
using namespace std;
const int INF = 2e9;
const int MAXN = 1e5 + 5;
const long long MOD = 1e9 + 7;
long long x;
long long n1, n2;
bool little_lucky[11111];
long long lucky[] = {0,   4,   7,   40,  44,  47,  70,  74,  77,
                     400, 404, 407, 440, 444, 447, 470, 474, 477,
                     700, 704, 707, 740, 744, 747, 770, 774, 777};
vector<long long> dp_lucky[11111][7];
vector<long long> dp_g_lucky[11111][7];
vector<long long> g_lucky;
long long ans[6];
long long t_ans[6];
long long stk;
long long pot10 = 1;
long long tmp;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  ;
  int T;
  cin >> T;
  for (int(i) = (0); (i) < (11111); ++(i)) {
    bool ok = 1;
    int ret = i;
    for (int j = 0; j < 7; ++j) {
      int yo = ret % 10;
      ret /= 10;
      if (yo != 0 && yo != 4 && yo != 7) ok = 0;
    }
    if (ok) {
      g_lucky.push_back(i);
      dp_g_lucky[i][1].push_back(i);
    }
  }
  for (int(i) = (0); (i) < (27); ++(i))
    dp_lucky[lucky[i]][1].push_back(lucky[i]);
  for (int(i) = (0); (i) < (11111); ++(i)) {
    for (int(j) = (2); (j) < (7); ++(j)) {
      for (int(k) = (0); (k) < (27); ++(k)) {
        if (lucky[k] > i) break;
        if (!dp_lucky[i - lucky[k]][j - 1].empty()) {
          int len = int(dp_lucky[i - lucky[k]][j - 1].size());
          dp_lucky[i][j].push_back(lucky[k]);
          for (int(tt) = (0); (tt) < (len); ++(tt)) {
            dp_lucky[i][j].push_back(dp_lucky[i - lucky[k]][j - 1][tt]);
          }
          break;
        }
      }
    }
  }
  for (int(i) = (0); (i) < (11111); ++(i))
    if (!dp_lucky[i][6].empty()) little_lucky[i] = 1;
  for (int(i) = (0); (i) < (11111); ++(i)) {
    for (int(j) = (2); (j) < (7); ++(j)) {
      for (int(k) = (0); (k) < (g_lucky.size()); ++(k)) {
        if (g_lucky[k] > i) break;
        if (!dp_g_lucky[i - g_lucky[k]][j - 1].empty()) {
          int len = int(dp_g_lucky[i - g_lucky[k]][j - 1].size());
          dp_g_lucky[i][j].push_back(g_lucky[k]);
          for (int(tt) = (0); (tt) < (len); ++(tt)) {
            dp_g_lucky[i][j].push_back(dp_g_lucky[i - g_lucky[k]][j - 1][tt]);
          }
          break;
        }
      }
    }
  }
  for (int(u) = (0); (u) < (T); ++(u)) {
    cin >> x;
    if (x < 11111) {
      if (dp_g_lucky[x][6].empty())
        cout << "-1" << endl;
      else {
        for (int(i) = (0); (i) < (6); ++(i)) cout << dp_g_lucky[x][6][i] << " ";
        cout << endl;
      }
      continue;
    }
    n1 = x % 4000;
    if (!little_lucky[n1]) {
      n1 += 4000;
    }
    n2 = x - n1;
    for (int(i) = (0); (i) < (6); ++(i)) ans[i] = dp_lucky[n1][6][i];
    for (int(i) = (0); (i) < (6); ++(i)) t_ans[i] = 0LL;
    stk = n2 / 4000;
    pot10 = 1LL;
    for (int(j) = (0); (j) < (15); ++(j)) {
      tmp = stk % 10;
      stk /= 10;
      if (tmp <= 6) {
        for (int(i) = (0); (i) < (tmp); ++(i)) t_ans[i] += 4 * pot10;
      } else {
        for (int(i) = (0); (i) < (4); ++(i)) t_ans[i] += 7 * pot10;
        for (int(i) = (0); (i) < (tmp - 7); ++(i)) t_ans[i + 4] += 4 * pot10;
      }
      pot10 *= 10;
    }
    for (int(i) = (0); (i) < (6); ++(i)) ans[i] += 1000 * t_ans[i];
    for (int(i) = (0); (i) < (6); ++(i)) {
      cout << ans[i] << " ";
    }
    cout << endl;
  }
  return 0;
}
