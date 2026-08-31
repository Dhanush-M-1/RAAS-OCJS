#include <bits/stdc++.h>
using namespace std;
vector<int> N[100005];
void addE(int a, int b) {
  N[a].push_back(b);
  N[b].push_back(a);
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n, a, b;
  cin >> n;
  for (int i = 1; i < n; i++) {
    cin >> a >> b;
    addE(a - 1, b - 1);
  }
  int sz;
  for (int i = 0; i < n; i++) {
    sz = N[i].size();
    if (sz == 2) {
      cout << "NO\n";
      return 0;
    }
  }
  cout << "YES\n";
  return 0;
}
