#include <bits/stdc++.h>
using namespace std;
template <typename T>
inline void read(T &n) {
  T w = 1;
  n = 0;
  char ch = getchar();
  while (!isdigit(ch) && ch != EOF) {
    if (ch == '-') w = -1;
    ch = getchar();
  }
  while (isdigit(ch) && ch != EOF) {
    n = (n << 1) + (n << 3) + (ch ^ 48);
    ch = getchar();
  }
  n *= w;
}
template <typename T>
inline void write(T x) {
  T y = 0, l = 0;
  if (x < 0) {
    x = -x;
    putchar('-');
  }
  if (!x) {
    putchar(48);
    return;
  }
  while (x) {
    y = y * 10 + x % 10;
    x /= 10;
    l++;
  }
  while (l) {
    putchar(y % 10 + 48);
    y /= 10;
    l--;
  }
}
template <typename T>
inline void writeln(T x) {
  write(x);
  puts("");
}
template <typename T>
inline void writes(T x) {
  write(x);
  putchar(' ');
}
const int N = 1e6 + 100;
int x[N], y[N], w[N], s[N], v[N];
bool in[N * 2];
vector<pair<int, int> > e[N];
vector<int> res;
int main() {
  int n, m;
  read(n);
  read(m);
  for (int i = (1); i <= (m); i++) {
    read(x[i]);
    read(y[i]);
    w[i] = 1;
    s[x[i]]++;
    s[y[i]]++;
    e[max(x[i], y[i])].push_back(make_pair(min(x[i], y[i]), i));
  }
  for (int i = (1); i <= (n); i++) {
    for (int it = (0); it <= (int(e[i].size()) - 1); it++) {
      if (!v[e[i][it].first]) {
        v[e[i][it].first] = 1;
        w[e[i][it].second] = 0;
        s[i]--;
      }
      in[s[e[i][it].first]] = 1;
    }
    for (int it = (0); it <= (int(e[i].size()) - 1); it++) {
      if (!in[s[i]]) break;
      s[i]++;
      v[e[i][it].first] = 0;
      w[e[i][it].second]++;
    }
    for (int it = (0); it <= (int(e[i].size()) - 1); it++)
      in[s[e[i][it].first]] = 0;
  }
  for (int i = (1); i <= (n); i++)
    if (v[i]) res.push_back(i);
  writeln(int(res.size()));
  for (int it = (0); it <= (int(res.size()) - 1); it++) writes(res[it]);
  puts("");
  for (int i = (1); i <= (m); i++) {
    writes(x[i]);
    writes(y[i]);
    writeln(w[i]);
  }
  return 0;
}
