#define _USE_MATH_DEFINES
#include <bits/stdc++.h>
using namespace std;

//template
#define rep(i,a,b) for(int i=(a);i<(b);i++)
#define rrep(i,a,b) for(int i=(a);i>(b);i--)
#define ALL(v) (v).begin(),(v).end()
typedef long long int ll; typedef pair<ll, ll> P;
template<class T> inline bool chmax(T& a, T b) { if (a < b) { a = b; return 1; } return 0; }
template<class T> inline bool chmin(T& a, T b) { if (a > b) { a = b; return 1; } return 0; }
template<typename A,size_t N,typename T>void Fill(A(&array)[N],const T &val){fill((T*)array, (T*)(array+N), val);}
const int inf = INT_MAX / 2; const ll INF = LLONG_MAX / 2;
//template end



int main(){
    int x,k; scanf("%d%d",&x,&k);
    vector<P> que;
    rep(i,0,k){
    	int r; scanf("%d",&r);
    	que.push_back({r,-1});
    }
    int q; scanf("%d",&q);
    rep(i,0,q){
    	int t,a; scanf("%d%d",&t,&a);
    	que.push_back({t,a});
    }
    sort(ALL(que)); vector<int> ans;
    int pre=0,minn=0,maxx=x,drc=-1,diff=0;
    rep(i,0,que.size()){
    	int dy=que[i].first-pre; diff+=drc*dy;
    	minn=min(max(minn,-diff),x-diff);
    	maxx=min(max(maxx,-diff),x-diff);
    	if(que[i].second==-1)drc*=-1;
    	else{
    		int val=que[i].second;
    		ans.push_back(min(max(val,minn),maxx)+diff);
    	} pre=que[i].first;
    }
    rep(i,0,q)printf("%d\n",ans[i]);
    return 0;
}
