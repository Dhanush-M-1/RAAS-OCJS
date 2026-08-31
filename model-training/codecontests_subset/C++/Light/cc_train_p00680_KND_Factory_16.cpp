#include <iostream>
#include <iomanip>
#include <sstream>
#include <cstdio>
#include <string>
#include <vector>
#include <algorithm>
#include <complex>
#include <cstring>
#include <cstdlib>
#include <cmath>
#include <cassert>
#include <climits>
#include <queue>
#include <set>
#include <map>
#include <valarray>
#include <bitset>
#include <stack>
using namespace std;

#define REP(i,n) for(int i=0;i<(int)n;++i)
#define FOR(i,c) for(__typeof((c).begin())i=(c).begin();i!=(c).end();++i)
#define ALL(c) (c).begin(), (c).end()
typedef long long ll;
typedef pair<int,int> pii;
const int INF = 1<<29;
const double PI = acos(-1);
const double EPS = 1e-8;

typedef vector<double> vec;
typedef vector<vec> mat;

ostream &operator<<(ostream &os, const vec &a) {
  FOR(it, a) os << setw(6) << *it << " ";
  return os;
}
ostream &operator<<(ostream &os, const mat &a) {
  FOR(it, a) os << *it << endl;
  return os;
}

bool GaussElimination(const mat &A, const vec &b, vec &res) {
  int n = A.size();
  mat B(n, vec(n+1));
  REP(i,n) REP(j,n)
    B[i][j] = A[i][j];
  REP(i, n) B[i][n] = b[i];
  
  int nowy = 0;
  REP(x, n) {
    int pivot = -1;
    for (int j=nowy; j<n; ++j)
      if (B[j][x]) {
        pivot = j;break;
      }
    if (pivot == -1) continue;
    swap(B[nowy], B[pivot]);

    for (int j=nowy+1; j<n; ++j) {
      double t = B[j][x] / B[nowy][x];
      for (int k=x; k<=n; ++k)
        B[j][k] = B[j][k] - B[nowy][k] * t;
    }
    nowy++;
  }
  res.clear();
  for (int y=nowy; y<n; ++y)
    if (B[y][n])                // rank(A) != rank(A|b)
      return 0;
  if (nowy != n) {              // rank(A) == rank(A|b) != n
    return 0;
  }
  res.resize(n);
  for (int x=n-1; x>=0; --x) {
    double sum = B[x][n];
    for (int i=n-1; i>x; --i) {
      sum -= res[i] * B[x][i]; 
    }
    res[x] = sum / B[x][x];
  }
  return 1;
}

typedef double Weight;
struct Edge {
  int src, dst;
  Weight capacity, cost;
  int rev;
  Edge(int src, int dst, Weight capacity, Weight cost) :
    src(src), dst(dst), capacity(capacity), cost(cost) { }
  Edge(int src, int dst, Weight capacity, Weight cost, int rev) :
    src(src), dst(dst), capacity(capacity), cost(cost), rev(rev) { }
};
bool operator < (const Edge &e, const Edge &f) {
  return e.cost != f.cost ? e.cost > f.cost : // !!INVERSE!!
    e.src != f.src ? e.src < f.src : e.dst < f.dst;
}
typedef vector<Edge> Edges;
typedef vector<Edges> Graph;

typedef vector<Weight> Array;
typedef vector<Array> Matrix;

void add_edge2(Graph &g, int s, int d, Weight cap, Weight cost) {
  g[s].push_back(Edge(s,d,cap,cost,g[d].size()));
  g[d].push_back(Edge(d,s,0,-cost,g[s].size()-1));
}

pair<Weight, Weight> minimumCostFlow4(Graph g, int s, int t) {
  const int n = g.size();
  pair<Weight, Weight> total; // (cost, flow)
  
  vector<Weight> h(n,INF);
  h[s] = 0;
  REP(k, n) {
    bool update = 0;
    REP(i, n) {
      FOR(e,g[i]) if (e->capacity)
        if (h[e->dst] > h[e->src] + e->cost) {
          h[e->dst] = h[e->src] + e->cost;
          update = 1;
        }
    }
    if (!update) break;
  }
  
  for (int F = INF; F > 0;) { // residual flow
    vector<Weight> d(n, INF); d[s] = 0;
    vector<int> pv(n,-1), pe(n);
    priority_queue<Edge> Q;
    for (Q.push(Edge(-2,s,0,0)); !Q.empty(); ) {
      Edge e = Q.top(); Q.pop();
      if (pv[e.dst] != -1) continue;
      pv[e.dst] = e.src;
      pe[e.dst] = e.rev;
      REP(i, g[e.dst].size()) {
        Edge &f = g[e.dst][i];
        if (f.capacity > 0 && d[f.dst] > d[f.src] + f.cost + h[f.src] - h[f.dst]) {
          d[f.dst] = d[f.src] + f.cost + h[f.src] - h[f.dst];
          Q.push(Edge(f.src, f.dst, 0, d[f.dst], i));
        }
      }
    }
    if (pv[t] == -1) break;
    Weight f = F;
    for (int u = t; u != s; u = pv[u])
      f = min(f, g[pv[u]][pe[u]].capacity);
    if (!f) break;
    for (int u = t; u != s; u = pv[u]) {
      total.first += f * g[pv[u]][pe[u]].cost;
      g[pv[u]][pe[u]].capacity -= f;
      g[u][g[pv[u]][pe[u]].rev].capacity += f;
    }
    F -= f;
    total.second += f;
    REP(u,n) if (h[u] != INF) h[u] += d[u];
  }
  return total;
}

int d[100];
double f[100];

int main() {
  int T;
  cin >> T;
  while(T--) {
    int N,s,t,F;
    cin>>N>>s>>t>>F;
    mat A(N,vec(N));
    vec b(N);
    REP(i,N) {
      REP(j,N) cin>>A[i][j];
      cin>>b[i];
    }
    vec temp;
    assert(GaussElimination(A,b,temp));

    Graph g(N+1);
    
    REP(i,N) {
      int M;
      cin >> M;
      
      REP(j,M) cin >> d[j];
      REP(j,M) cin >> f[j];
      REP(j,M) {
        add_edge2(g,i,d[j],f[j],abs(temp[i]-temp[d[j]]));
        //printf("%.10f %.10f\n", f[j], abs(temp[i]-temp[d[j]]));
      }
    }
    
    add_edge2(g,N,s,F,0);

    pair<Weight,Weight> p = minimumCostFlow4(g,N,t);
    //cout << p.first << " " << p.second << endl;
    if (p.second >F-EPS) {
      printf("%.10f\n", p.first);
    } else {
      puts("impossible");
    }
  }
}