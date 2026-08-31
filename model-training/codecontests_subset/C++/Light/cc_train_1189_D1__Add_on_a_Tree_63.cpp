#include <bits/stdc++.h>
using namespace std;
vector<int> AL[100005];
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 0; i < n - 1; i++) {
    int u, v;
    scanf("%d", &u);
    scanf("%d", &v);
    AL[u].push_back(v);
    AL[v].push_back(u);
  }
  long long int l = 0;
  int fl = 0;
  for (int i = 1; i <= n; i++) {
    if (AL[i].size() == 2) {
      fl = 1;
    }
  }
  if (fl == 0) {
    printf("YES\n");
  } else {
    printf("NO\n");
  }
  return 0;
}
