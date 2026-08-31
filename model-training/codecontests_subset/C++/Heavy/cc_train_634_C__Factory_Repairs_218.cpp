#include <bits/stdc++.h>
using namespace std;
struct fin {
  vector<long long> T;
  fin(int N) { T.resize(N + 47, 0); }
  int lastone(int x) { return x & (x ^ (x - 1)); }
  void put(int pos, long long val) {
    for (int i = pos + 1; i < (int)T.size(); i += lastone(i)) T[i] += val;
  }
  long long get(int pos) {
    long long ret = 0;
    for (int i = pos + 1; i > 0; i -= lastone(i)) ret += T[i];
    return ret;
  }
};
int main() {
  cin.sync_with_stdio(0);
  cin.tie(0);
  cout << fixed << setprecision(10);
  int N, K, Q;
  long long A, B;
  scanf(" %d %d %lld %lld %d", &N, &K, &A, &B, &Q);
  vector<long long> ord(N, 0);
  fin F1(N), F2(N);
  for (int q = 0; q < Q; q++) {
    int tp;
    scanf(" %d", &tp);
    if (tp == 2) {
      int p;
      scanf(" %d", &p);
      p--;
      printf("%lld\n", F1.get(p - 1) + F2.get(N - (p + K)));
      continue;
    }
    int d, a;
    scanf(" %d %d", &d, &a);
    d--;
    F1.put(d, -min(B, ord[d]));
    F2.put(N - d, -min(A, ord[d]));
    ord[d] += a;
    F1.put(d, min(B, ord[d]));
    F2.put(N - d, min(A, ord[d]));
  }
  return 0;
}
