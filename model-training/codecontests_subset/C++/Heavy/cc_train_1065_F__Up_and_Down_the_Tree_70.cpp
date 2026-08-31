#include <bits/stdc++.h>
int debugnum = 0;
using namespace std;
const int MAXN = 1e6 + 50;
vector<int> arc[MAXN];
int DFS(int K, int pos, int &depth, int &score1, int &score2) {
  if (arc[pos].size() == 0) {
    depth = score1 = score2 = 1;
    return 0;
  }
  depth = INT_MAX >> 1;
  score1 = 0;
  score2 = 0;
  for (int i = (0); i < (arc[pos].size()); i++) {
    int e = arc[pos][i];
    int dep, s1, s2;
    DFS(K, e, dep, s1, s2);
    if (dep <= K) {
      depth = min(depth, dep);
      score1 += s1;
      score2 = max(score2, s2 - s1);
    } else
      score2 = max(score2, s2);
  }
  depth++;
  score2 += score1;
  return 0;
}
int main() {
  int N, M, K;
  while (cin >> N >> K) {
    for (int i = (0); i < (N + 5); i++) arc[i].clear();
    for (int b = (2); b < (N + 1); b++) {
      int a;
      scanf("%d", &a);
      arc[a].push_back(b);
    }
    int depth, score1, score2;
    DFS(K, 1, depth, score1, score2);
    cout << score2 << endl;
  }
  return 0;
}
