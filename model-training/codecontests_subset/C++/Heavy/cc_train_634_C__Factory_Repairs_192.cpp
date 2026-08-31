#include <bits/stdc++.h>
using namespace std;
long long int i, j, k, l, K, n, r, c, a, b, q, A[200001], B[200001], first,
    second, z, v[200001];
void updateA(int pos, int val) {
  int t = a - v[pos];
  if (t < 0) t = 0;
  t = min(t, val);
  if (t)
    for (int i = pos; i <= n; i += i & (-i)) {
      A[i] += t;
    }
}
void updateB(int pos, int val) {
  int t = b - v[pos];
  if (t < 0) t = 0;
  t = min(t, val);
  if (t)
    for (int i = pos; i <= n; i += i & (-i)) {
      B[i] += t;
    }
}
long long int querryA(int pos) {
  int r = 0;
  for (int i = pos; i; i -= i & (-i)) {
    r += A[i];
  }
  return r;
}
long long int querryB(int pos) {
  int r = 0;
  for (int i = pos; i; i -= i & (-i)) {
    r += B[i];
  }
  return r;
}
int main() {
  ios::sync_with_stdio(false);
  cout.precision(10);
  cout << fixed;
  cin >> n >> k >> a >> b >> q;
  while (q--) {
    cin >> first;
    if (first == 1) {
      cin >> second >> z;
      updateA(second, z);
      updateB(second, z);
      v[second] += z;
    } else {
      long long int valA, valB;
      valA = valB = 0;
      cin >> first;
      if (first != 1) valA = querryB(first - 1);
      if (first + k <= n) valB = querryA(n) - querryA(first + k - 1);
      cout << valA + valB << '\n';
    }
  }
  return 0;
}
