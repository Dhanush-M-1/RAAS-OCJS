#include <bits/stdc++.h>
using namespace std;
const long long int INF = (1LL << 58);
const bool DEBUG = 0;
const int MAX_LIMIT = 1003;
int color[MAX_LIMIT], pos[MAX_LIMIT], componentSize[MAX_LIMIT];
std::vector<int> adj[MAX_LIMIT];
bool vis[MAX_LIMIT];
int currColor;
int globalColor = 1;
int nodes, nodeId;
set<int> ans;
bool done[MAX_LIMIT][MAX_LIMIT];
int before[MAX_LIMIT];
int dfs(int node, int currRank) {
  if (vis[node]) return 0;
  vis[node] = 1;
  color[node] = currColor;
  pos[node] = currRank;
  int i, limit = adj[node].size();
  if (DEBUG) {
    cerr << node << " " << currColor << "\n";
  }
  int ret = 0;
  for (i = 0; i < limit; i++) {
    int v = adj[node][i];
    ret += dfs(v, currRank + 1);
  }
  return ret + 1;
}
void rec(int ind, int currSum) {
  if (ind == globalColor) {
    ans.insert(currSum + pos[nodeId]);
    return;
  }
  if (done[ind][currSum]) return;
  done[ind][currSum] = 1;
  rec(ind + 1, currSum);
  if (ind != color[nodeId]) {
    rec(ind + 1, currSum + componentSize[ind]);
  }
  return;
}
int main() {
  int i, j;
  scanf("%d", &nodes);
  scanf("%d", &nodeId);
  for (i = 1; i < nodes + 1; i++) {
    int x;
    scanf("%d", &x);
    adj[x].push_back(i);
    before[i] = x;
  }
  for (i = 1; i < nodes + 1; i++) {
    if (before[i] == 0) {
      currColor = globalColor;
      componentSize[globalColor] = dfs(i, 1);
      globalColor++;
    }
  }
  rec(1, 0);
  set<int>::iterator itr;
  for (itr = ans.begin(); itr != ans.end(); itr++) {
    printf("%d\n", *itr);
  }
  return 0;
}
