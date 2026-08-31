#include <bits/stdc++.h>
using namespace std;
const int N = 3e5 + 5;
const int M = 5e5 + 5;
set<int> g[N];
int Nastya;
int p[N];
int n, m;
int main() {
  ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0), cout.precision(15);
  cin >> n >> m;
  for (int i = (1); i <= ((n)); i += (+1)) {
    cin >> p[i];
  }
  Nastya = p[n];
  for (int i = (0); i <= ((m)-1); i += (+1)) {
    int u, v;
    cin >> u >> v;
    g[u].insert(v);
  }
  for (int i = (n); i >= (1); i += (-1)) {
    int j = i;
    while (j < n && g[p[j]].count(p[j + 1])) {
      swap(p[j], p[j + 1]);
      j++;
    }
  }
  for (int i = (1); i <= ((n)); i += (+1)) {
    if (p[i] == Nastya) {
      cout << n - i << '\n';
      break;
    }
  }
  return 0;
}
