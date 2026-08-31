#include <bits/stdc++.h>
using namespace std;
long long Ta[200001] = {}, Tb[200001] = {};
long long A[200001] = {};
void inc(int i, long long v, long long* t) {
  for (; i < 200001; i += i & -i) t[i] += v;
}
long long sum(int r, long long* t) {
  long long res = 0;
  for (; r; r -= r & -r) res += t[r];
  return res;
}
int main() {
  long long n, k, a, b, q;
  cin >> n >> k >> a >> b >> q;
  for (int x = 0; x < q; x++) {
    long long Q, q1, q2;
    cin >> Q;
    if (Q == 1) {
      cin >> q1 >> q2;
      inc(q1, max(min(b - A[q1], (long long)q2), 0LL), Tb);
      inc(q1, max(min(a - A[q1], (long long)q2), 0LL), Ta);
      A[q1] += q2;
    } else {
      cin >> q1;
      cout << sum(q1 - 1, Tb) + (sum(200001 - 1, Ta) - sum(q1 + k - 1, Ta))
           << '\n';
    }
  }
}
