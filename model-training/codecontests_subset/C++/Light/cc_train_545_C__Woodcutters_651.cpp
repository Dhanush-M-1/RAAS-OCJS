#include <bits/stdc++.h>
using namespace std;
struct node {
  int x, h;
} p[100010];
bool cmp(node a, node b) { return a.x < b.x; }
int main() {
  int n;
  cin >> n;
  if (n == 1)
    cout << 1 << endl;
  else {
    for (int i = 0; i < n; i++) {
      cin >> p[i].x >> p[i].h;
    }
    sort(p, p + n, cmp);
    long long ans = 2;
    for (int i = 1; i < n - 1; i++) {
      if (p[i].h < (p[i].x - p[i - 1].x)) {
        ans++;
      } else if (p[i].h < (p[i + 1].x - p[i].x)) {
        ans++;
        p[i].x += p[i].h;
      }
    }
    cout << ans << endl;
  }
  return 0;
}
