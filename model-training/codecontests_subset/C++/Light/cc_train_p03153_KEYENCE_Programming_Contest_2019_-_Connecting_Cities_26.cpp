#include <iostream>
#include <utility>
#include <queue>
#include <stdlib.h>
#define llint long long
#define inf 1e18

using namespace std;
typedef pair<llint, llint> P;

llint n, d;
llint a[200005];
priority_queue< P, vector<P>, greater<P> > Q;
llint l[200005], r[200005];

int main(void)
{
	cin >> n >> d;
	for(int i = 1; i <= n; i++) cin >> a[i];
	a[0] = a[n+1] = inf;
	for(int i = 1; i <= n; i++){
		l[i] = i-1, r[i] = i+1;
	}
	
	llint ans = 0;
	for(int i = 1; i <= n; i++) Q.push(make_pair(a[i], i));
	while(Q.size()){
		llint p = Q.top().second;
		Q.pop();
		
		if(l[p] > 0 && l[p] <= n){
			ans += d + a[p] + a[l[p]];
			a[l[p]] = min(a[p]+d, a[l[p]]);
			r[l[p]] = 0;
			Q.push(make_pair(a[l[p]], l[p]));
			a[p] = min(a[p], a[l[p]]+d);
			l[p] = 0;
			Q.push(make_pair(a[p], p));
		}
		else if(r[p] > 0 && r[p] <= n){
			ans += d + a[p] + a[r[p]];
			a[r[p]] = min(a[p]+d, a[r[p]]);
			l[r[p]] = 0;
			Q.push(make_pair(a[r[p]], r[p]));
			a[p] = min(a[p], a[r[p]]+d);
			r[p] = 0;
			Q.push(make_pair(a[p], p));
		}
	}
	cout << ans << endl;
	
	return 0;
}