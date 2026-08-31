#include <bits/stdc++.h>
using namespace std;
int n, m;
int D[505];
int F[1005];
vector<int> C;
int ans = 0;
void solve(int v) {
  int i = 0;
  while (C[i] != v) {
    ans = ans + D[C[i]];
    i++;
  }
  vector<int> A;
  A.push_back(v);
  for (int i = 0; i < C.size(); i++) {
    if (C[i] != v) {
      A.push_back(C[i]);
    }
  }
  C.clear();
  for (int i = 0; i < A.size(); i++) {
    C.push_back(A[i]);
  }
}
int main() {
  cin >> n >> m;
  bool used[n];
  for (int i = 0; i < n; i++) {
    cin >> D[i];
    used[i] = 0;
  }
  for (int i = 0; i < m; i++) {
    cin >> F[i];
    F[i]--;
  }
  for (int i = 0; i < m; i++) {
    int x = F[i];
    if (used[x] == 0) {
      used[x] = 1;
      C.push_back(x);
    }
  }
  for (int i = 0; i < m; i++) {
    solve(F[i]);
  }
  cout << ans;
  return 0;
}
