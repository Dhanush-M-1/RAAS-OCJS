#include <bits/stdc++.h>
using namespace std;
int pat[100][6];
int pat2[5000][6];
int T;
signed long long N;
int val[7];
bool dfs(signed long long V, int d) {
  int i;
  if (d >= 7) return false;
  if (V == 0) {
    while (d < 7) val[d++] = 0;
    return true;
  }
  for (i = 0; i < 5; i++) {
    int v = V % 1000 + i * 1000;
    if (pat2[v][0] == -1 || V < v) continue;
    val[d] = v;
    if (dfs((V - v) / 1000, d + 1)) return true;
    val[d] = -1;
  }
  return false;
}
void solve() {
  int i, j, k, l, r, x, y;
  string s;
  memset(pat, 0xff, sizeof(pat));
  memset(pat2, 0xff, sizeof(pat2));
  for (j = 0; j < 7; j++)
    for (k = 0; k < 7; k++)
      if (j + k <= 6)
        for (l = 0; l < 6; l++) {
          if (l < k)
            pat[j * 4 + k * 7][l] = 7;
          else if (l < k + j)
            pat[j * 4 + k * 7][l] = 4;
          else
            pat[j * 4 + k * 7][l] = 0;
        }
  for (i = 0; i < 50; i++)
    for (j = 0; j < 50; j++)
      for (k = 0; k < 50; k++)
        if (pat[i][0] >= 0 && pat[j][0] >= 0 && pat[k][0] >= 0) {
          if (pat2[i * 100 + j * 10 + k][0] >= 0) continue;
          for (l = 0; l < 6; l++)
            pat2[i * 100 + j * 10 + k][l] =
                pat[i][l] * 100 + pat[j][l] * 10 + pat[k][l];
        }
  cin >> T;
  while (T--) {
    cin >> N;
    memset(val, 0xff, sizeof(val));
    if (!dfs(N, 0))
      (void)printf("-1\n");
    else {
      for (l = 0; l < 6; l++) {
        signed long long v = pat2[val[6]][l] * 1000000000000000000LL;
        v += pat2[val[5]][l] * 1000000000000000LL;
        v += pat2[val[4]][l] * 1000000000000LL;
        v += pat2[val[3]][l] * 1000000000LL;
        v += pat2[val[2]][l] * 1000000LL;
        v += pat2[val[1]][l] * 1000LL;
        v += pat2[val[0]][l];
        (void)printf("%lld ", v);
      }
      (void)printf("\n");
    }
  }
}
int main(int argc, char** argv) {
  string s;
  int i;
  if (argc == 1) ios::sync_with_stdio(false);
  for (i = 0; i < argc - 1; i++) s += argv[i + 1], s += '\n';
  for (i = 0; i < s.size(); i++) ungetc(s[s.size() - 1 - i], stdin);
  solve();
  return 0;
}
