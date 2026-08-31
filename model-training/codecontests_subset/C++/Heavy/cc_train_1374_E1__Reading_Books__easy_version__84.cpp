#include <bits/stdc++.h>
using namespace std;
const int MAX = 200005;
long long INF = 1e10;
vector<long long> books[3];
int type(int a, int b) {
  if (a && b) return 0;
  if (a) return 1;
  return 2;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int n, k, t, x, y;
  cin >> n >> k;
  for (int i = 0; i < n; i++) {
    cin >> t >> x >> y;
    if (!x && !y) continue;
    books[type(x, y)].push_back(t);
  }
  for (int i = 0; i < 3; i++) {
    sort(books[i].begin(), books[i].end());
    for (int j = books[i].size(); j < k; j++) {
      books[i].push_back(INF);
    }
  }
  long long ans, aux;
  ans = aux = 0;
  for (int i = 0; i < k; i++) aux += books[0][i];
  ans = aux;
  for (int i = 0; i < k; i++) {
    aux -= books[0][k - i - 1];
    aux += books[1][i];
    aux += books[2][i];
    ans = min(aux, ans);
  }
  if (ans >= INF)
    cout << "-1" << '\n';
  else
    cout << ans << '\n';
}
