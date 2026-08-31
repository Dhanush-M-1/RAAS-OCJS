#include <bits/stdc++.h>
using namespace std;
ifstream f("1.in");
int n, m, a, b, t;
int da[200050], db[200050];
bool usedb[200050], useda[200050];
vector<int> v[200050];
long long ans[3];
void dfsa(int x) {
  useda[x] = 1;
  ans[1]++;
  for (auto y : v[x])
    if (!useda[y] && y != b) dfsa(y);
}
void dfsb(int x) {
  usedb[x] = 1;
  ans[2]++;
  for (auto y : v[x])
    if (!usedb[y] && y != a) dfsb(y);
}
int main() {
  cin >> t;
  while (t--) {
    ans[1] = ans[2] = 0;
    cin >> n >> m >> a >> b;
    for (int i = 1; i <= n; i++) useda[i] = usedb[i] = 0;
    for (int i = 1; i <= n; i++) v[i].clear();
    int x, y;
    while (m--) {
      cin >> x >> y;
      v[x].push_back(y);
      v[y].push_back(x);
    }
    dfsa(a);
    dfsb(b);
    cout << (n - ans[1] - 1) * (n - ans[2] - 1) << '\n';
  }
  return 0;
}
