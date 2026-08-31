#include <bits/stdc++.h>
#define pb push_back
#define int long long
#define mp make_pair
#define inf 998244353
#define LINF 1000000000000000007LL
#define ll long long
using namespace std;
signed main(){
	int x,k;
	vector<int> r;
	cin>>x>>k;
	vector< pair<int,int> > ev;
	for(int i=0;i<k;i++){
		int tmp;
		cin>>tmp;
		r.pb(tmp);
		ev.pb( mp ( tmp, -1 ) );
	}
	int q; cin>>q;
	for(int i=0;i<q;i++){
		int tim, a;
		cin>>tim>>a;
		ev.pb( mp( tim, a ) );
	}
	sort(ev.begin(),ev.end());
	vector<int> ans;
	int dir = -1, con = 0, ct = 0, btm = 0, tp = x;
	for(int i=0;i<ev.size();i++){
		int et = ev[i].first - ct;
		con += dir * et;
		btm = min( max( btm, -con ), x-con);
		tp = min( max( tp, -con ), x-con);
		if( ev[i].second == -1){
			dir *= -1;
		}
		else{
			int a = ev[i].second;
			a = min( max( btm, a ), tp );
			ans.pb( a + con );
		}
		ct = ev[i].first;
	}
	for(int i=0;i<ans.size();i++){
		cout<<ans[i]<<endl;
	}
}