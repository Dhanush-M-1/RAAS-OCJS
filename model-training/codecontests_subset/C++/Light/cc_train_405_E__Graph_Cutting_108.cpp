#include <bits/stdc++.h>
using namespace std;
const int NMAX = 100005;
int N, M, X, Y;
set<int> S[NMAX];
vector<int> V[NMAX];
bitset<NMAX> viz;
void DFS(int Node, int Father) {
  for (vector<int>::iterator it = V[Node].begin(); it != V[Node].end(); it++)
    if (!viz[*it]) {
      viz[*it] = 1;
      DFS(*it, Node);
    }
  if (S[Node].size() & 1) S[Node].erase(S[Node].find(Father));
  for (set<int>::iterator it1 = S[Node].begin(); it1 != S[Node].end(); it1++) {
    set<int>::iterator it2 = it1;
    it2++;
    printf("%d %d %d\n", *it1, Node, *it2);
    S[*it1].erase(Node);
    S[*it2].erase(Node);
    it1 = it2;
  }
}
int main() {
  scanf("%d%d", &N, &M);
  if (M & 1) {
    printf("No solution\n");
    return 0;
  }
  for (; M; M--) {
    scanf("%d%d", &X, &Y);
    V[X].push_back(Y);
    V[Y].push_back(X);
    S[X].insert(Y);
    S[Y].insert(X);
  }
  viz[1] = 1;
  DFS(1, 0);
  return 0;
}
