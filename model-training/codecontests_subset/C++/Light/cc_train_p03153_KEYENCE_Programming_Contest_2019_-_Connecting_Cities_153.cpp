#include<bits/stdc++.h>
using namespace std;

#define int long long

#define rep(i,n) for(int i=0;i<(n);i++)
#define pb push_back
#define all(v) (v).begin(),(v).end()
#define fi first
#define se second
typedef vector<int>vint;
typedef pair<int,int>pint;
typedef vector<pint>vpint;

template<typename A,typename B>inline void chmin(A &a,B b){if(a>b)a=b;}
template<typename A,typename B>inline void chmax(A &a,B b){if(a<b)a=b;}

const int INF=1001001001001001001ll;

struct UnionFindTree{
    vector<int>par,sz;
    UnionFindTree(int n){
        par.resize(n);
        sz.resize(n);
        for(int i=0;i<n;i++){
            par[i]=i;
            sz[i]=1;
        }
    }
    int find(int x){
        return x==par[x]?x:par[x]=find(par[x]);
    }
    void unite(int x,int y){
        x=find(x);y=find(y);
        if(x==y)return;
        if(sz[x]<sz[y])swap(x,y);
        sz[x]+=sz[y];
        par[y]=x;
    }
    bool areSame(int x,int y){
        return find(x)==find(y);
    }
    int size(int x){
        return sz[find(x)];
    }
};

int N,D;
int A[222222];
signed main(){
	cin>>N>>D;
	rep(i,N)cin>>A[i];

	UnionFindTree uf(N);

	int ans=0;
	while(true){
		if(uf.size(0)==N)break;
		vector<tuple<int,int,int>>uku,ushi;

		pint p(INF,-1);
		int cur=0;
		while(cur<N){
			int nex=cur;
			int mi1=INF,mi2=INF;
			while(nex<N&&uf.areSame(cur,nex)){
				chmin(mi1,nex*D+A[nex]);
				chmin(mi2,-nex*D+A[nex]);
				nex++;
			}
			uku.pb(make_tuple(p.fi+mi1,p.se,cur));
			if(p.fi>mi2)p={mi2,cur};
			cur=nex;
		}

		p={INF,-1};

		cur=N-1;
		while(cur>=0){
			int nex=cur;
			int mi1=INF,mi2=INF;
			while(nex>=0&&uf.areSame(cur,nex)){
				chmin(mi1,-nex*D+A[nex]);
				chmin(mi2,nex*D+A[nex]);
				nex--;
			}
			ushi.pb(make_tuple(p.fi+mi1,p.se,cur));
			if(p.fi>mi2)p={mi2,cur};
			cur=nex;
		}
		reverse(all(ushi));
		rep(i,uku.size()){
			tuple<int,int,int>t=min(uku[i],ushi[i]);
			int c,x,y;tie(c,x,y)=t;
			if(uf.areSame(x,y))continue;
			ans+=c;
			uf.unite(x,y);
		}
	}
	cout<<ans<<endl;
	return 0;
}