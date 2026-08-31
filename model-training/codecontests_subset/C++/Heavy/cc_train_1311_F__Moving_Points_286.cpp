#include <bits/stdc++.h>
using namespace std;
struct Node {
  int X, V;
  inline friend bool operator<(Node x, Node y) {
    if (x.V == y.V) {
      return x.X < y.X;
    }
    return x.V < y.V;
  }
} p[200000];
map<int, int> A;
set<int> B;
int ct;
long long c1[200001];
int c2[200001];
inline void Add(int x, int d) {
  for (register int i = x; i <= ct; i += i & -i) {
    c1[i] += d;
    c2[i]++;
  }
}
inline pair<long long, int> Get(int x) {
  int s2 = 0;
  long long s1 = 0;
  for (register int i = x; i != 0; i -= i & -i) {
    s1 += c1[i];
    s2 += c2[i];
  }
  return make_pair(s1, s2);
}
int main() {
  int n, k;
  scanf("%d", &n);
  for (register int i = 0; i != n; i++) {
    scanf("%d", &p[i].X);
    B.insert(p[i].X);
  }
  for (register int i = 0; i != n; i++) {
    scanf("%d", &p[i].V);
  }
  sort(p, p + n);
  for (set<int>::iterator T = B.begin(); T != B.end(); T++) {
    ct++;
    A[*T] = ct;
  }
  long long ans = 0;
  for (register int i = 0; i != n; i++) {
    k = A[p[i].X];
    pair<long long, int> Tem = Get(k);
    ans += (long long)p[i].X * Tem.second - Tem.first;
    Add(k, p[i].X);
  }
  printf("%lld", ans);
  return 0;
}
