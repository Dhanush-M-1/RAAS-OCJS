#include <bits/stdc++.h>
using namespace std;
const int N = 810;
struct aa {
  int x, y;
  char c;
};
aa g[N * N];
int n, m, a, b, n1[N * 2], n2[N * 2], tot[26], tot2[26], num[N][26],
    num2[N][26];
int num3[N][26], num4[N][26], nn[N];
char s[N][N], s2[N][N], s3[N][N], ans[N][N];
bitset<810> bs[N][26], bs2[N][26], se[N][26], se2[N][26];
int pan(int x, int y) {
  for (int k = 0; k < 26; k++)
    if (tot2[k]) {
      for (int i = 0; i < a; i++) {
        if (num2[i][k] == nn[i] && num4[i + x][k] == m + b) continue;
        if (num2[i][k])
          if (((bs2[x + i][k] >> y) & se2[i][k]) != se2[i][k]) return 0;
      }
    }
  return 1;
}
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 0; i < n; i++) scanf("%s", s[i]);
  scanf("%d%d", &a, &b);
  for (int i = 0; i < a; i++) scanf("%s", s2[i]);
  memset(ans, 1, sizeof(ans));
  for (int i = 0; i < a; i++)
    for (int j = 0; j < b; j++)
      if (s2[i][j] != '?') {
        se[j][s2[i][j] - 'a'][i] = 1;
        num[j][s2[i][j] - 'a']++;
        se2[i][s2[i][j] - 'a'][j] = 1;
        num2[i][s2[i][j] - 'a']++;
        tot2[s2[i][j] - 'a']++;
        nn[i]++;
      }
  for (int i = n + a - 1; i >= 0; i--)
    for (int j = m + b - 1; j >= 0; j--) {
      s3[i][j] = s[i % n][j % m];
      bs[j][s3[i][j] - 'a'][i] = 1;
      bs2[i][s3[i][j] - 'a'][j] = 1;
      tot[s3[i][j] - 'a']++;
      num3[j][s3[i][j] - 'a']++;
      num4[i][s3[i][j] - 'a']++;
    }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) ans[i][j] = pan(i, j);
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) printf("%d", ans[i][j]);
    printf("\n");
  }
  fclose(stdin);
  fclose(stdout);
  return 0;
}
