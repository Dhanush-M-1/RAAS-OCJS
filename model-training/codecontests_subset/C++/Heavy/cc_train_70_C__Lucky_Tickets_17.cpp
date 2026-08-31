#include <bits/stdc++.h>
using namespace std;
const int N = 110000;
const long long INF = (long long)N * (long long)N;
int mam[N][2];
map<pair<int, int>, int> mapa;
inline int numer(const pair<int, int> &p) {
  if (mapa.count(p) == 0) {
    int res = (int)mapa.size();
    return mapa[p] = res;
  }
  return mapa[p];
}
int rev(int x) {
  int res = 0;
  while (x > 0) {
    res = 10 * res + (x % 10);
    x /= 10;
  }
  return res;
}
int nwd(int a, int b) { return b == 0 ? a : nwd(b, a % b); }
pair<int, int> popraw(int a, int b) {
  int d = nwd(a, b);
  return make_pair(a / d, b / d);
}
int dajnumer(int x) { return numer(popraw(x, rev(x))); }
int dajnumerrev(int x) { return numer(popraw(rev(x), x)); }
int main() {
  int maxx, maxy, w;
  long long suma = 0;
  long long best = INF;
  int bestx = -1, besty = -1;
  scanf("%d %d %d", &maxx, &maxy, &w);
  for (int i = (1); i <= (maxx); ++i) {
    int a = dajnumer(i);
    mam[a][0]++;
  }
  int akty = 0;
  for (int i = (maxx); i >= (1); --i) {
    while (akty < maxy && suma < w) {
      akty++;
      int b = dajnumerrev(akty);
      suma -= (long long)mam[b][0] * (long long)mam[b][1];
      mam[b][1]++;
      suma += (long long)mam[b][0] * (long long)mam[b][1];
    }
    if (suma < w) break;
    if ((long long)i * (long long)akty < best) {
      best = (long long)i * (long long)akty;
      bestx = i;
      besty = akty;
    }
    int a = dajnumer(i);
    suma -= (long long)mam[a][0] * (long long)mam[a][1];
    mam[a][0]--;
    suma += (long long)mam[a][0] * (long long)mam[a][1];
  }
  if (best == INF)
    puts("-1");
  else
    printf("%d %d\n", bestx, besty);
  return 0;
}
