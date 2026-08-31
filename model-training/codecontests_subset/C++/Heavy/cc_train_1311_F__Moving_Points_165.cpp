#include <bits/stdc++.h>
#pragma GCC optimize(2)
using namespace std;
const long long INF = 1e18;
const int maxn = 1e6 + 6;
const int mod = 1e9 + 7;
const double eps = 1e-9;
inline bool read(long long &num) {
  char in;
  bool IsN = false;
  in = getchar();
  if (in == EOF) return false;
  while (in != '-' && (in < '0' || in > '9')) in = getchar();
  if (in == '-') {
    IsN = true;
    num = 0;
  } else
    num = in - '0';
  while (in = getchar(), in >= '0' && in <= '9') {
    num *= 10, num += in - '0';
  }
  if (IsN) num = -num;
  return true;
}
long long n, m;
struct node {
  int x, v;
  bool friend operator<(node a, node b) { return a.x < b.x; }
} save[maxn];
vector<int> v;
long long a[maxn], b[maxn];
int nn;
void update(long long *p, int pos, long long x) {
  while (pos <= nn) {
    p[pos] += x;
    pos += pos & -pos;
  }
}
long long GetSum(long long *p, long long x) {
  long long ans = 0;
  while (x > 0) {
    ans += p[x];
    x -= x & -x;
  }
  return ans;
}
int getid(long long x) {
  return lower_bound(v.begin(), v.end(), x) - v.begin() + 1;
}
int main() {
  read(n);
  for (int i = 1; i <= n; i++) scanf("%d", &save[i].x);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &save[i].v);
    v.push_back(save[i].v);
  }
  sort(v.begin(), v.end());
  v.erase(unique(v.begin(), v.end()), v.end());
  nn = v.size();
  sort(save + 1, save + 1 + n);
  long long ans = 0;
  for (int i = 1; i <= n; i++) {
    int id = getid(save[i].v);
    long long tempx = GetSum(b, id);
    long long tempy = GetSum(a, id);
    ans += tempx * save[i].x - tempy;
    update(b, id, 1);
    update(a, id, save[i].x);
  }
  printf("%lld\n", ans);
  return 0;
}
