#include <algorithm>
#include <iostream>
#include <string>
#include <random>
#include <cassert>
#include <cstring>
#include <chrono>
#include <set>
#include <map>

using namespace std;

typedef long long ll;

struct TEdge {
  int a, b;
  ll w;
  TEdge() {}
  TEdge(int a, int b, ll w): a(a), b(b), w(w) {}
};

vector<TEdge> edges;

void AddEdges(int l, int r, const vector<ll>& a, ll d) {
  if (l + 1 == r) {
    edges.push_back(TEdge(l, r, a[l] + a[r] + d));
    return;
  }
  if (l == r) return;

  int m = (l + r) / 2;
  int bestLeft = l;
  for (int i = l; i < m; ++i) if (a[i] - d * i < a[bestLeft] - d * bestLeft) bestLeft = i;

  int bestRight = r;
  for (int i = m; i <= r; ++i) if (a[i] + d * i < a[bestRight] + d * bestRight) bestRight = i;

  for (int i = l; i < m; ++i) edges.push_back(TEdge(i, bestRight, a[i] - d * i + a[bestRight] + d * bestRight));
  for (int i = m; i <= r; ++i) edges.push_back(TEdge(bestLeft, i, a[bestLeft] - d * bestLeft + a[i] + d * i));

  AddEdges(l, m - 1, a, d);
  AddEdges(m , r, a ,d);
}

int parent[300 * 1000];

int GetRoot(int v) {
  if (parent[v] == v) return v;
  int w = GetRoot(parent[v]);
  parent[v] = w;
  return w;
}

void Unite(int v1, int v2) {
  v1 = GetRoot(v1);
  v2 = GetRoot(v2);
  if (v1 == v2) return;
  if (rand() % 2) swap(v1, v2);
  parent[v2] = v1;
}

int main()
{
  int n;
  ll d;
  cin >> n >> d;
  vector<ll> a(n);
  for (int i = 0; i < n; ++i) cin >> a[i];

  AddEdges(0, n - 1, a, d);
  sort(edges.begin(), edges.end(), [](TEdge e1, TEdge e2) { return e1.w < e2.w; });

  for (int i = 0; i < n; ++i) parent[i] = i;
  ll result = 0;
  for (auto e : edges) {
    //cerr << e.a << " " << e.b << " " << e.w << endl;
    if (GetRoot(e.a) == GetRoot(e.b)) continue;
    result += e.w;
    Unite(e.a, e.b);
  }
  cout << result << endl;

  return 0;
}
