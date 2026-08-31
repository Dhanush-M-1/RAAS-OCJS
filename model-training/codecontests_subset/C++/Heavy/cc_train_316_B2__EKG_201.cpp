#include <bits/stdc++.h>
using namespace std;
inline int rdi() {
  int d;
  scanf("%d", &d);
  return d;
}
inline char rdc() {
  scanf(" ");
  return getchar();
}
inline string rds() {
  string s;
  cin >> s;
  return s;
}
inline double rddb() {
  double d;
  scanf("%lf", &d);
  return d;
}
template <class T>
inline bool updateMin(T& a, T b) {
  return a > b ? a = b, true : false;
}
template <class T>
inline bool updateMax(T& a, T b) {
  return a < b ? a = b, true : false;
}
const int N = 1024;
bool dp[N] = {true};
vector<int> v, ans;
int n, x, f[N], cnt[N], pre[N];
void init_UFS() {
  for (int i = (1); i <= (n); ++i) {
    f[i] = rdi();
    if (!f[i]) f[i] = i;
  }
}
int root(int x) {
  if (f[x] == x) {
    pre[x] = 1;
    return x;
  }
  int fx = f[x];
  f[x] = root(fx);
  if (!pre[x]) pre[x] = pre[fx] + 1;
  return f[x];
}
int main() {
  cin >> n >> x;
  init_UFS();
  for (int i = (1); i <= (n); ++i) ++cnt[root(i)];
  int rx = root(x);
  for (int i = (1); i <= (n); ++i)
    if (f[i] == i && i != rx) v.push_back(cnt[i]);
  int sum = 0;
  for (int i_b = (((int)(v).size())), i = (0); i < i_b; ++i) {
    for (int j = (sum); j >= (0); --j)
      if (dp[j]) dp[j + v[i]] = true;
    sum += v[i];
  }
  for (int i = (0); i < (N); ++i)
    if (dp[i]) ans.push_back(i + pre[x]);
  for (int i_b = (((int)(ans).size())), i = (0); i < i_b; ++i)
    printf("%d\n", ans[i]);
  return 0;
}
