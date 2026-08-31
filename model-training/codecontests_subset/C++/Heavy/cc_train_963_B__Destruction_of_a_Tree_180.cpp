#include <bits/stdc++.h>
using namespace std;
template <class T>
inline void amin(T &x, const T &y) {
  if (y < x) x = y;
}
template <class T>
inline void amax(T &x, const T &y) {
  if (x < y) x = y;
}
template <class Iter>
void rprintf(const char *fmt, Iter begin, Iter end) {
  for (bool sp = 0; begin != end; ++begin) {
    if (sp)
      putchar(' ');
    else
      sp = true;
    printf(fmt, *begin);
  }
  putchar('\n');
}
const int MAXN = 200011;
int N;
vector<int> G[MAXN];
int P[MAXN];
int par[MAXN];
int sz[MAXN];
bool in[MAXN];
int deg[MAXN];
int even[MAXN];
vector<int> ord;
bool active(int v) { return deg[v] % 2 == 0 && even[v] == 0; }
void MAIN() {
  scanf("%d", &N);
  for (int i = 0, i_len = (N); i < i_len; ++i) scanf("%d", P + i);
  if (N & 1) {
    for (int i = 0, i_len = (N); i < i_len; ++i)
      if (P[i]) {
        int w = P[i] - 1;
        G[i].push_back(w);
        G[w].push_back(i);
      }
    ord.reserve(N);
    ord.push_back(0);
    for (int i_ = 0, i__len = (N); i_ < i__len; ++i_) {
      int v = ord[i_];
      for (__typeof((G[v]).begin()) e = (G[v]).begin(), e_end = (G[v]).end();
           e != e_end; ++e)
        if (*e != par[v]) {
          ord.push_back(*e);
          par[*e] = v;
        }
    }
    for (int i_ = 0, i__len = (N); i_ < i__len; ++i_) {
      int v = ord[N - 1 - i_];
      sz[v] = 1;
      for (__typeof((G[v]).begin()) e = (G[v]).begin(), e_end = (G[v]).end();
           e != e_end; ++e)
        if (*e != par[v]) {
          sz[v] += sz[*e];
          deg[v]++;
          if (sz[*e] % 2 == 0) even[v]++;
        }
      if (v) {
        deg[v]++;
        if (sz[v] % 2 == 1) even[v]++;
      }
    }
    stack<int> st;
    vector<int> ans;
    for (int i = 0, i_len = (N); i < i_len; ++i)
      if (active(i)) {
        in[i] = true;
        st.push(i);
      }
    while (!st.empty()) {
      int v = st.top();
      st.pop();
      if (!active(v)) {
        in[v] = false;
        continue;
      }
      ans.push_back(v);
      for (__typeof((G[v]).begin()) e = (G[v]).begin(), e_end = (G[v]).end();
           e != e_end; ++e) {
        deg[*e]--;
        even[*e]--;
        if (!in[*e] && active(*e)) {
          in[*e] = true;
          st.push(*e);
        }
      }
    }
    if ((int)ans.size() == N) {
      puts("YES");
      for (int i = 0, i_len = (N); i < i_len; ++i) printf("%d\n", ans[i] + 1);
    } else {
      puts("NO");
    }
  } else {
    puts("NO");
  }
}
int main() {
  int TC = 1;
  for (int tc = 0, tc_len = (TC); tc < tc_len; ++tc) MAIN();
  return 0;
}
