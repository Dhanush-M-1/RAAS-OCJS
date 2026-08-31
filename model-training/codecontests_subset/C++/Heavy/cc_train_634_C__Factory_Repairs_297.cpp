#include <bits/stdc++.h>
using namespace std;
const int M = 1e6 + 15;
const int Q = 1e9 + 7;
long long tree[2][M];
long long v[M];
void upd(int tq, int i, long long x) {
  for (; i < M; i = (i | (i - 1)) + 1) tree[tq][i] += x;
}
long long get(int tq, int i) {
  long long res = 0;
  for (; i; i = i & (i - 1)) res += tree[tq][i];
  return res;
}
long long sum(int tq, int l, int r) { return get(tq, r) - get(tq, l - 1); }
int main() {
  srand(time(NULL));
  int n, k, q;
  long long a, b;
  cin >> n >> k >> b >> a >> q;
  for (int i = 0; i < q; i++) {
    int t;
    cin >> t;
    if (t == 1) {
      int di, ai;
      cin >> di >> ai;
      upd(0, di, min(a, v[di] + ai) - min(a, v[di]));
      upd(1, di, min(b, v[di] + ai) - min(b, v[di]));
      v[di] += ai;
    } else {
      int pi;
      cin >> pi;
      cout << sum(0, 1, pi - 1) + sum(1, pi + k, n) << "\n";
    }
  }
  return 0;
}
