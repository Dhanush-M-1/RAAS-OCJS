#include <bits/stdc++.h>
using namespace std;
const int MOD = int(1e9) + 7;
const long long int MOD64 = (long long int)(1e18) + 7;
const int INF = 0x7fffffff;
const long long int INF64 = 0x7fffffffffffffff;
using namespace std;
const int maxn = 1e+5;
struct abc {
  long long pos;
  long long sp;
} ver[maxn * 2 + 5];
int n;
long long speed[maxn * 2 + 5];
long long tree[maxn * 2 + 5][2];
long long lowbit(long long x);
long long _get(long long x, long long which);
void updata(long long x, long long val);
long long lowbit(long long x) { return x & (-x); }
bool cmp(abc a, abc b) { return a.pos < b.pos; }
long long _get(long long x, long long which) {
  long long res = 0;
  while (x) {
    res += tree[x][which];
    x -= lowbit(x);
  }
  return res;
}
void updata(long long x, long long val) {
  while (x <= n) {
    tree[x][0]++;
    tree[x][1] += val;
    x += lowbit(x);
  }
}
int main() {
  memset(tree, 0, sizeof(tree));
  memset(speed, 0, sizeof(speed));
  cin >> n;
  for (int i = 1; i <= n; i++) cin >> ver[i].pos;
  for (int i = 1; i <= n; i++) {
    cin >> ver[i].sp;
    speed[i] = ver[i].sp;
  }
  sort(ver + 1, ver + 1 + n, cmp);
  sort(speed + 1, speed + 1 + n);
  long long m = unique(speed + 1, speed + 1 + n) - speed - 1;
  long long res = 0;
  for (int i = 1; i <= n; i++) {
    int x = lower_bound(speed + 1, speed + 1 + m, ver[i].sp) - speed;
    res += ver[i].pos * _get(x, 0) - _get(x, 1);
    updata(x, ver[i].pos);
  }
  cout << res;
  return 0;
}
