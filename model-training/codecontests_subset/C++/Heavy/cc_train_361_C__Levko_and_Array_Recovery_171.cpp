#include <bits/stdc++.h>
using namespace std;
long long A[5000 + 5], B[5000 + 5];
bool vis[5000 + 5];
int main() {
  int n, m, t, L, R, d;
  scanf("%d%d", &n, &m);
  vector<vector<int> > v(m);
  vector<vector<int> > cop(m);
  for (int i = 0; i < m; ++i) {
    scanf("%d%d%d%d", &t, &L, &R, &d);
    v[i].push_back(t);
    v[i].push_back(L);
    v[i].push_back(R);
    v[i].push_back(d);
  }
  cop = v;
  reverse(v.begin(), v.end());
  bool vale = 1;
  for (int i = 0; i < m; ++i) {
    bool entra = 0;
    if (v[i][0] == 1) {
      int izq = v[i][1], der = v[i][2], dis = v[i][3];
      entra = 1;
      for (int j = izq; j <= der; ++j) {
        if (vis[j]) {
          A[j] -= dis;
        }
      }
    } else {
      int izq = v[i][1], der = v[i][2], maxi = v[i][3];
      for (int j = izq; j <= der; ++j) {
        if (!vis[j]) {
          entra = 1;
          A[j] = maxi;
          vis[j] = 1;
        } else {
          if (A[j] >= (long long)maxi) {
            entra = 1;
            A[j] = maxi;
          }
        }
      }
    }
    if (!entra) vale = 0;
  }
  if (!vale)
    puts("NO");
  else {
    for (int i = 1; i <= n; ++i) {
      if (!vis[i]) A[i] = 0;
    }
    for (int i = 1; i <= n; ++i) {
      B[i] = A[i];
      if (abs(A[i]) > 1000000000LL) {
        puts("NO");
        return 0;
      }
    }
    for (int i = 0; i < m; ++i) {
      if (cop[i][0] == 1) {
        int izq = cop[i][1], der = cop[i][2], dis = cop[i][3];
        for (int j = izq; j <= der; ++j) {
          A[j] += dis;
        }
      } else {
        int izq = cop[i][1], der = cop[i][2], maxi = cop[i][3];
        long long maximo = A[izq];
        for (int j = izq + 1; j <= der; ++j) {
          maximo = max(maximo, A[j]);
        }
        if (maximo != maxi) vale = 0;
      }
    }
    if (!vale)
      puts("NO");
    else {
      puts("YES");
      for (int i = 1; i <= n; ++i) {
        if (i == 1)
          cout << B[i];
        else
          cout << " " << B[i];
      }
      puts("");
    }
  }
}
