#include <bits/stdc++.h>
using namespace std;
int n;
vector<vector<int> > a;
void Input() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin >> n;
  a.resize(n);
  for (int i = 1; i <= n - 1; i++) {
    int x, y;
    cin >> x >> y;
    x--;
    y--;
    a[x].push_back(y);
    a[y].push_back(x);
  }
}
void Process() {
  for (int i = 0; i <= n - 1; i++)
    if (a[i].size() == 2) {
      cout << "NO";
      return;
    }
  cout << "YES";
}
int main() {
  Input();
  Process();
  return 0;
}
