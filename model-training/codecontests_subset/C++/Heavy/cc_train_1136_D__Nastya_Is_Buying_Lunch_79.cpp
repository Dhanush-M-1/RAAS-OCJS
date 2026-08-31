#include <bits/stdc++.h>
const int inf = 2e9;
using namespace std;
long long MOD = 1000000007;
typedef struct {
  int a, b, c;
} iii;
int a, b, n, q, t, k, m, res, suma, minimo, ans = 0, maxi, indi;
map<pair<int, int>, bool> M;
vector<int> ad;
int pos[300005], fila[300005];
bool ord(int a, int b) { return pos[b] < pos[a]; }
int main() {
  int inicial, nay;
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a);
    fila[i] = a;
    pos[a] = i;
    if (i == n) {
      inicial = i;
      nay = a;
    }
  }
  for (int i = 0; i < m; ++i) {
    scanf("%d%d", &a, &b);
    if (b == nay) {
      M[{a, b}] = true;
      ad.push_back(a);
    } else
      M[{a, b}] = true;
  }
  sort(ad.begin(), ad.end(), ord);
  for (auto x : ad) {
    while (pos[x] + 1 <= n && M[{x, fila[pos[x] + 1]}]) {
      int px = pos[x], ps = pos[x] + 1, s = fila[ps];
      pos[x] = ps;
      pos[s] = px;
      fila[ps] = x;
      fila[px] = s;
    }
  }
  printf("%d\n", inicial - pos[nay]);
}
