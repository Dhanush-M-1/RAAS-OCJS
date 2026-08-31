#include <bits/stdc++.h>
using namespace std;

int main() {
  int X, K;
  cin >> X >> K;
  vector<int> r(K + 1); r[0] = 0;
  for (int i = 0; i < K; i++) cin >> r[i + 1];
  int Q;
  cin >> Q;
  vector<int> t(Q), a(Q);
  for (int i = 0; i < Q; i++) cin >> t[i] >> a[i];

  int now = 0, pos = 0;
  int L = 0, R = X;
  int va = 0, vb = X;
  for (int i = 0; i < Q; i++) {
    for (int j = now + 1; j <= K; j++) {
      if (r[j] > t[i]) break;
      if (j % 2 == 1) {
        pos += r[j] - r[j - 1];
        va = max(0, va - (r[j] - r[j - 1]));
        vb = max(0, vb - (r[j] - r[j - 1]));
      } else {
        pos -= r[j] - r[j - 1];
        va = min(X, va + (r[j] - r[j - 1]));
        vb = min(X, vb + (r[j] - r[j - 1]));
      }
      L = max(L, pos);
      R = min(R, X + pos);
      now++;
    }
    int c;
    if (L <= a[i] && a[i] <= R) c = a[i] - pos;
    if (a[i] < L) c = va;
    if (R < a[i]) c = vb;
    c = (now % 2 == 0) ? max(0, c - (t[i] - r[now])) : min(X, c + (t[i] - r[now]));
    cout << c << endl;
  }
}
