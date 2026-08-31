#include <bits/stdc++.h>
using namespace std;
const int MAX = 55;
const int MAXB = 4000;
const int INF = (1 << 27);
int n, rows, columns, DP, BP, CP;
int m[MAX][MAX], label[MAX][MAX], border[MAXB][5], cor[MAXB];
int dl[] = {1, -1, 0, 0};
int dc[] = {0, 0, 1, -1};
char aux[MAX];
string s;
int ok(int i, int j) {
  if (i < 0 || j < 0 || i >= rows || j >= columns) return 0;
  if (m[i][j] == 0) return 0;
  return 1;
}
void ret(int i, int j, int id, int color) {
  label[i][j] = id;
  cor[id] = color;
  border[id][2] = min(border[id][2], j - 1);
  border[id][0] = max(border[id][0], j + 1);
  border[id][3] = min(border[id][3], i - 1);
  border[id][1] = max(border[id][1], i + 1);
  for (int k = 0; k < 4; k++) {
    int u = i + dl[k], v = j + dc[k];
    if (ok(u, v) && m[u][v] == color && label[u][v] == -1) ret(u, v, id, color);
  }
}
void limpa() {
  for (int i = 0; i < MAX; i++) {
    for (int j = 0; j < MAX; j++) {
      label[i][j] = -1;
    }
  }
  for (int i = 0; i < MAXB; i++) {
    border[i][2] = border[i][3] = INF;
    border[i][0] = border[i][1] = -INF;
  }
  BP = 1;
  DP = 0;
  CP = 3;
}
int main() {
  scanf(" %d %d ", &rows, &n);
  for (int i = 0; i < rows; i++) {
    scanf(" %s", aux);
    s = aux;
    columns = (int)s.size();
    for (int j = 0; j < columns; j++) m[i][j] = (int)(s[j] - '0');
  }
  limpa();
  int cnt = 1;
  for (int i = 0; i < rows; i++) {
    for (int j = 0; j < columns; j++) {
      if (m[i][j] > 0 && label[i][j] == -1) {
        ret(i, j, cnt, m[i][j]);
        cnt++;
      }
    }
  }
  int nl, nc;
  for (int i = 0; i < n; i++) {
    if (DP == 2 || DP == 0) {
      nc = border[BP][DP];
      if (CP == 3)
        nl = border[BP][3] + 1;
      else
        nl = border[BP][1] - 1;
    } else {
      nl = border[BP][DP];
      if (CP == 2)
        nc = border[BP][2] + 1;
      else
        nc = border[BP][0] - 1;
    }
    if (ok(nl, nc))
      BP = label[nl][nc];
    else {
      if ((CP + 1) % 4 == DP)
        CP = (CP + 2) % 4;
      else {
        DP++;
        DP %= 4;
        CP = (DP + 3) % 4;
      }
    }
  }
  printf("%d\n", cor[BP]);
  return 0;
}
