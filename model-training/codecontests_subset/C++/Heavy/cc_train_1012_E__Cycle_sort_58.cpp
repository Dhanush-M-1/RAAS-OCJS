#include <bits/stdc++.h>
using namespace std;
int N, S, cnt;
int A[200005], A2[200005];
bool Use[200005];
int P[200005];
map<int, int> X;
int cyc, R[200005], TT[200005];
vector<int> V[200005], Cycle[200005];
void Read() {
  scanf("%d%d", &N, &S);
  for (int i = 1; i <= N; i++) {
    scanf("%d", &A[i]);
    A2[i] = A[i];
  }
  sort(A + 1, A + N + 1);
}
void rebuildA() {
  cnt = 0;
  for (int i = 1; i <= N; i++) {
    if (A[i] != A[i - 1]) cnt++;
    X[A[i]] = cnt;
  }
  for (int i = 1; i <= N; i++) {
    A[i] = X[A[i]];
    A2[i] = X[A2[i]];
    if (A[i] == A2[i]) {
      P[i] = i;
      Use[i] = 1;
    }
  }
  for (int i = 1; i <= N; i++) {
    if (P[i] == 0) V[A2[i]].push_back(i);
  }
  int curr = 1;
  for (int i = 1; i <= cnt; i++) {
    for (int j = 0; j < V[i].size(); j++) {
      int pos = V[i][j];
      while (Use[curr] == 1) ++curr;
      Use[curr] = 1;
      P[pos] = curr;
    }
  }
}
void Unite(int x, int y) {
  if (x == y) return;
  if (R[x] < R[y]) {
    TT[x] = y;
  } else
    TT[y] = x;
  if (R[x] == R[y]) ++R[x];
}
int Father(int x) {
  int init = x;
  while (x != TT[x]) {
    x = TT[x];
  }
  while (init != x) {
    int next = TT[init];
    TT[init] = x;
    init = next;
  }
  return x;
}
void buildCycle(int ind) {
  cyc = 0;
  for (int i = 1; i <= N; i++) {
    Use[i] = 0;
    Cycle[i].clear();
  }
  for (int i = 1; i <= N; i++) {
    if (P[i] == i) continue;
    if (Use[i] == 0) {
      ++cyc;
      int pos = i;
      while (Use[pos] == 0) {
        Use[pos] = 1;
        Cycle[cyc].push_back(pos);
        if (ind == 0) TT[pos] = i;
        pos = P[pos];
      }
    }
  }
}
void findP() {
  for (int i = 1; i <= cnt; i++) {
    for (int j = 1; j < V[i].size(); j++) {
      int pos = V[i][j];
      int prev = V[i][j - 1];
      if (Father(pos) != Father(prev)) {
        Unite(Father(pos), Father(prev));
        swap(P[pos], P[prev]);
      }
    }
  }
  buildCycle(1);
}
void Solve() {
  int c = 0, t = 0;
  for (int i = 1; i <= N; i++) {
    if (P[i] == i) continue;
    ++t;
    if (TT[i] == i) ++c;
  }
  if (S < t) {
    printf("-1\n");
    return;
  }
  int x, y;
  y = min(c, S - t);
  x = c - y;
  printf("%d\n", x + min(y, 2));
  if (y <= 1) x = c;
  for (int i = 1; i <= x; i++) {
    printf("%d\n", (int)Cycle[i].size());
    for (int j = 0; j < Cycle[i].size(); j++) {
      printf("%d ", Cycle[i][j]);
    }
    printf("\n");
  }
  if (y >= 2) {
    int sum = 0;
    for (int i = x + 1; i <= cyc; i++) {
      sum += (int)Cycle[i].size();
    }
    printf("%d\n", sum);
    for (int i = x + 1; i <= cyc; i++) {
      for (int j = 0; j < Cycle[i].size(); j++) printf("%d ", Cycle[i][j]);
    }
    printf("\n");
    printf("%d\n", y);
    for (int i = cyc; i >= x + 1; i--) printf("%d ", Cycle[i][0]);
    printf("\n");
  }
}
int main() {
  Read();
  rebuildA();
  buildCycle(0);
  findP();
  Solve();
  return 0;
}
