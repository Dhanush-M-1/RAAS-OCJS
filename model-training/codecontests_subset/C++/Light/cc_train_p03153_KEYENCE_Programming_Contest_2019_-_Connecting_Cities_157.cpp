#include <bits/stdc++.h>
using namespace std;
typedef pair<long,long> P;
typedef pair<long,P> PP;

vector<PP> edge;
long long N,D;
vector<long long> A;
const long INF=(1L<<50);
class UF{
  vector<int> par,rank;
public:
  UF(int size){
    par.resize(size);rank.resize(size);
    for (int i = 0; i < size; i++) {
      par[i]=i;
      rank[i]=0;
    }
  }
  int find(int x){
    if(par[x]==x)return x;
    return par[x]=find(par[x]);
  }
  void unite(int x,int y){
    x=find(x);
    y=find(y);
    if(x==y)return;
    if(rank[x]<rank[y])par[x]=y;
    else{
      par[y]=x;
      if(rank[x]==rank[y])rank[x]++;
    }
  }
  bool same(int x,int y){
    return find(x)==find(y);
  }
};


void solve(long l,long r){
    if(l==r)return;
    long m=(l+r)/2;
    long mn=INF;
    int pl=-1;
    for(long i = l; i <= m; i++)
    {
        long vl=A[i]-D*i;
        if(mn>vl){
            mn=vl;
            pl=i;
        }
    }
    long pr=-1;
    mn=INF;
    for(long i=m+1;i<=r;i++){
        long vr=A[i]+D*i;
        if(mn>vr){
            mn=vr;
            pr=i;
        }
    }
    for(long i = l; i <= m; i++)
    {
        edge.push_back(PP(A[i]+A[pr]+D*(pr-i),P(i,pr)));
    }
    for(long i = m+1; i < r+1; i++)
    {
        edge.push_back(PP(A[i]+A[pl]+D*(i-pl),P(pl,i)));
    }
    solve(l,m);
    solve(m+1,r);
    return;
}


int main(){
    scanf("%lld",&N);
    scanf("%lld",&D);
    A.resize(N);
    for(int i = 0 ; i < N ; i++){
        scanf("%lld",&A[i]);
    }
    solve(0,N-1);
    sort(edge.begin(),edge.end());
    UF uf(N);
    long ret=0;
    for(auto tmp:edge){
        P p=tmp.second;
        if(!uf.same(p.first,p.second)){
            uf.unite(p.first,p.second);
            ret+=tmp.first;
        }
    }
    cout<<ret<<endl;
    return 0;
}
