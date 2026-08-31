#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
#define FOR(i,a,b) for(int i=(a);i<(b);i++)
#define REP(i,a) FOR(i,0,a)
const int MAX_N=2e5;
const ll INF=1e18;
int N;
int N2;
ll D;
typedef pair<ll,int> P;
ll orgA[MAX_N];
P A[MAX_N];
P seg[2][MAX_N<<2];
P query(int typ,int l,int r,int k,int a,int b){
	if (r<=a || b<=l){
		return P(INF,-1);
	}
	if (l<=a && b<=r){
		return seg[typ][k];
	}
	P lseg=query(typ,l,r,k*2+1,a,(a+b)/2),rseg=query(typ,l,r,k*2+2,(a+b)/2,b);
	return min(lseg,rseg);
}
void change(int typ,int inx,ll val){
	seg[typ][N2-1+inx]=P(val,inx);
	inx+=N2-1;
	while(1){
		if (inx==0){
			return;
		}
		inx=(inx-1)/2;
		seg[typ][inx]=min(seg[typ][inx*2+1],seg[typ][inx*2+2]);
	}
}
struct edge{
	int s,t;
	ll cst;
	edge(int s=-1,int t=-1,ll c=INF):s(s),t(t),cst(c){}
	bool operator < (const edge &e)const{
		return cst<e.cst;
	}
};
vector<edge> G;
ll calcst(int x,int y){
	return orgA[x]+orgA[y]+abs(x-y)*D;
}
int ufpar[MAX_N];
int uffnd(int v){
	if (ufpar[v]==v){
		return v;
	}
	return ufpar[v]=uffnd(ufpar[v]);
}
bool iscon(int s,int t){
	s=uffnd(s);
	t=uffnd(t);
	return s==t;
}
void ufunite(int s,int t){
	s=uffnd(s);
	t=uffnd(t);
	ufpar[s]=t;
}
int main(){
	cin>>N>>D;
	REP(i,N){
		ll a;
		cin>>a;
		orgA[i]=a;
		A[i]=P(a,i);
	}
	N2=1;
	while(N2<N) N2<<=1;
	REP(i,2){
		REP(j,N2*2-1){
			seg[i][j]=P(INF,-1);
		}
	}
	sort(A,A+N);
	REP(i,N){
		P l,r;
		l=r=P(INF,-1);
		edge el,er;
		el=er=edge(-1,-1,INF);
		if (A[i].second>0){
			l=query(0,0,A[i].second,0,0,N2);
		}
		if (A[i].second<N-1){
			r=query(1,A[i].second+1,N,0,0,N2);
		}
		if (l.second!=-1){
			G.push_back(edge(A[i].second,l.second,calcst(A[i].second,l.second)));
			el=edge(A[i].second,l.second,calcst(A[i].second,l.second));
		}
		if (r.second!=-1){
			G.push_back(edge(A[i].second,r.second,calcst(A[i].second,r.second)));
			er=edge(A[i].second,r.second,calcst(A[i].second,r.second));
		}
		change(0,A[i].second,A[i].first-A[i].second*D);
		change(1,A[i].second,A[i].first+A[i].second*D);
	}
	sort(G.begin(),G.end());
	ll ans=0;
	REP(i,N){
		ufpar[i]=i;
	}
	for(auto e:G){
		if (!iscon(e.s,e.t)){
			ufunite(e.s,e.t);
			ans+=e.cst;
		}
	}
	cout<<ans<<endl;
	return 0;
}