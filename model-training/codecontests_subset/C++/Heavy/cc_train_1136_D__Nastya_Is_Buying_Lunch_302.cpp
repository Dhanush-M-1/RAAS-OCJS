#include <bits/stdc++.h>
using namespace std;
const int maxn = 300005;
int N, M, arr[maxn], pos[maxn], bit[maxn];
bool marked[maxn], done[maxn];
vector<int> g[maxn];
inline void update(int pos, int val) {
  for (int i = pos; i <= N; i += i & -i) bit[i] += val;
}
inline int query(int pos) {
  int res = 0;
  for (int i = pos; i > 0; i -= i & -i) res += bit[i];
  return res;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cin >> N >> M;
  for (int i = 1; i <= N; i++) {
    cin >> arr[i];
    pos[arr[i]] = i;
  }
  for (int i = 1; i <= M; i++) {
    int a, b;
    cin >> a >> b;
    if (b == arr[N]) marked[a] = true;
    g[a].push_back(b);
  }
  int res = marked[arr[N - 1]];
  for (int i = N - 2; i >= 1; i--) {
    if (!marked[arr[i]]) continue;
    int req = N - res - i - 1, l = i + 1, r = N - res - 1;
    for (int ck : g[arr[i]]) {
      if (done[ck]) continue;
      int pp = pos[ck] - query(pos[ck]);
      if (pp >= l && pp <= r) req--;
    }
    if (req == 0) {
      update(i, 1);
      res++, done[arr[i]] = true;
    }
  }
  cout << res << '\n';
}
