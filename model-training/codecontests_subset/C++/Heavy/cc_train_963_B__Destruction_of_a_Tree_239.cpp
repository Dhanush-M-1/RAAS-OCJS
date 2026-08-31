#include <bits/stdc++.h>
using namespace std;
void get_destructibility(int v, int par, vector<set<int> >& edges,
                         vector<bool>& is_destructible) {
  is_destructible[v] = true;
  for (int w : edges[v]) {
    if (w != par) {
      get_destructibility(w, v, edges, is_destructible);
      if (is_destructible[w]) {
        is_destructible[v] = !is_destructible[v];
      }
    }
  }
}
void get_destruction_order(int v, int par, vector<set<int> >& edges,
                           vector<bool>& is_destructible,
                           list<int>& destruction_order) {
  for (int w : edges[v]) {
    if (w != par && !is_destructible[w]) {
      get_destruction_order(w, v, edges, is_destructible, destruction_order);
    }
  }
  destruction_order.push_back(v);
  for (int w : edges[v]) {
    if (w != par && is_destructible[w]) {
      get_destruction_order(w, v, edges, is_destructible, destruction_order);
    }
  }
}
int main() {
  int n;
  cin >> n;
  vector<set<int> > edges(n);
  for (int i = 0; i < n; i++) {
    int p;
    cin >> p;
    if (p) {
      edges[i].insert(p - 1);
      edges[p - 1].insert(i);
    }
  }
  vector<bool> is_destructible(n);
  get_destructibility(0, -1, edges, is_destructible);
  if (is_destructible[0]) {
    cout << "YES\n";
    list<int> destruction_order;
    get_destruction_order(0, -1, edges, is_destructible, destruction_order);
    for (int v : destruction_order) {
      cout << v + 1 << '\n';
    }
  } else {
    cout << "NO\n";
  }
}
