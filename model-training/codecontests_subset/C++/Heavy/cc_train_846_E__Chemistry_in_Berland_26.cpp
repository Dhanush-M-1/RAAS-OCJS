#include <bits/stdc++.h>
using namespace std;
const int NIL = -1;
template <class T>
inline T mx(T a, T b) {
  return a > b ? a : b;
}
template <class T>
inline T mi(T a, T b) {
  return a < b ? a : b;
}
template <class T>
inline void sw(T &a, T &b) {
  T t = a;
  a = b;
  b = t;
}
template <class T>
inline T mabs(T x) {
  return x < 0 ? -x : x;
}
inline char gc() {
  char ret;
  while ((ret = getchar()) == ' ' || ret == '\n' || ret == '\t')
    ;
  return ret;
}
const int LIM = 1e5 + 10;
int n;
long long a[LIM], b[LIM];
vector<pair<int, long long> > adj[LIM];
const long long MX = 1e18;
bool dfs(int crt, long long pre, int fa) {
  vector<pair<int, long long> > &t = adj[crt];
  for (int i = 0; i < t.size(); i++)
    if (!dfs(t[i].first, t[i].second, crt)) return false;
  if (crt == 1) return a[crt] >= b[crt];
  if (b[crt] > a[crt]) {
    long long dif = b[crt] - a[crt];
    if (dif * pre < 0) return false;
    long long need = dif * pre;
    long long tmp = a[fa];
    a[crt] += dif, a[fa] -= need;
    if (a[fa] > tmp) return false;
    return true;
  } else if (b[crt] < a[crt]) {
    long long dif = a[crt] - b[crt];
    long long tmp = a[fa];
    a[crt] -= dif, a[fa] += dif;
    if (a[fa] < tmp) return false;
    return true;
  }
  return true;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL), cout.tie(NULL);
  cin >> n;
  for (int i = 1; i <= n; i++) cin >> a[i];
  for (int i = 1; i <= n; i++) cin >> b[i];
  int v;
  long long w;
  for (int i = 2; i <= n; i++) {
    cin >> v >> w;
    adj[v].push_back(make_pair(i, w));
  }
  cout << (dfs(1, 0, -1) ? "YES" : "NO");
  return 0;
}
