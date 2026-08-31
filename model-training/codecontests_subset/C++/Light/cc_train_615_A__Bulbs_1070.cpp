#include <bits/stdc++.h>
using namespace std;
void solveQues() {
  int n, m, a[1001], p;
  cin >> n >> m;
  memset(a, 0, sizeof(a));
  for (int i = 0; i < n; i++) {
    int x;
    cin >> x;
    while (x--) cin >> p, a[p]++;
  }
  int c = 0;
  for (int i = 1; i <= m; i++) {
    if (a[i] != 0) c++;
  }
  if (c == m)
    cout << "YES\n";
  else
    cout << "NO\n";
  return;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  ;
  solveQues();
  return 0;
}
