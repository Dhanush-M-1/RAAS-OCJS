#include <bits/stdc++.h>
using namespace std;
inline char gc() {
  static char buf[100000], *p1 = buf, *p2 = buf;
  return p1 == p2 && (p2 = (p1 = buf) + fread(buf, 1, 100000, stdin), p1 == p2)
             ? EOF
             : *p1++;
}
inline long long read() {
  long long x = 0;
  char ch = getchar();
  bool positive = 1;
  for (; !isdigit(ch); ch = getchar())
    if (ch == '-') positive = 0;
  for (; isdigit(ch); ch = getchar()) x = x * 10 + ch - '0';
  return positive ? x : -x;
}
inline void write(long long a) {
  if (a < 0) {
    a = -a;
    putchar('-');
  }
  if (a >= 10) write(a / 10);
  putchar('0' + a % 10);
}
inline void writeln(long long a) {
  write(a);
  puts("");
}
inline void wri(long long a) {
  write(a);
  putchar(' ');
}
long long rnd() {
  unsigned long long ans = 0;
  for (int i = (int)(0); i <= (int)(4); i++) ans = ans << 15 ^ rand();
  return ans % ((unsigned long long)1 << 63);
}
const int N = 100005, inf = 1e9;
vector<int> v[N], e[N];
bitset<N> zh, vis, vi;
int f, rt, dep[N], q[N];
pair<long long, long long> fz[N];
bool cmp(int x, int y) { return dep[x] < dep[y]; }
int Min(int x, int y) { return cmp(x, y) ? x : y; }
pair<long long, long long> operator+(pair<long long, long long> a,
                                     pair<long long, long long> b) {
  if (cmp(a.first, b.first))
    return make_pair(a.first, Min(a.second, b.first));
  else
    return make_pair(b.first, Min(a.first, b.second));
}
void dfs(int p) {
  if (!f) return;
  zh[p] = vis[p] = 1;
  fz[p] = make_pair(p, 0);
  for (auto i : v[p])
    if (vis[i]) {
      fz[p] = fz[p] + make_pair(i, 0);
      if (!zh[i]) f = 0;
    } else {
      dep[i] = dep[p] + 1;
      dfs(i);
      fz[p] = fz[p] + fz[i];
    }
  zh[p] = 0;
}
void ddd(int p) {
  if (vi[p])
    return;
  else
    vi[p] = 1;
  for (auto i : e[p]) ddd(i);
}
int main() {
  dep[0] = inf;
  int T = read();
  while (T--) {
    int n = read(), m = read();
    for (int i = (int)(1); i <= (int)(n); i++) {
      v[i].clear();
      e[i].clear();
      vi[i] = 0;
    }
    for (int i = (int)(1); i <= (int)(m); i++) {
      int s = read(), t = read();
      v[s].push_back(t);
    }
    vector<int> ans;
    for (int i = (int)(1); i <= (int)(200); i++) {
      for (int i = (int)(1); i <= (int)(n); i++) vis[i] = 0;
      f = 1;
      int t = rt = rnd() % n + 1;
      dep[t] = 0;
      dfs(t);
      if (f) {
        for (int i = (int)(1); i <= (int)(n); i++) vi[q[i] = i] = 1;
        sort(q + 1, q + n + 1, cmp);
        for (int i = (int)(1); i <= (int)(n); i++) {
          int x = q[i];
          if (dep[fz[x].second] < dep[x] || !vi[fz[x].first]) vi[x] = 0;
        }
        for (int i = (int)(1); i <= (int)(n); i++)
          if (vi[i] == 1) ans.push_back(i);
        break;
      }
    }
    if (ans.size() * 5 < n)
      puts("-1");
    else {
      for (auto i : ans) wri(i);
      puts("");
    }
  }
}
