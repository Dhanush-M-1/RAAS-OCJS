#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 5;
const int inf = 21474846495;
void read(int &x) {
  char ch;
  bool flag = 0;
  for (ch = getchar(); !isdigit(ch) && ((flag |= (ch == '-')) || 1);
       ch = getchar())
    ;
  for (x = 0; isdigit(ch); x = (x << 1) + (x << 3) + ch - 48, ch = getchar())
    ;
  x *= 1 - 2 * flag;
}
int s1[maxn], s2[maxn];
long long sum[maxn][2];
int n, k, a, b, q;
int lob(int x) { return x & (-x); }
void update(int x, int val, int cnt) {
  while (x <= n) {
    sum[x][cnt] += val;
    x += lob(x);
  }
}
int query(int id, int cnt) {
  int ans = 0;
  while (id) {
    ans += sum[id][cnt];
    id -= lob(id);
  }
  return ans;
}
int main() {
  cin >> n >> k >> a >> b >> q;
  for (int i = 0; i < q; i++) {
    int c;
    cin >> c;
    if (c == 1) {
      int d, cost;
      cin >> d >> cost;
      int t1 = a - s1[d];
      if (t1 >= cost)
        s1[d] += cost, t1 = cost;
      else
        s1[d] = a;
      update(d, t1, 0);
      int t2 = b - s2[d];
      if (t2 >= cost)
        s2[d] += cost, t2 = cost;
      else
        s2[d] = b;
      update(d, t2, 1);
    } else {
      int d;
      cin >> d;
      int ans = query(d - 1, 1) + query(n, 0) - query(min(d + k - 1, n), 0);
      cout << ans << endl;
    }
  }
  return 0;
}
