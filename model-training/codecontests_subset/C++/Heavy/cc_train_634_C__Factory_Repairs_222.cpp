#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 5;
int n, k, a, b, q, cnt[N];
struct fenwick {
  int fen[N];
  void add(int p, int x) {
    for (; p < N; p += p & -p) fen[p] += x;
  }
  int get(int p) {
    int ans = 0;
    for (; p; p -= p & -p) ans += fen[p];
    return ans;
  }
} fen1, fen2;
void readInput() { cin >> n >> k >> a >> b >> q; }
void writeOutput() {
  for (int i = 0; i < q; i++) {
    int t;
    cin >> t;
    if (t & 1) {
      int d, x;
      cin >> d >> x;
      cnt[d] += x;
      fen1.add(d, max(min(b, cnt[d]) - cnt[d] + x, 0));
      fen2.add(n - d + 1, max(min(a, cnt[d]) - cnt[d] + x, 0));
    } else {
      int p;
      cin >> p;
      cout << fen1.get(p - 1) + fen2.get(n - p - k + 1) << endl;
    }
  }
}
int main() {
  ios_base ::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  readInput(), writeOutput();
  return 0;
}
