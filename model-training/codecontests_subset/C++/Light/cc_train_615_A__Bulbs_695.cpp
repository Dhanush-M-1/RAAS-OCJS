#include <bits/stdc++.h>
using namespace std;
bool visited[109] = {0};
int main() {
  int n, m, i, cnt, j, x, tmp;
  bool flag = 1;
  cin >> n >> m;
  for (i = 0; i < n; i++) {
    cin >> x;
    for (j = 0; j < x; j++) {
      cin >> tmp;
      visited[tmp] = 1;
    }
  }
  flag = 1;
  for (i = 1; i <= m; i++) {
    if (visited[i] == 0) {
      flag = 0;
      break;
    }
  }
  if (flag == 1)
    cout << "YES\n";
  else
    cout << "NO\n";
  return 0;
}
