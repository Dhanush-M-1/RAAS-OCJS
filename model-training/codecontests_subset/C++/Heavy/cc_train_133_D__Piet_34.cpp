#include <bits/stdc++.h>
using namespace std;
const long double EPS = 1E-9;
const int INF = (int)1E9;
const long long INF64 = (long long)1E18;
const long double PI = 2 * acos(.0);
string mapa[55];
pair<int, int> pixelDir[55][55][5][3];
int movxDP[4] = {0, 1, 0, -1};
int movyDP[4] = {1, 0, -1, 0};
int visited[55][55][5][3];
int main() {
  int m, n;
  cin >> m >> n;
  for (int i = 0; i < (int)(m); i++) {
    cin >> mapa[i];
  }
  int mm = (mapa[0]).size();
  for (int i = 0; i < (int)(m); i++)
    for (int j = 0; j < (int)(mm); j++) {
      for (int k = 0; k < (int)(4); k++) {
        char color = mapa[i][j];
        pair<int, int> punt = make_pair(i, j);
        while (1) {
          if (!(punt.first + movxDP[k] >= 0 && punt.first + movxDP[k] < m &&
                punt.second + movyDP[k] >= 0 && punt.second + movyDP[k] < mm))
            break;
          if (mapa[punt.first + movxDP[k]][punt.second + movyDP[k]] != color)
            break;
          punt.first += movxDP[k];
          punt.second += movyDP[k];
        }
        pair<int, int> puntIni = punt;
        while (1) {
          if (!(punt.first + movxDP[(k + 3) % 4] >= 0 &&
                punt.first + movxDP[(k + 3) % 4] < m &&
                punt.second + movyDP[(k + 3) % 4] >= 0 &&
                punt.second + movyDP[(k + 3) % 4] < mm))
            break;
          if (mapa[punt.first + movxDP[(k + 3) % 4]]
                  [punt.second + movyDP[(k + 3) % 4]] != color)
            break;
          punt.first += movxDP[(k + 3) % 4];
          punt.second += movyDP[(k + 3) % 4];
        }
        punt.first += movxDP[k];
        punt.second += movyDP[k];
        pixelDir[i][j][k][0] = punt;
        punt = puntIni;
        while (1) {
          if (!(punt.first + movxDP[(k + 1) % 4] >= 0 &&
                punt.first + movxDP[(k + 1) % 4] < m &&
                punt.second + movyDP[(k + 1) % 4] >= 0 &&
                punt.second + movyDP[(k + 1) % 4] < mm))
            break;
          if (mapa[punt.first + movxDP[(k + 1) % 4]]
                  [punt.second + movyDP[(k + 1) % 4]] != color)
            break;
          punt.first += movxDP[(k + 1) % 4];
          punt.second += movyDP[(k + 1) % 4];
        }
        punt.first += movxDP[k];
        punt.second += movyDP[k];
        pixelDir[i][j][k][1] = punt;
      }
    }
  pair<int, int> BP = make_pair(0, 0);
  int DP = 0;
  int CP = 0;
  memset(visited, 0, sizeof(visited));
  pair<int, int> tt, inicial(0, 0);
  string lista = "";
  int cont = 0;
  for (int i = 0; i < (int)(n); i++) {
    if (visited[BP.first][BP.second][DP][CP] == 1) {
      lista += mapa[BP.first][BP.second];
    } else if (visited[BP.first][BP.second][DP][CP] == 2) {
      cont = i;
      break;
    }
    visited[BP.first][BP.second][DP][CP]++;
    tt = pixelDir[BP.first][BP.second][DP][CP];
    bool cent = 1;
    if (tt.first >= 0 && tt.first < m && tt.second >= 0 && tt.second < mm) {
      if (mapa[tt.first][tt.second] != '0') {
        cent = 0;
        BP = tt;
      }
    }
    if (cent) {
      if (CP) DP = (DP + 1) % 4;
      CP = 1 - CP;
    }
  }
  if (cont == 0)
    cout << mapa[BP.first][BP.second] << endl;
  else
    cout << lista[(n - cont) % (lista).size()] << endl;
  return 0;
}
