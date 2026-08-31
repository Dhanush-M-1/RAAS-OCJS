#include <iostream>
#include <cstdio>
#include <vector>
#include <set>
#include <map>
#include <queue>
#include <deque>
#include <stack>
#include <algorithm>
#include <cstring>
#include <functional>
#include <cmath>
using namespace std;
#define rep(i,n) for(int i=0;i<(n);++i)
#define rep1(i,n) for(int i=1;i<=(n);++i)
#define all(c) (c).begin(),(c).end()
#define fs first
#define sc second
#define pb push_back
#define show(x) cout << #x << " " << x << endl
struct cl{int v[4],x,y;};
int dx[9]={0,0,0,0,0,1,-1,2,-2};
int dy[9]={0,1,-1,2,-2,0,0,0,0};
int valid(int x,int y){
	return 0<=x&&x<3&&0<=y&&y<3;
}
bool operator<(const cl& x,const cl& y){
	rep(i,4) if(x.v[i]!=y.v[i]) return x.v[i]<y.v[i];
	return x.x*4+x.y<y.x*4+y.y;
}
bool operator==(const cl& x,const cl& y){
	rep(i,4) if(x.v[i]!=y.v[i]) return false;
	return x.x*4+x.y==y.x*4+y.y;
}
int main(){
	while(true){
		int N;
		cin>>N;
		if(N==0) break;
		cl be;
		rep(i,4) be.v[i]=0;
		be.x=1,be.y=1;
		vector<cl> vc,nvc;
		vc.pb(be);
		rep(i,N){
			int f[4][4];
			rep(j,4) rep(k,4) cin>>f[j][k];
			for(auto cloud:vc){
				int v[4];
				rep(j,4) v[j]=cloud.v[j]+1;
				int x=cloud.x,y=cloud.y;
				if(x==0&&y==0) v[0]=0;
				if(x==0&&y==2) v[1]=0;
				if(x==2&&y==0) v[2]=0;
				if(x==2&&y==2) v[3]=0;
				bool can=true;
				rep(ii,2) rep(jj,2) if(f[x+ii][y+jj]) can=false;
				rep(j,4) if(v[j]==7) can=false;
				if(!can) continue;
				rep(j,9){
					int nx=x+dx[j],ny=y+dy[j];
					if(!valid(nx,ny)) continue;
					cl hoge;
					rep(k,4) hoge.v[k]=v[k];
					hoge.x=nx,hoge.y=ny;
					nvc.pb(hoge);
				}
			}
			sort(all(nvc));
			nvc.erase(unique(all(nvc)),nvc.end());
			vc=nvc;
			nvc.clear();
//			show(vc.size());
		}
		cout<<(vc.size()?1:0)<<endl;
	}
}