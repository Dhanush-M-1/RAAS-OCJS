#include <bits/stdc++.h>
using namespace std;
const double Pi = acos(-1.0);
const int INF = 1 << 29;
const int MAXN = 1005;
int n, x;
int nxt[MAXN];
int prv[MAXN];
int bPos = -1;
int T[MAXN];
vector<int> L;
int traverse(int ind, int depth) {
  if (ind == x) {
    bPos = depth;
  }
  if (prv[ind] == -1) {
    return 1;
  }
  return traverse(prv[ind], depth + 1) + 1;
}
int main(int argc, char** argv) {
  scanf("%d%d", &n, &x);
  x--;
  for (int i = 0; i < n; i++) {
    prv[i] = -1;
  }
  for (int i = 0; i < n; i++) {
    scanf("%d", &nxt[i]);
    nxt[i]--;
    if (nxt[i] != -1) {
      prv[nxt[i]] = i;
    }
  }
  for (int i = 0; i < n; i++) {
    if (nxt[i] == -1) {
      int init = bPos;
      int len = traverse(i, 1);
      if (bPos == init) L.push_back(len);
    }
  }
  T[0] = 1;
  for (int i = 0; i < (int)L.size(); i++) {
    for (int j = n - 1; j >= 0; j--) {
      if (T[j] == 1 && j + L[i] < n) {
        T[j + L[i]] = 1;
      }
    }
  }
  for (int i = 0; i < n; i++) {
    if (T[i] == 1) {
      printf("%d\n", i + bPos);
    }
  }
  return 0;
}
