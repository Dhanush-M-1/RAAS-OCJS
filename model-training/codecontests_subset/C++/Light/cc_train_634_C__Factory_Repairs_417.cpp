#include <bits/stdc++.h>
using namespace std;
vector<long long> staro(200005, 0), novo(200005, 0), vrijednost(200005, 0);
void update(int node, int koliko, int koji) {
  if (koji == 1)
    for (node; node <= 200005; node += node & (-node)) staro[node] += koliko;
  else
    for (node; node <= 200005; node += node & (-node)) novo[node] += koliko;
}
long long query(int node, int koji) {
  long long res = 0;
  if (koji == 1)
    for (node; node >= 1; node -= node & (-node)) res += staro[node];
  else
    for (node; node >= 1; node -= node & (-node)) res += novo[node];
  return res;
}
int main() {
  long long n, k, a, b, q;
  cin >> n >> k >> a >> b >> q;
  for (int i = 0; i < q; i++) {
    int t;
    scanf("%d", &t);
    if (t == 1) {
      int d, x, y;
      scanf("%d%d", &d, &x);
      update(d, min(vrijednost[d] + x, b) - min(vrijednost[d], b), 1);
      update(d, min(vrijednost[d] + x, a) - min(vrijednost[d], a), 2);
      vrijednost[d] += x;
    } else if (t == 2) {
      int p;
      scanf("%d", &p);
      long long res = 0;
      res += query(p - 1, 1);
      if (p + k - 1 <= n) {
        res += query(n, 2);
        res -= query(p + k - 1, 2);
      }
      cout << res << endl;
    }
  }
  return 0;
}
