#include <bits/stdc++.h>
using namespace std;
vector<long long> graph[100001];
long long a[100001], b[100001];
long long k[100001];
bool flag = 0;
void dfs(long long src, long long par) {
  for (long long i = 0; i < graph[src].size(); i++) {
    if (graph[src][i] != par) dfs(graph[src][i], src);
  }
  if (src == 1) return;
  if (b[src] > a[src]) {
    long long baki = b[src] - a[src];
    b[par] = b[par] + baki;
    b[src] = a[src];
  } else if (b[src] < a[src]) {
    long long lagbe = a[src] - b[src];
    if (k[src] > ((1000000000000000000 + b[par]) / lagbe)) {
      flag = 1;
      return;
    }
    lagbe = lagbe * k[src];
    b[par] = b[par] - lagbe;
    b[src] = a[src];
  }
}
int main() {
  long long n;
  scanf("%lld", &n);
  for (long long i = 1; i <= n; i++) scanf("%lld", &b[i]);
  for (long long i = 1; i <= n; i++) scanf("%lld", &a[i]);
  for (long long i = 2; i <= n; i++) {
    long long x;
    scanf("%lld", &x);
    graph[i].push_back(x);
    graph[x].push_back(i);
    scanf("%lld", &x);
    k[i] = x;
  }
  dfs(1, 0);
  if (flag)
    printf("NO");
  else {
    if (b[1] >= a[1])
      printf("YES");
    else
      printf("NO");
  }
}
