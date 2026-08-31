#include <bits/stdc++.h>
using namespace std;
const int M = 262144;
long long A, B;
int n, k, q;
long long ta[M];
long long Da[2 * M];
long long Db[2 * M];
void insert(int x, long long ww) {
  ta[x] += ww;
  Da[x + M] = min(ta[x], A);
  Db[x + M] = min(ta[x], B);
  x += M;
  x /= 2;
  while (x > 0) {
    Da[x] = Da[2 * x] + Da[2 * x + 1];
    Db[x] = Db[2 * x] + Db[2 * x + 1];
    x /= 2;
  }
}
long long querya(int a, int b) {
  a += M;
  b += M;
  long long res = Da[a];
  if (a != b) res += Da[b];
  while (a / 2 != b / 2) {
    if (a % 2 == 0) res += Da[a + 1];
    if (b % 2 == 1) res += Da[b - 1];
    a /= 2;
    b /= 2;
  }
  return res;
}
long long queryb(int a, int b) {
  a += M;
  b += M;
  long long res = Db[a];
  if (a != b) res += Db[b];
  while (a / 2 != b / 2) {
    if (a % 2 == 0) res += Db[a + 1];
    if (b % 2 == 1) res += Db[b - 1];
    a /= 2;
    b /= 2;
  }
  return res;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin >> n >> k >> A >> B >> q;
  while (q--) {
    int md;
    cin >> md;
    if (md == 1) {
      int x, ww;
      cin >> x >> ww;
      insert(x, ww);
    } else {
      int x;
      cin >> x;
      long long res = 0;
      if (x > 1) res += queryb(1, x - 1);
      if (x + k - 1 < n) res += querya(x + k, n);
      cout << res << '\n';
    }
  }
  return 0;
}
