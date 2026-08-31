#include <bits/stdc++.h>
using namespace std;
struct con {
  int left;
  int right;
};
con connections[300005];
vector<int> q;
vector<int> candidates;
int pos[300005];
int n, m, v, a, b, cont;
bool candidates_sort(int a, int b) { return pos[a] > pos[b]; }
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 0; i < n; i++) {
    scanf("%d", &v);
    q.push_back(v);
    pos[v] = i;
  }
  for (int i = 0; i < m; i++) {
    scanf("%d%d", &a, &b);
    if (b == q[q.size() - 1]) {
      candidates.push_back(a);
    }
    if (pos[b] > pos[a])
      connections[a].right++;
    else
      connections[a].left++;
  }
  sort(candidates.begin(), candidates.end(), candidates_sort);
  for (int c : candidates) {
    if (connections[c].right >= n - pos[c] - 1 - cont) {
      cont++;
    }
  }
  printf("%d\n", cont);
}
