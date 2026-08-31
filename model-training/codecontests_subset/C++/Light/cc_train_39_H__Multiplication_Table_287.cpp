#include <bits/stdc++.h>
using namespace std;
int n;
void dfs(int x) {
  if (x == 0) return;
  dfs(x / n);
  cout << x % n;
}
int main() {
  cin >> n;
  for (int i = 1; i < n; i++) {
    for (int j = 1; j < n; j++) {
      dfs(i * j);
      cout << " ";
    }
    cout << endl;
  }
  return 0;
}
