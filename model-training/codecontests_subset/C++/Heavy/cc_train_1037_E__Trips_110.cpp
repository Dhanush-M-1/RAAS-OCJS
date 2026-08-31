#include <bits/stdc++.h>
using namespace std;
const int MAXN = 200005;
int N, M, K;
int A[MAXN];
int B[MAXN];
set<int> adj[MAXN];
int deg[MAXN];
set<pair<int, int> > st;
bool inGraph[MAXN];
int ans[MAXN];
void update(int x) {
  if (!inGraph[x]) return;
  set<pair<int, int> >::iterator it = st.find(make_pair(deg[x], x));
  st.erase(it);
  deg[x]--;
  st.insert(make_pair(deg[x], x));
}
void fix() {
  while (!st.empty() && st.begin()->first < K) {
    int cur = st.begin()->second;
    st.erase(st.begin());
    inGraph[cur] = false;
    for (auto nxt : adj[cur]) {
      adj[nxt].erase(cur);
      update(nxt);
    }
    adj[cur].clear();
  }
}
int main() {
  scanf("%d %d %d", &N, &M, &K);
  for (int i = 0; i < M; i++) {
    scanf("%d %d", &A[i], &B[i]);
    deg[A[i]]++;
    deg[B[i]]++;
    adj[A[i]].insert(B[i]);
    adj[B[i]].insert(A[i]);
  }
  for (int i = 1; i <= N; i++) {
    st.insert(make_pair(deg[i], i));
    inGraph[i] = true;
  }
  for (int i = M - 1; i >= 0; i--) {
    fix();
    ans[i] = st.size();
    adj[A[i]].erase(B[i]);
    adj[B[i]].erase(A[i]);
    if (inGraph[B[i]]) update(A[i]);
    if (inGraph[A[i]]) update(B[i]);
  }
  for (int i = 0; i < M; i++) printf("%d\n", ans[i]);
  return 0;
}
