#include <bits/stdc++.h>
using namespace std;
const int N = 100500;
bool was[N];
int main() {
  srand(time(NULL));
  int n, m;
  cin >> n >> m;
  for (int i = 1; i <= n; i++) {
    int kol = 0;
    cin >> kol;
    for (int j = 1; j <= kol; j++) {
      int x;
      cin >> x;
      was[x] = true;
    }
  }
  for (int i = 1; i <= m; i++) {
    if (!was[i]) cout << "NO", exit(0);
  }
  cout << "YES";
  return 0;
}
