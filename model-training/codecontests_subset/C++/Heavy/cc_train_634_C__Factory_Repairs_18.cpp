#include <bits/stdc++.h>
using namespace std;
const int MN = 2e5 + 10;
int n, k, A, B, q;
long long arr[MN], fen[2][MN];
void add(int id, int p, long long val) {
  for (p++; p < MN; p += p & -p) fen[id][p] += val;
}
long long get(int id, int p) {
  long long ret = 0;
  for (; p; p -= p & -p) ret += fen[id][p];
  return ret;
}
int main() {
  ios_base ::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  cin >> n >> k >> A >> B >> q;
  while (q--) {
    int tp;
    cin >> tp;
    if (tp == 1) {
      int d, x;
      cin >> d >> x;
      --d;
      long long sv1 = min(1ll * B, arr[d]), sv2 = min(1ll * A, arr[d]);
      arr[d] += x;
      add(0, d, min((long long)B, arr[d]) - sv1),
          add(1, d, min((long long)A, arr[d]) - sv2);
    } else {
      int p;
      cin >> p;
      --p;
      cout << get(0, p) + get(1, n) - get(1, p + k) << '\n';
    }
  }
  return 0;
}
