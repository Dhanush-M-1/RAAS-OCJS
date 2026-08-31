#include <bits/stdc++.h>
using namespace std;
const int MAXN = 300005;
int N, M;
int P[MAXN];
int pos[MAXN];
vector<int> adj[MAXN];
int cnt[MAXN];
int main() {
  scanf("%d%d", &N, &M);
  for (int i = 1; i <= N; i++) {
    scanf("%d", &P[i]);
    pos[P[i]] = i;
  }
  for (int i = 0, a, b; i < M; i++) {
    scanf("%d%d", &a, &b);
    if (pos[b] > pos[a]) {
      adj[b].push_back(a);
      cnt[a]++;
    }
  }
  int ans = 0;
  for (int i = N - 1, cur = N; i >= 1; i--)
    if (cnt[P[i]] == cur - i) {
      ans++;
      for (auto x : adj[P[i]]) cnt[x]--;
      cur--;
    }
  cout << ans << "\n";
  return 0;
}
