#include <bits/stdc++.h>
using namespace std;
int bs[20];
int cvp[8][20];
int tl;
bool dur = false;
vector<int> b1[10];
vector<int> b2[10];
vector<int> b3[10];
vector<int> b4[10];
vector<int> b5[10];
vector<int> b6[10];
pair<pair<int, int>, pair<int, int> > nereden[20][10];
inline void rec(int sira, int elde) {
  if (dur) return;
  if (sira == tl && elde == 0) {
    int s = sira, e = elde;
    while (true) {
      int ee = e;
      int es = s;
      s = nereden[es][ee].first.first;
      e = nereden[es][ee].first.second;
      int g = nereden[es][ee].second.first;
      int i = nereden[es][ee].second.second;
      cvp[1][s] = b1[g][i];
      cvp[2][s] = b2[g][i];
      cvp[3][s] = b3[g][i];
      cvp[4][s] = b4[g][i];
      cvp[5][s] = b5[g][i];
      cvp[6][s] = b6[g][i];
      if (s == 0) break;
    }
    dur = true;
    return;
  }
  if (sira == tl) return;
  int g = (bs[sira] - elde + 10) % 10;
  for (int i = 0; i < b1[g].size(); i++) {
    int t = b1[g][i] + b2[g][i] + b3[g][i] + b4[g][i] + b5[g][i] + b6[g][i];
    nereden[sira + 1][(elde + t) / 10] =
        make_pair(make_pair(sira, elde), make_pair(g, i));
    rec(sira + 1, (elde + t) / 10);
  }
}
inline void solve(long long int t) {
  dur = false;
  tl = 0;
  memset(bs, 0, sizeof(bs));
  memset(cvp, 0, sizeof(cvp));
  while (t) {
    bs[tl++] = t % 10;
    t /= 10;
  }
  rec(0, 0);
  tl++;
  if (!dur) {
    printf("%d", -1);
  } else {
    for (int i = 1; i <= 6; i++) {
      bool sifir = true;
      for (int j = tl - 1; j >= 0; j--) {
        if (cvp[i][j] == 0 && j >= 1 && sifir) {
        } else {
          printf("%d", cvp[i][j]);
          sifir = false;
        }
      }
      printf(" ");
    }
  }
  printf("\n");
}
int main() {
  for (int i = 0; i < 8; i += 4) {
    for (int j = i; j < 8; j += 4) {
      for (int k = j; k < 8; k += 4) {
        for (int x = k; x < 8; x += 4) {
          for (int y = x; y < 8; y += 4) {
            for (int z = y; z < 8; z += 4) {
              int toplam = x + y + z + i + j + k;
              b1[toplam % 10].push_back(i);
              b2[toplam % 10].push_back(j);
              b3[toplam % 10].push_back(k);
              b4[toplam % 10].push_back(x);
              b5[toplam % 10].push_back(y);
              b6[toplam % 10].push_back(z);
              if (z == 4) z--;
            }
            if (y == 4) y--;
          }
          if (x == 4) x--;
        }
        if (k == 4) k--;
      }
      if (j == 4) j--;
    }
    if (i == 4) i--;
  }
  int n;
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    long long int t;
    scanf("%I64d", &t);
    solve(t);
  }
  getchar();
  getchar();
  getchar();
  getchar();
  getchar();
  getchar();
  return 0;
}
