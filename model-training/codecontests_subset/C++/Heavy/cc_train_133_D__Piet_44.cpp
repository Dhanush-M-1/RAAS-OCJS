#include <bits/stdc++.h>
using namespace std;
const int di[] = {0, 1, 0, -1};
const int dj[] = {1, 0, -1, 0};
char A[60][60];
int B[60][60];
bool was[60][60];
typedef struct {
  pair<int, int> UL;
  pair<int, int> UR;
  pair<int, int> DL;
  pair<int, int> DR;
} T1;
T1 V[2501];
typedef struct {
  int BP;
  int DP;
  int CP;
} T2;
inline void doMagic(int c, int i, int j) {
  if (i <= V[c].UL.first && j <= V[c].UL.second) V[c].UL = make_pair(i, j);
  if (i <= V[c].UR.first && j >= V[c].UR.second) V[c].UR = make_pair(i, j);
  if (i >= V[c].DL.first && j <= V[c].DL.second) V[c].DL = make_pair(i, j);
  if (i >= V[c].DR.first && j >= V[c].DR.second) V[c].DR = make_pair(i, j);
}
int main() {
  int m, n;
  cin >> m >> n;
  for (int i = 1; i <= m; i++) cin >> A[i] + 1;
  int l = strlen(A[1] + 1);
  for (int i0 = 1, c = 1; i0 <= m; i0++)
    for (int j0 = 1; j0 <= l; j0++)
      if (A[i0][j0] != '0' && !was[i0][j0]) {
        queue<pair<int, int> > Q;
        Q.push(make_pair(i0, j0));
        was[i0][j0] = true;
        B[i0][j0] = c;
        T1 tmp;
        tmp.UL = make_pair(i0, j0);
        tmp.UR = make_pair(i0, j0);
        tmp.DL = make_pair(i0, j0);
        tmp.DR = make_pair(i0, j0);
        V[c] = tmp;
        while (!Q.empty()) {
          int i = Q.front().first;
          int j = Q.front().second;
          doMagic(c, i, j);
          for (int k = 0; k < 4; k++) {
            int i1 = i + di[k];
            int j1 = j + dj[k];
            if (A[i1][j1] == A[i0][j0] && !was[i1][j1]) {
              Q.push(make_pair(i1, j1));
              was[i1][j1] = true;
              B[i1][j1] = c;
            }
          }
          Q.pop();
        }
        c++;
      }
  T2 P;
  P.BP = B[1][1];
  P.DP = 0;
  P.CP = 0;
  for (int k = 0; k < n; k++) {
    int i, j;
    if (P.DP == 3 && P.CP == 1 || P.DP == 0 && P.CP == 0) {
      i = V[P.BP].UR.first;
      j = V[P.BP].UR.second;
    }
    if (P.DP == 0 && P.CP == 1 || P.DP == 1 && P.CP == 0) {
      i = V[P.BP].DR.first;
      j = V[P.BP].DR.second;
    }
    if (P.DP == 1 && P.CP == 1 || P.DP == 2 && P.CP == 0) {
      i = V[P.BP].DL.first;
      j = V[P.BP].DL.second;
    }
    if (P.DP == 2 && P.CP == 1 || P.DP == 3 && P.CP == 0) {
      i = V[P.BP].UL.first;
      j = V[P.BP].UL.second;
    }
    i += di[P.DP];
    j += dj[P.DP];
    if (B[i][j] != 0) {
      P.BP = B[i][j];
      continue;
    }
    if (P.CP == 0) {
      P.CP = 1;
      continue;
    }
    P.DP = (P.DP + 1) % 4;
    P.CP = 0;
  }
  for (int i = 1; i <= m; i++)
    for (int j = 1; j <= l; j++)
      if (B[i][j] == P.BP) {
        cout << A[i][j];
        goto exit;
      }
exit:
  return (0);
}
