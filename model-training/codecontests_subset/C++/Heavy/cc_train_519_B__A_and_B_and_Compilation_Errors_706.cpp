#include <bits/stdc++.h>
using namespace std;
const double EPS = 1e-9;
const int INF = 0x7f7f7f7f;
struct debugger {
  template <typename T>
  debugger& operator,(const T& v) {
    cerr << v << " ";
    return *this;
  }
} dbg;
template <class T>
T _abs(T n) {
  return (n < 0 ? -n : n);
}
template <class T>
T _max(T a, T b) {
  return (!(a < b) ? a : b);
}
template <class T>
T _min(T a, T b) {
  return (a < b ? a : b);
}
template <class T>
T _swap(T& a, T& b) {
  a = a ^ b;
  b = a ^ b;
  a = a ^ b;
}
template <class T>
T gcd(T a, T b) {
  return (b == 0 ? a : gcd(b, a % b));
}
template <class T>
T lcm(T a, T b) {
  return (a / gcd(a, b) * b);
}
int main() {
  int n;
  while (~scanf("%d", &n)) {
    int a[n + 1], b[n + 1], c[n + 1];
    map<int, int> a1;
    map<int, int> b1;
    map<int, int> c1;
    a1.clear();
    b1.clear();
    c1.clear();
    for (int i = 0; i < n; i++) {
      scanf("%d", &a[i]);
      a1[a[i]]++;
    }
    for (int i = 0; i < n - 1; i++) {
      scanf("%d", &b[i]);
      b1[b[i]]++;
    }
    for (int i = 0; i < n - 2; i++) {
      scanf("%d", &c[i]);
      c1[c[i]]++;
    }
    for (int i = 0; i < n; i++) {
      int t = a[i];
      if (b1[t] < a1[t]) {
        printf("%d\n", t);
        break;
      }
    }
    for (int i = 0; i < n; i++) {
      int t = a[i];
      if (c1[t] < b1[t]) {
        printf("%d\n", t);
        break;
      }
    }
  }
  return 0;
}
