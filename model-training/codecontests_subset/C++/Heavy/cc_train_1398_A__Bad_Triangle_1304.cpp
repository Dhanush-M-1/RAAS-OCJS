#include <bits/stdc++.h>
using namespace std;
#pragma warning(disable : 4996)
long long mod = 1e9 + 7;
const int N = 5e4 + 10;
int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};
long long T, n, m, x, y, z, ans, tem, cnt;
struct node {
  long long id, v;
};
node a[N];
int cmp(node a, node b) { return a.v < b.v; }
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> T;
  while (T--) {
    cin >> n;
    for (int i = 1; i <= n; i++) {
      cin >> a[i].v;
      a[i].id = i;
    }
    sort(a + 1, a + n + 1, cmp);
    if (a[n].v >= a[1].v + a[2].v) {
      cout << a[1].id << " " << a[2].id << " " << a[n].id << "\n";
    } else
      cout << "-1\n";
  }
}
