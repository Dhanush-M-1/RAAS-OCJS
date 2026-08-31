#include <bits/stdc++.h>
using namespace std;
const int kMaxN = 200001;
struct E {
  int x, v, w;
  bool operator<(const E &e) const { return x < e.x; }
} e[kMaxN];
struct T {
  long long c, v;
} t[kMaxN];
int a[kMaxN];
int n;
long long ans;
int LowBit(int x) { return x & (-x); }
void Calc(int x) {
  t[0] = {0, 0};
  while (x) {
    t[0].c += t[x].c;
    t[0].v += t[x].v;
    x -= LowBit(x);
  }
}
void Add(int x, int v) {
  while (x <= n) {
    t[x].c++;
    t[x].v += v;
    x += LowBit(x);
  }
}
void Dis() {
  sort(a + 1, a + 1 + n, [](int i, int j) { return e[i].v < e[j].v; });
  e[0].v = 1 << 31;
  for (int i = 1, j = 0; i <= n; i++) {
    j += e[a[i]].v != e[a[i - 1]].v;
    e[a[i]].w = j;
  }
}
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> e[i].x;
  }
  for (int i = 1; i <= n; i++) {
    cin >> e[i].v;
    a[i] = i;
  }
  Dis();
  sort(e + 1, e + 1 + n);
  for (int i = 1; i <= n; i++) {
    Calc(e[i].w);
    ans += e[i].x * t[0].c - t[0].v;
    Add(e[i].w, e[i].x);
  }
  cout << ans << endl;
  return 0;
}
