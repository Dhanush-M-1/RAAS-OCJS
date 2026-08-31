#include <bits/stdc++.h>
using namespace std;
vector<pair<int, int> > v[12];
int dyn[20][10], wher[20][10], wher2[20][10], wher3[20][10], t;
long long cur, on[20];
int dig(int pos) { return (cur / on[pos - 1]) % 10; }
bool fun(int pos, int elde) {
  if (pos == 20 && elde == 0) return 1;
  if (pos == 20 && elde != 0) return 0;
  if (dyn[pos][elde] != -1) return dyn[pos][elde];
  int need = dig(pos);
  if (need >= elde) {
    for (int i = 0; i < (int)v[need - elde].size(); i++)
      if (fun(pos + 1, (v[need - elde][i].first * 4 +
                        v[need - elde][i].second * 7 + elde) /
                           10)) {
        dyn[pos][elde] = 1;
        wher[pos][elde] = pos + 1;
        wher2[pos][elde] = (v[need - elde][i].first * 4 +
                            v[need - elde][i].second * 7 + elde) /
                           10;
        wher3[pos][elde] = i;
        return 1;
      }
    dyn[pos][elde] = 0;
    return 0;
  } else {
    int rneed = (need + 10) - elde;
    for (int i = 0; i < (int)v[rneed].size(); i++)
      if (fun(pos + 1,
              (v[rneed][i].first * 4 + v[rneed][i].second * 7 + elde) / 10)) {
        dyn[pos][elde] = 1;
        wher[pos][elde] = pos + 1;
        wher2[pos][elde] =
            (v[rneed][i].first * 4 + v[rneed][i].second * 7 + elde) / 10;
        wher3[pos][elde] = i;
        return 1;
      }
    dyn[pos][elde] = 0;
    return 0;
  }
}
int main() {
  for (int i = 0; i <= 6; i++)
    for (int j = 0; j <= 6; j++)
      if (i + j <= 6) v[(i * 4 + j * 7) % 10].push_back(make_pair(i, j));
  on[0] = 1;
  for (int i = 1; i <= 20; i++) on[i] = on[i - 1] * 10;
  scanf("%d", &t);
  for (int i = 1; i <= t; i++) {
    memset(dyn, -1, sizeof(dyn));
    memset(wher, -1, sizeof(wher));
    memset(wher2, -1, sizeof(wher2));
    memset(wher3, -1, sizeof(wher3));
    cin >> cur;
    int lelel = fun(1, 0);
    if (lelel == 0) {
      printf("-1\n");
      continue;
    }
    int pos = 1, elde = 0;
    long long d[7] = {0, 0, 0, 0, 0, 0, 0};
    while (pos < 20) {
      int kek = wher[pos][elde], kek2 = wher2[pos][elde],
          kek3 = wher3[pos][elde];
      int need = dig(pos) - elde;
      if (need < 0) need += 10;
      for (int i = 1; i <= v[need][kek3].first; i++)
        d[i] += on[pos - 1] * 1ll * 4;
      for (int i = v[need][kek3].first + 1;
           i <= v[need][kek3].first + v[need][kek3].second; i++)
        d[i] += on[pos - 1] * 1ll * 7;
      pos = kek;
      elde = kek2;
    }
    for (int i = 1; i <= 6; i++) cout << d[i] << ' ';
    puts("");
  }
}
