#include <bits/stdc++.h>
using namespace std;
typedef struct {
  int sum, suf, pre, max;
} Node;
int toint(const string &s) {
  stringstream ss;
  ss << s;
  int x;
  ss >> x;
  return x;
}
const int MAXN = 2e5 + 100;
const int UP = 31;
const long long int highest = 1e18;
const double Phi = 1.618033988749894;
const int logn = 20;
const double root5 = 2.236067977;
const long long int inf = 1e18;
const int N = 1e5 + 10;
std::vector<pair<int, int> > eds[N];
int n;
long long int b[N];
long long int a[N];
long long int mul(long long int a, long long int b) {
  if (a == 0) return 0;
  if (inf / a < b) return inf;
  return a * b;
}
long long int dfs(int v) {
  long long int have = b[v];
  long long int want = a[v];
  for (auto e : eds[v]) {
    long long int x = dfs(e.first);
    if (x < 0) {
      want = min(inf, want + mul(-x, e.second));
    } else {
      have += x;
    }
  }
  return have - want;
}
int main() {
  scanf("%d", &n);
  for (int i = 0; i < n; ++i) {
    cin >> b[i];
  }
  for (int i = 0; i < n; ++i) {
    cin >> a[i];
  }
  for (int i = 1; i < n; ++i) {
    int x, k;
    scanf("%d%d", &x, &k);
    --x;
    eds[x].push_back(make_pair(i, k));
  }
  long long int ans = dfs(0);
  if (ans < 0) {
    return !printf("NO\n");
  } else {
    return !printf("YES\n");
  }
  return 0;
}
