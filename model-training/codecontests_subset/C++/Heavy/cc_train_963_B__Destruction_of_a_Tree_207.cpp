#include <bits/stdc++.h>
using namespace std;
vector<int> v[200009];
vector<int> vv;
deque<int> dq;
bool be_ve[200009], af_ve[200009];
void dfs(int i, int p) {
  int be = 0, af = 0;
  for (auto j : v[i]) {
    if (j != p) {
      dfs(j, i);
      if (be_ve[j]) {
        be++;
      } else {
        af++;
      }
    }
  }
  if (af % 2 == 0) {
    af_ve[i] = 1;
  } else {
    be_ve[i] = 1;
  }
}
void dfs_a(int i, int p) {
  int be = 0, af = 0;
  for (auto j : v[i]) {
    if (j != p) {
      if (be_ve[j]) {
        dq.push_front(j);
      } else {
        dq.push_back(j);
      }
      dfs_a(j, i);
    }
  }
}
int main() {
  int n, i, j, x, y;
  scanf("%d", &n);
  for (i = 1; i <= n; i++) {
    scanf("%d", &x);
    if (x != 0) {
      v[i].push_back(x);
      v[x].push_back(i);
    }
  }
  dq.push_back(1);
  dfs(1, 0);
  if (af_ve[1]) {
    dfs_a(1, 0);
    cout << "YES"
         << " ";
    ;
    cout << endl;
    for (auto j : dq) {
      printf("%d\n", j);
      ;
    }
  } else {
    cout << "NO"
         << " ";
    ;
  }
}
