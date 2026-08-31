#include <bits/stdc++.h>
const char en = '\n';
using namespace std;
struct operacia {
  long long t;
  long long l;
  long long r;
  long long d;
};
vector<long long> K, T;
vector<operacia> V;
int main() {
  long long n, m;
  cin >> n >> m;
  for (int i = 1; i <= m; i++) {
    long long t, l, r, d;
    cin >> t >> l >> r >> d;
    V.push_back({t, l, r, d});
  }
  reverse(V.begin(), V.end());
  K.resize(n + 47, 1000000000);
  for (auto it = V.begin(); it != V.end(); it++) {
    if (it->t == 1) {
      for (long long i = it->l; i <= it->r; i++) K[i] -= it->d;
    }
    if (it->t == 2) {
      for (long long i = it->l; i <= it->r; i++) K[i] = min(K[i], it->d);
    }
  }
  T = K;
  reverse(V.begin(), V.end());
  bool ok = true;
  for (auto it = V.begin(); it != V.end(); it++) {
    if (it->t == 1)
      for (long long i = it->l; i <= it->r; i++) T[i] += it->d;
    else {
      long long mi = -1000000000;
      for (long long i = it->l; i <= it->r; i++) mi = max(mi, T[i]);
      if (mi != it->d) {
        ok = false;
        break;
      }
    }
  }
  if (ok == true) {
    cout << "YES" << endl;
    for (int i = 1; i < n; i++)
      cout << min(max(K[i], (long long)-1000000000), (long long)1000000000)
           << " ";
    cout << min(max(K[n], (long long)-1000000000), (long long)1000000000)
         << endl;
  } else
    cout << "NO" << endl;
}
