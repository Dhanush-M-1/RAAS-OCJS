#include <bits/stdc++.h>
using namespace std;
vector<int> g[212345];
bitset<212345> destroyed;
int vcant[212345];
int solve1(int nodo, int cant) {
  for (auto it = g[nodo].begin(); it != g[nodo].end(); it++)
    cant += solve1(*it, 1);
  if (cant % 2) {
    vcant[nodo] = cant;
    return 1;
  }
  destroyed.set(nodo);
  for (auto it = g[nodo].begin(); it != g[nodo].end(); it++) vcant[*it]--;
  cout << nodo + 1 << '\n';
  return 0;
}
void solve2(int nodo) {
  bool aux = !destroyed[nodo] && vcant[nodo] % 2 == 0;
  if (aux) {
    cout << nodo + 1 << '\n';
    destroyed.set(nodo);
  }
  for (auto it = g[nodo].begin(); it != g[nodo].end(); it++) {
    if (aux) vcant[*it]--;
    solve2(*it);
  }
  return;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int n, p, root;
  cin >> n;
  if (n % 2 == 0) {
    cout << "NO\n";
    return 0;
  }
  cout << "YES\n";
  for (int i = (0); i < (n); i++) {
    cin >> p;
    if (p == 0)
      root = i;
    else {
      g[p - 1].push_back(i);
    }
  }
  solve1(root, 0);
  solve2(root);
  for (int i = (0); i < (n); i++)
    if (!destroyed[i]) cout << i + 1 << '\n';
  return 0;
}
