#include <bits/stdc++.h>
using namespace std;
ifstream fin("AAtest.in.txt");
long long n, jad[10][200005], k, x, y, ma1, ma2, ma3, vas;
vector<long long> v[4];
bool boo(long long es, long long vi) { return es > vi; }
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cerr.tie(0);
  cin >> n;
  for (int j = 0; j <= n; j++)
    for (int i = 0; i < 10; i++) jad[i][j] = -1e18;
  jad[0][0] = 0;
  for (int o = 1; o <= n; o++) {
    cin >> k;
    for (int i = 1; i <= 3; i++) v[i].resize(0);
    for (int i = 0; i < k; i++) {
      cin >> x >> y;
      v[x].push_back(y);
    }
    for (int i = 1; i <= 3; i++)
      if (v[i].size()) sort(v[i].begin(), v[i].end(), boo);
    ma1 = 0;
    ma2 = 0;
    ma3 = 0;
    for (int j = 1; j <= 3; j++)
      if (v[j].size()) ma1 = max(ma1, v[j][0]);
    if (v[2].size() && v[1].size()) {
      ma2 = max(v[2][0], v[1][0]);
      if (v[2][0] == ma2)
        ma3 = v[1][0];
      else {
        if (v[1].size() > 1)
          ma3 = max(v[2][0], v[1][1]);
        else
          ma3 = v[2][0];
      }
    } else if (v[1].size() > 1) {
      ma2 = v[1][0];
      ma3 = v[1][1];
    }
    for (int i = 0; i < 10; i++) {
      jad[i][o] = max(jad[i][o], jad[i][o - 1]);
      if (i == 9)
        jad[0][o] = max(jad[0][o], jad[i][o - 1] + ma1 * 2);
      else
        jad[i + 1][o] = max(jad[i + 1][o], jad[i][o - 1] + ma1);
      if (ma3)
        if (i >= 8)
          jad[(i + 2) % 10][o] =
              max(jad[(i + 2) % 10][o], jad[i][o - 1] + ma2 * 2 + ma3);
        else
          jad[i + 2][o] = max(jad[i + 2][o], jad[i][o - 1] + ma2 + ma3);
      if (v[1].size() > 2)
        if (i >= 7)
          jad[(i + 3) % 10][o] =
              max(jad[(i + 3) % 10][o],
                  jad[i][o - 1] + v[1][0] * 2 + v[1][1] + v[1][2]);
        else
          jad[i + 3][o] =
              max(jad[i + 3][o], jad[i][o - 1] + v[1][0] + v[1][1] + v[1][2]);
    }
  }
  for (int i = 0; i < 10; i++) vas = max(vas, jad[i][n]);
  cout << vas;
}
