#include <bits/stdc++.h>
using namespace std;
const int MAX_D = 2000005;
int n, k, a, b, q;
int days[MAX_D];
int fenA[MAX_D];
int fenB[MAX_D];
int get(int *fen, int x) {
  int sum = 0;
  while (x > 0) {
    sum += fen[x];
    x = (x & (x + 1)) - 1;
  }
  return sum;
}
void update(int *fen, int i, int x) {
  while (i <= n) {
    fen[i] += x;
    i = ((i + 1) | i);
  }
}
int getLine(int *fen, int l, int r) {
  if (l > r)
    return 0;
  else
    return get(fen, r) - get(fen, l - 1);
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cin >> n >> k >> a >> b >> q;
  for (int i = 0; i < q; ++i) {
    int t;
    cin >> t;
    if (t == 1) {
      int d, x;
      cin >> d >> x;
      int pred = days[d];
      days[d] += x;
      update(fenA, d, min(days[d], a) - min(pred, a));
      update(fenB, d, min(days[d], b) - min(pred, b));
    } else {
      int p;
      cin >> p;
      cout << getLine(fenB, 1, p - 1) + getLine(fenA, p + k, n) << '\n';
    }
  }
  return 0;
}
