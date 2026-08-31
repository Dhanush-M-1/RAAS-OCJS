#include <bits/stdc++.h>

using namespace std;

const int INF = 1 << 29;

struct UnionFind
{
  vector< int > data;

  UnionFind(int sz)
  {
    data.assign(sz, -1);
  }

  int find(int k)
  {
    return (data[k] < 0 ? k : data[k] = find(data[k]));
  }

  void unite(int x, int y)
  {
    x = find(x);
    y = find(y);
    if(x == y) return;
    if(data[x] > data[y]) swap(x, y);
    data[x] += data[y];
    data[y] = x;
  }
};

vector< pair< int, int > > g[100001];
vector< int > leftt[100001], rightt[100001], just[100001];
vector< int > gg[100001], rgg[100001], order;
bool v[100000];
int cmp[100000];


void dfs(int idx)
{
  if(v[idx]++) return;
  for(auto &to : gg[idx]) dfs(to);
  order.push_back(idx);
}

void rdfs(int idx, int k)
{
  cmp[idx] = k;
  for(auto &to : rgg[idx]) if(cmp[to] == -1) rdfs(to, k);
}


int rec(int idx, int back = -1)
{
  if(back != -1) {
    int tmp = max(leftt[idx][back], rightt[idx][back + 1]);
    if(tmp != INF) return (tmp);
  }
  if(rightt[idx][0] == INF) {
    for(int i = 0; i < g[idx].size(); i++) {
      int to, rev;
      tie(to, rev) = g[idx][i];
      if(i == back) continue;
      just[idx][i] = rec(to, rev) + 1;
    }
    for(int i = 0; i < g[idx].size(); i++) {
      leftt[idx][i + 1] = max(leftt[idx][i], just[idx][i]);
    }
    for(int i = (int) g[idx].size() - 1; i >= 0; i--) {
      rightt[idx][i] = max(rightt[idx][i + 1], just[idx][i]);
    }
  }
  if(back == -1) return (rightt[idx][0]);
  return (max(leftt[idx][back], rightt[idx][back + 1]));
}


int main()
{
  int N, M;
  vector< pair< int, int > > edges, arcs;

  scanf("%d %d", &N, &M);

  UnionFind uf(N);

  for(int i = 0; i < M; i++) {
    int x, y, t;
    cin >> x >> y >> t;
    --x, --y;
    if(t == 1) {
      arcs.emplace_back(x, y);
      g[x].emplace_back(y, -1);
    } else {
      if(uf.find(x) == uf.find(y)) {
        cout << "Infinite" << endl;
        return (0);
      }
      uf.unite(x, y);
      edges.emplace_back(x, y);
      g[y].emplace_back(x, g[x].size());
      g[x].emplace_back(y, g[y].size() - 1);
    }
  }

  {
    for(auto &e : arcs) {
      gg[uf.find(e.first)].push_back(uf.find(e.second));
      rgg[uf.find(e.second)].push_back(uf.find(e.first));
    }
    for(int i = 0; i < N; i++) dfs(i);
    reverse(begin(order), end(order));
    memset(cmp, -1, sizeof(cmp));
    int kk = 0;
    for(auto &i : order) if(cmp[i] == -1) rdfs(i, kk++);
    if(kk != N) {
      cout << "Infinite" << endl;
      return (0);
    }
  }


  int ret = 0;
  for(int i = 0; i < N; i++) {
    int sz = g[i].size();
    just[i].assign(sz, INF);
    leftt[i].assign(sz + 1, INF);
    rightt[i].assign(sz + 1, INF);
    leftt[i][0] = rightt[i][sz] = 0;
  }
  for(int i = 0; i < N; i++) ret = max(ret, rec(i));
  cout << ret << endl;
}