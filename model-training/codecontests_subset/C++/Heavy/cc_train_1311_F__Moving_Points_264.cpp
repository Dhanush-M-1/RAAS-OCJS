#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 10;
long long int savev[maxn];
struct node {
  long long int x, v;
  node(){};
  node(long long int x, long long int v) : x(x), v(v){};
  bool operator<(const node& n) const { return x < n.x; }
} save[maxn];
map<long long int, long long int> getv;
long long int stree[maxn];
long long int vtree[maxn];
long long int n;
void add(long long int x, long long int d, long long int* tree) {
  while (x <= n) {
    tree[x] += d;
    x += (x & (-x));
  }
}
long long int sum(long long int x, long long int* tree) {
  long long int sum = 0;
  while (x > 0) {
    sum += tree[x];
    x -= (x & (-x));
  }
  return sum;
}
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) {
    scanf("%lld", &save[i].x);
  }
  for (int i = 1; i <= n; i++) {
    scanf("%lld", &save[i].v);
    savev[i] = save[i].v;
  }
  sort(savev + 1, savev + 1 + n);
  sort(save + 1, save + 1 + n);
  int vcnt = 0;
  for (int i = 1; i <= n; i++) {
    if (!getv[savev[i]]) {
      getv[savev[i]] = ++vcnt;
    }
  }
  long long int ans = 0;
  for (int i = 1; i <= n; i++) {
    node& nownode = save[i];
    long long int nowv = getv[nownode.v];
    long long int sumdis = sum(nowv, vtree);
    long long int sumsmall = sum(nowv, stree);
    ans += nownode.x * sumsmall - sumdis;
    add(nowv, nownode.x, vtree);
    add(nowv, 1, stree);
  }
  printf("%lld", ans);
}
