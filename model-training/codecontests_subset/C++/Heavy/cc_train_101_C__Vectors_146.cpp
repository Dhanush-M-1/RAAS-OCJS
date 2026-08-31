#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
#pragma GCC target("avx,avx2,fma")
using namespace std;
const long long N = 1e9 + 5, mod = 1e9 + 7;
struct pt {
  long long x, y;
} A, B, C;
long long dist(pt a) { return a.x * a.x + a.y * a.y; }
long long cross(pt a, pt b) { return a.x * b.y - a.y * b.x; }
long long dot(pt a, pt b) { return a.x * b.x + a.y * b.y; }
bool chk() {
  long long d = dist(C);
  if (d == 0) return A.x == B.x && A.y == B.y;
  pt tmp;
  tmp.x = A.x + B.x;
  tmp.y = A.y + B.y;
  long long v1 = dot(tmp, C);
  long long v2 = cross(tmp, C);
  if (v1 % d != 0 || v2 % d != 0) return 0;
  return 1;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> A.x >> A.y >> B.x >> B.y >> C.x >> C.y;
  for (long long i = 0; i < 4; i++) {
    if (chk()) return cout << "YES", 0;
    swap(A.x, A.y);
    A.y *= -1;
  }
  cout << "NO";
}
