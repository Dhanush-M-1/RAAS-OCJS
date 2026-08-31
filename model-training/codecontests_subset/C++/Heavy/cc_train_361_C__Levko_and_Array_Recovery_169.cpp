#include <bits/stdc++.h>
using namespace std;
inline void print(char pt) { printf("%c\n", pt); }
inline void print(int pt) { printf("%d\n", pt); }
inline void print(long long pt) { printf("%I64d\n", pt); }
inline void print(double pt) { printf("%.20f\n", pt); }
inline void print(char pt[]) { printf("%s\n", pt); }
inline void print() { printf("\n"); }
inline int scan(int &pt) { return scanf("%d", &pt); }
inline int scan(char &pt) { return scanf("%c", &pt); }
inline int scan(long long &pt) { return scanf("%I64d", &pt); }
inline int scan(double &pt) { return scanf("%lf", &pt); }
inline int scan(char pt[]) { return scanf("%s", pt); }
using namespace std;
struct pii {
  long long a, b, c, d;
} p[10000];
int n, m;
long long o[10000];
long long a[10000];
int main() {
  scan(n);
  scan(m);
  for (int i = 1; i <= n; i++) {
    o[i] = 1e9;
  }
  for (int i = 0; i < m; i++) {
    scan(p[i].a);
    scan(p[i].b);
    scan(p[i].c);
    scan(p[i].d);
  }
  for (int mm = 0; mm < m; mm++) {
    if (p[mm].a == 1) {
      for (int i = p[mm].b; i <= p[mm].c; i++) {
        a[i] += p[mm].d;
      }
    } else {
      for (int i = p[mm].b; i <= p[mm].c; i++) {
        o[i] = min(o[i], p[mm].d - a[i]);
      }
    }
  }
  memcpy(a, o, sizeof(long long) * (n + 1));
  for (int mm = 0; mm < m; mm++) {
    if (p[mm].a == 1) {
      for (int i = p[mm].b; i <= p[mm].c; i++) {
        a[i] += p[mm].d;
      }
    } else {
      long long maxa = -(1ll << 60);
      for (int i = p[mm].b; i <= p[mm].c; i++) {
        maxa = max(maxa, a[i]);
      }
      if (maxa != p[mm].d) {
        print("NO");
        exit(0);
      }
    }
  }
  print("YES");
  for (int i = 1; i <= n; i++) {
    print(o[i]);
  }
  return 0;
}
