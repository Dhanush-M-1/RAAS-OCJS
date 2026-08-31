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
inline unsigned long long rnd() {
  return ((unsigned long long)rand() << 30 ^ rand()) << 4 | rand() % 4;
}
vector<vector<int> > a[6], A[6];
vector<vector<vector<int> > > vis;
struct da {
  int x, y, z;
};
int cnt[200005];
vector<vector<vector<vector<da> > > > v;
int n, m, k, N[6], M[6];
da get(da jb) {
  int id = jb.x, x = jb.y, y = jb.z;
  if (id < 2)
    return (da){A[id][x][y], x, y};
  else if (id < 4)
    return (da){x, A[id][x][y], y};
  else
    return (da){x, y, A[id][x][y]};
}
void GG() {
  puts("-1");
  exit(0);
}
bool ou(int x, int l, int r) { return x < l || x > r; }
void ins(da zs);
void bao(da zs) {
  int id = zs.x, x = zs.y, y = zs.z;
  A[id][x][y] += id % 2 ? -1 : 1;
  ins(zs);
}
void erase(da zb) {
  vis[zb.x][zb.y][zb.z] = 0;
  vector<da> wzp;
  swap(wzp, v[zb.x][zb.y][zb.z]);
  for (auto i : wzp) bao(i);
}
void ins(da zs) {
  da zb = get(zs);
  int id = zs.x, x = zs.y, y = zs.z;
  if (ou(zb.x, 1, n) || ou(zb.y, 1, m) || ou(zb.z, 1, k)) {
    if (a[id][x][y]) GG();
    return;
  }
  if (vis[zb.x][zb.y][zb.z]) {
    v[zb.x][zb.y][zb.z].push_back(zs);
    if (!a[id][x][y]) erase(zb);
    set<int> s;
    for (auto i : v[zb.x][zb.y][zb.z]) s.insert(a[i.x][i.y][i.z]);
    if (s.size() == 2) erase(zb);
  } else {
    bao(zs);
  }
}
int main() {
  n = read();
  m = read();
  k = read();
  for (int i = (int)(0); i <= (int)(5); i++) {
    N[i] = i / 2 ? n : m;
    M[i] = i / 2 == 2 ? m : k;
    a[i].assign(N[i] + 2, vector<int>(M[i] + 2, 0));
    A[i].assign(N[i] + 2, vector<int>(M[i] + 2, 0));
  }
  v.resize(n + 2);
  vis.resize(n + 2);
  for (int i = (int)(1); i <= (int)(n); i++) {
    v[i].resize(m + 2);
    vis[i].resize(m + 2);
    for (int j = (int)(1); j <= (int)(m); j++) {
      v[i][j].resize(k + 2);
      vis[i][j].resize(k + 2);
    }
  }
  for (int i = (int)(0); i <= (int)(5); i++) {
    for (int j = (int)(1); j <= (int)(N[i]); j++) {
      for (int o = (int)(1); o <= (int)(M[i]); o++) {
        A[i][j][o] = i % 2 ? n + m + k - N[i] - M[i] : 1;
        a[i][j][o] = read();
      }
    }
  }
  for (int i = (int)(1); i <= (int)(n); i++)
    for (int j = (int)(1); j <= (int)(m); j++)
      for (int o = (int)(1); o <= (int)(k); o++) vis[i][j][o] = 1;
  for (int i = (int)(0); i <= (int)(5); i++) {
    for (int j = (int)(1); j <= (int)(N[i]); j++) {
      for (int o = (int)(1); o <= (int)(M[i]); o++) {
        ins((da){i, j, o});
      }
    }
  }
  for (int i = (int)(1); i <= (int)(n); i++) {
    for (int j = (int)(1); j <= (int)(m); j++) {
      for (int o = (int)(1); o <= (int)(k); o++) {
        if (v[i][j][o].size()) {
          da t = v[i][j][o][0];
          wri(a[t.x][t.y][t.z]);
        } else
          wri(0);
      }
      puts("");
    }
    puts("");
  }
}
