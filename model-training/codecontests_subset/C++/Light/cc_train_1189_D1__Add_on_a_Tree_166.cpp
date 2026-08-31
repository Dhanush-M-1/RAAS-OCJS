#include <bits/stdc++.h>
using namespace std;
const long long MAX = 1e5 + 10;
long long arr[MAX];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  int n;
  cin >> n;
  for (int i = 0; i < n - 1; i++) {
    int u, v;
    cin >> u >> v;
    arr[u]++;
    arr[v]++;
  }
  for (int i = 1; i <= n; i++)
    if (arr[i] == 2) return puts("NO");
  puts("YES");
  return 0;
}
