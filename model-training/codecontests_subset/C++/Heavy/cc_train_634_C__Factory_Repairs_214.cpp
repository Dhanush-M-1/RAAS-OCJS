#include <bits/stdc++.h>
using namespace std;
long long a, b, n, k, q;
long long BITA[500010];
void updatea(long long idx, long long val) {
  while (idx < 500010) {
    BITA[idx] += val;
    idx += (idx & (-idx));
  }
}
long long reada(long long idx) {
  long long sum = 0;
  while (idx > 0) {
    sum += BITA[idx];
    idx -= (idx & (-idx));
  }
  return sum;
}
long long BITB[500010];
void updateb(long long idx, long long val) {
  while (idx < 500010) {
    BITB[idx] += val;
    idx += (idx & (-idx));
  }
}
long long readb(long long idx) {
  long long sum = 0;
  while (idx > 0) {
    sum += BITB[idx];
    idx -= (idx & (-idx));
  }
  return sum;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(NULL);
  long long i;
  cin >> n >> k >> a >> b >> q;
  for (i = 0; i < q; i++) {
    long long type;
    cin >> type;
    if (type == 1) {
      long long x, y;
      cin >> x >> y;
      long long curr = reada(x) - reada(x - 1);
      if (curr < b) updatea(x, min(b - curr, y));
      curr = readb(x) - readb(x - 1);
      if (curr < a) updateb(x, min(a - curr, y));
    } else {
      long long x;
      cin >> x;
      long long ans = 0;
      ans = reada(x - 1);
      ans += readb(500010);
      ans -= readb(x + k - 1);
      cout << ans << '\n';
    }
  }
  return 0;
}
