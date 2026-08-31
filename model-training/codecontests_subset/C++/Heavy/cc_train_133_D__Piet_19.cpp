#include <bits/stdc++.h>
using namespace std;
enum Kierunki { GORA, PRAWO, DOL, LEWO };
const int SIZE = 55;
pair<int, int> grupa[SIZE * SIZE][10][10];
char plansza[SIZE][SIZE];
int odw[SIZE][SIZE];
int m_w, m_k;
void grupuj(int w, int k, int id) {
  int max_w = m_w - 1, max_k = m_k - 1;
  for (typeof(w) i = (w); i < (m_w); ++i) {
    if (plansza[i][k] != plansza[w][k]) {
      max_w = i - 1;
      break;
    }
    for (typeof(k) j = (k); j < (m_k); ++j) {
      if (plansza[i][j] != plansza[w][k]) {
        max_k = j - 1;
        break;
      }
      odw[i][j] = id;
    }
  }
  grupa[id][GORA][LEWO].first = w - 1;
  grupa[id][GORA][LEWO].second = k;
  grupa[id][GORA][PRAWO].first = w - 1;
  grupa[id][GORA][PRAWO].second = max_k;
  grupa[id][DOL][LEWO].first = max_w + 1;
  grupa[id][DOL][LEWO].second = max_k;
  grupa[id][DOL][PRAWO].first = max_w + 1;
  grupa[id][DOL][PRAWO].second = k;
  grupa[id][LEWO][LEWO].first = max_w;
  grupa[id][LEWO][LEWO].second = k - 1;
  grupa[id][LEWO][PRAWO].first = w;
  grupa[id][LEWO][PRAWO].second = k - 1;
  grupa[id][PRAWO][LEWO].first = w;
  grupa[id][PRAWO][LEWO].second = max_k + 1;
  grupa[id][PRAWO][PRAWO].first = max_w;
  grupa[id][PRAWO][PRAWO].second = max_k + 1;
}
void nastepny(int &bp, Kierunki &dp, Kierunki &cp) {
  int w = grupa[bp][dp][cp].first;
  int k = grupa[bp][dp][cp].second;
  if (w < 0 || w >= m_w || k < 0 || k >= m_k || plansza[w][k] == '0') {
    if (cp == LEWO)
      cp = PRAWO;
    else {
      cp = LEWO;
      switch (dp) {
        case GORA:
          dp = PRAWO;
          break;
        case PRAWO:
          dp = DOL;
          break;
        case DOL:
          dp = LEWO;
          break;
        case LEWO:
          dp = GORA;
          break;
      }
    }
  } else {
    bp = odw[w][k];
  }
}
int main() {
  int n;
  scanf("%d %d", &m_w, &n);
  for (typeof(0) i = (0); i < (m_w); ++i) scanf("%s", plansza[i]);
  m_k = strlen(plansza[0]);
  int id = 1;
  for (typeof(0) i = (0); i < (m_w); ++i)
    for (typeof(0) j = (0); j < (m_k); ++j)
      if (!odw[i][j]) grupuj(i, j, id++);
  int bp = 1;
  Kierunki dp = PRAWO;
  Kierunki cp = LEWO;
  for (typeof(0) i = (0); i < (n); ++i) nastepny(bp, dp, cp);
  int w = grupa[bp][GORA][LEWO].first + 1;
  int k = grupa[bp][GORA][LEWO].second;
  printf("%c\n", plansza[w][k]);
  return 0;
}
