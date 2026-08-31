#include <bits/stdc++.h>
const char en = '\n';
using namespace std;
int size = 250000;
long long lastone(long long x) { return x & (x ^ (x - 1)); }
long long get(long long p, vector<long long> &F) {
  long long res = 0;
  for (long long i = p; i > 0; i -= lastone(i)) res += F[i];
  return res;
}
long long se(long long p, long long h, vector<long long> &F) {
  for (long long i = p; i < size; i += lastone(i)) F[i] += h;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  long long n, k, a, b, q;
  cin >> n >> k >> a >> b >> q;
  vector<long long> V(300000, 0), Fa = V, Fb = V;
  for (int i = 0; i < q; i++) {
    int t;
    cin >> t;
    if (t == 1) {
      long long dd, aa;
      cin >> dd >> aa;
      long long diff = min(a - V[dd], aa);
      se(dd, diff, Fa);
      long long diff1 = min(max(b - V[dd], 0LL), aa);
      se(dd, diff1, Fb);
      V[dd] += diff;
    } else {
      int p;
      cin >> p;
      cout << get(p - 1, Fb) + get(size - 47, Fa) - get(p + k - 1, Fa) << en;
    }
  }
}
