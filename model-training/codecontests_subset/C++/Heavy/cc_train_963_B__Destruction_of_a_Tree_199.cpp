#include <bits/stdc++.h>
using namespace std;
const int MAX = 210000;
const int INF = 1000000000;
const int MOD = 1000000007;
int mod(int a, int b, int m) {
  int ret = 1;
  a %= m;
  while (b) {
    if (b & 1) ret = ret * a % m;
    b >>= 1;
    a = a * a % m;
  }
  return ret;
}
int inv(int a) { return mod(a, MOD - 2, MOD); }
int vabs(int x) { return x > 0 ? x : -x; }
int gcd(int a, int b) { return a % b ? gcd(b, a % b) : b; }
int dir[4][2] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
int son[MAX];
bool flag[MAX];
vector<int> e[MAX];
bool used[MAX];
queue<int> q;
int calcSon(int r, int pre) {
  int i;
  son[r] = 1;
  for (i = 0; i < e[r].size(); i++) {
    int v = e[r][i];
    if (v == pre || used[v]) continue;
    son[r] += calcSon(v, r);
  }
  return son[r];
}
void destruction(int r, int pre) {
  int i;
  for (i = 0; i < e[r].size(); i++) {
    int v = e[r][i];
    if (v == pre || son[v] & 1) continue;
    destruction(v, r);
  }
  printf("%d\n", r);
  for (i = 0; i < e[r].size(); i++) {
    int v = e[r][i];
    if (v == pre || !(son[v] & 1)) continue;
    destruction(v, r);
  }
}
int main() {
  int n, i, j;
  cin >> n;
  for (i = 1; i <= n; i++) {
    son[i] = 0;
    e[i].clear();
  }
  for (i = 1; i <= n; i++) {
    int p;
    scanf("%d", &p);
    if (p != 0) {
      e[p].push_back(i);
      e[i].push_back(p);
    }
  }
  if (n % 2 == 0) {
    puts("NO");
    return 0;
  }
  puts("YES");
  calcSon(1, -1);
  destruction(1, -1);
  return 0;
}
