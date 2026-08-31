#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

using ll=long long;

struct edge{
  ll w,v,u;
};

bool edge_cmp(edge &v, edge &u){
  return v.w<u.w;
}

vector<int> al(200010);
ll n,d;

vector<edge> edges;

void rec(ll left, ll right){
  if(right-left<=1){
    return;
  }
  ll mid = (left+right)/2;

  ll leftmin = left;
  for(int i=left;i<mid;i++){
    ll t = al[i] - d*i;
    ll t2 = al[leftmin] - d*leftmin;
    if(t<t2){
      leftmin = i;
    }
  }

  ll rightmin = mid;
  for(int i=mid;i<right;i++){
    ll t = al[i] + d*i;
    ll t2 = al[rightmin] + d*rightmin;
    if(t<t2){
      rightmin = i;
    }
  }

  for(int i=left;i<mid;i++){
    edge e = {al[rightmin]+al[i]+(rightmin-i)*d, i, rightmin};
    edges.push_back(e);
  }
  for(int i=mid;i<right;i++){
    edge e = {al[leftmin]+al[i]+(i-leftmin)*d, leftmin, i};
    edges.push_back(e);
  }

  rec(left, mid);
  rec(mid, right);
}

struct UnionFind {
    vector<int> par;

    UnionFind(int n) : par(n, -1) { }
    void init(int n) { par.assign(n, -1); }

    int find(int x) {
        if (par[x] < 0) return x;
        else return par[x] = find(par[x]);
    }

    bool same(int x, int y) {
        return find(x) == find(y);
    }

    bool unite(int x, int y) {
        x = find(x); y = find(y);
        if (x == y) return false;
        if (par[x] > par[y]) swap(x, y); // merge technique
        par[x] += par[y];
        par[y] = x;
        return true;
    }

    int size(int x) {
        return -par[find(x)];
    }
};

int main(){
  cin>>n>>d;
  for(int i=0;i<n;i++){
    cin>>al[i];
  }
  rec(0, n);

  UnionFind uf(n);
  sort(edges.begin(), edges.end(), edge_cmp);
  ll res = 0;
  for(auto e:edges){
    if(uf.same(e.v, e.u)){
      continue;
    }
    res += e.w;
    uf.unite(e.u,e.v);
  }
  cout<<res<<endl;
  return 0;
}
