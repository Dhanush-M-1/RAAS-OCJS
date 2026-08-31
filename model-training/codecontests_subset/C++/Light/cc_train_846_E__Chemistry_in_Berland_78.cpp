#include <bits/stdc++.h>
using namespace std;
const int SIZE = 100005;
long long int a[SIZE];
long long int b[SIZE];
long long int k[SIZE];
int parent[SIZE];
vector<int> adj[SIZE];
bool t = true;
double left(int here) {
  double ret = (double)b[here] - a[here];
  for (int i = 0; i < adj[here].size(); i++) {
    int next = adj[here][i];
    if (next == parent[here]) continue;
    double tmp = left(next);
    if (tmp > 0) ret += tmp;
    if (tmp < 0) {
      ret += k[next] * tmp;
    }
  }
  if (ret < -1e17) t = false;
  return ret;
}
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%lld", &b[i]);
  for (int j = 1; j <= n; j++) scanf("%lld", &a[j]);
  for (int i = 2; i <= n; i++) {
    scanf("%d %lld", &parent[i], &k[i]);
    adj[i].push_back(parent[i]);
    adj[parent[i]].push_back(i);
  }
  if (t && left(1) >= 0)
    printf("YES\n");
  else
    printf("NO\n");
}
