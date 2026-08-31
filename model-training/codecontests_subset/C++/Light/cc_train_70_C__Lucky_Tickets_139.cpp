#include <bits/stdc++.h>
using namespace std;
const long long Inf = (long long)1e16;
const int N = 101000;
int x, y, w, a[N], b[N];
int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }
int calc(int x) {
  int ret = 0;
  while (x) {
    ret = ret * 10 + x % 10;
    x /= 10;
  }
  return ret;
}
void init() {
  for (int i = 1; i < N; i++) {
    a[i] = i;
    b[i] = calc(i);
    int g = gcd(a[i], b[i]);
    a[i] /= g;
    b[i] /= g;
  }
}
int main() {
  init();
  cin >> x >> y >> w;
  map<pair<int, int>, int> m1, m2;
  int p, total = 0;
  for (p = 1; p <= x; p++) {
    m1[make_pair(b[p], a[p])]++;
  }
  p = x;
  int ax = -1, ay = -1;
  long long pro = Inf;
  for (int i = 1; i <= y; i++) {
    m2[make_pair(a[i], b[i])]++;
    total += m1[make_pair(a[i], b[i])];
    while (p > 1 && total - m2[make_pair(b[p], a[p])] >= w) {
      total -= m2[make_pair(b[p], a[p])];
      m1[make_pair(b[p], a[p])]--;
      p--;
    }
    if (total >= w && pro > (long long)p * i) {
      ax = p;
      ay = i;
      pro = (long long)p * i;
    }
  }
  if (pro == Inf) {
    puts("-1");
  } else {
    printf("%d %d\n", ax, ay);
  }
  return 0;
}
