#include <bits/stdc++.h>
using namespace std;
int w[510];
int mm[1010];
int a[510];
bool mark[510];
int main() {
  int n, m;
  cin >> n >> m;
  for (int i = 1; i <= n; i++) {
    cin >> w[i];
  }
  for (int i = 0; i < m; i++) {
    cin >> mm[i];
  }
  int t = 0;
  for (int i = 0; i < m; i++) {
    for (int j = a[mm[i]]; j < i; j++) {
      if (i > 0 && mark[mm[j]] == 0) {
        t = t + w[mm[j]];
        mark[mm[j]] = 1;
      }
    }
    for (int k = 0; k < i; k++) {
      mark[mm[k]] = 0;
    }
    a[mm[i]] = i + 1;
  }
  cout << t;
}
