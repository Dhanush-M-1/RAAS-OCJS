#include <bits/stdc++.h>
using namespace std;
const int MAX = 2e5 + 7;
const long long MOD = 998244353;
const long long PIERW = 100;
int ciag[MAX];
int ostatnie[MAX];
int poprzedni[MAX];
long long pomocnicza[MAX];
long long DP[MAX];
struct Blok {
  int lewa, prawa;
  long long suma;
  long long sumaDP[PIERW * 2 + 1];
  void Aktualizuj() {
    for (int i = 0; i <= 2 * PIERW; ++i) sumaDP[i] = 0;
    suma = 0;
    for (int i = prawa; i >= lewa; --i) {
      suma += pomocnicza[i];
      sumaDP[suma + PIERW] = (sumaDP[suma + PIERW] + DP[i - 1]) % MOD;
    }
    for (int i = 1; i <= 2 * PIERW; i++)
      sumaDP[i] = (sumaDP[i] + sumaDP[i - 1]) % MOD;
  }
};
Blok bloki[MAX / PIERW + 7];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n, k;
  cin >> n >> k;
  DP[0] = 1;
  for (int i = 0; i * PIERW <= n; ++i) {
    bloki[i].lewa = i * PIERW + 1;
    bloki[i].prawa = (i + 1) * PIERW;
    bloki[i].Aktualizuj();
  }
  for (int i = 1; i <= n; ++i) {
    cin >> ciag[i];
    poprzedni[i] = ostatnie[ciag[i]];
    ostatnie[ciag[i]] = i;
    pomocnicza[i] = 1;
    pomocnicza[poprzedni[i]] = -1;
    int t = poprzedni[poprzedni[i]];
    pomocnicza[t] = 0;
    bloki[(i - 1) / PIERW].Aktualizuj();
    bloki[(poprzedni[i] - 1) / PIERW].Aktualizuj();
    bloki[(t - 1) / PIERW].Aktualizuj();
    int blok = (i - 1) / PIERW;
    long long suma = 0;
    for (int j = blok; j >= 0; --j) {
      int x = min(k - suma, PIERW);
      if (-PIERW <= x && x <= PIERW)
        DP[i] = (DP[i] + bloki[j].sumaDP[x + PIERW]) % MOD;
      suma += bloki[j].suma;
    }
    bloki[i / PIERW].Aktualizuj();
  }
  cout << DP[n] << "\n";
  return 0;
}
