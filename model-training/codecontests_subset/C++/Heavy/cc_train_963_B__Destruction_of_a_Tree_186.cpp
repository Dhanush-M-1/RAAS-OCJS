#include <bits/stdc++.h>
using namespace std;
template <typename T>
inline void Read(T &x) {
  char c = getchar();
  bool f = false;
  for (x = 0; !isdigit(c); c = getchar()) {
    if (c == '-') {
      f = true;
    }
  }
  for (; isdigit(c); c = getchar()) {
    x = x * 10 + c - '0';
  }
  if (f) {
    x = -x;
  }
}
template <typename T>
inline bool CheckMax(T &a, const T &b) {
  return a < b ? a = b, true : false;
}
template <typename T>
inline bool CheckMin(T &a, const T &b) {
  return a > b ? a = b, true : false;
}
const int N = 200005;
int n, h, r, t, d[N], p[N], ans[N];
vector<int> seq, adj[N];
inline void DFS(int x) {
  seq.push_back(x);
  for (auto y : adj[x]) {
    DFS(y);
  }
}
int main() {
  Read(n), t = n + 1;
  if (!(n & 1)) {
    puts("NO");
    return 0;
  }
  puts("YES");
  for (int i = 1; i <= n; ++i) {
    Read(p[i]);
    if (p[i]) {
      adj[p[i]].push_back(i), ++d[i], ++d[p[i]];
    } else {
      r = i;
    }
  }
  DFS(r);
  reverse(seq.begin(), seq.end());
  for (auto x : seq) {
    if (d[x] & 1) {
      ans[--t] = x;
    } else {
      ans[++h] = x, --d[p[x]];
    }
  }
  for (int i = 1; i <= n; ++i) {
    printf("%d\n", ans[i]);
  }
  return 0;
}
