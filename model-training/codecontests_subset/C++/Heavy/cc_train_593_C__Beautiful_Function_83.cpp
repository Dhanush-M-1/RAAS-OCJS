#include <bits/stdc++.h>
using namespace std;
long long rdtsc() {
  long long tmp;
  asm("rdtsc" : "=A"(tmp));
  return tmp;
}
inline int myrand() { return abs((rand() << 15) ^ rand()); }
inline int rnd(int x) { return myrand() % x; }
const int INF = (int)1.01e9;
const long double EPS = 1e-9;
void precalc() {}
const int maxn = 50 + 5;
int n;
int xs[maxn], ys[maxn];
bool read() {
  if (scanf("%d", &n) < 1) {
    return 0;
  }
  for (int i = 0; i < n; ++i) {
    int r;
    scanf("%d%d%d", xs + i, ys + i, &r);
  }
  return 1;
}
void print(int n, int *vals) {
  string res = "";
  for (int i = 0; i < n - 1; ++i) {
    res += "(";
  }
  static char tmp[30];
  {
    sprintf(tmp, "%d", vals[0]);
    res += tmp;
  }
  int a = 0;
  int last = vals[0];
  for (int i = 1; i < n; ++i) {
    int times = (vals[i] - last - a) / 2;
    a += times * 2;
    last += a;
    if (times >= 0) {
      res += "+";
    } else {
      res += "-";
      times = -times;
    }
    assert(times <= 50);
    sprintf(tmp, "(%d*((t-%d)+abs((t-%d)))))", times, i - 1, i - 1);
    res += tmp;
  }
  printf("%s\n", res.c_str());
}
void solve() {
  print(n, xs);
  print(n, ys);
}
int main() {
  srand(rdtsc());
  precalc();
  while (1) {
    if (!read()) {
      break;
    }
    solve();
  }
  return 0;
}
