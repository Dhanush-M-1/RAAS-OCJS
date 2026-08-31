#include <bits/stdc++.h>
using namespace std;
#define FOR(i,a,b) for(int i=(a);i<(b);i++)
#define REP(i,n) FOR(i,0,n)
#define ALL(v) (v).begin(),(v).end()
#define fi first
#define se second
template<typename A, typename B> inline bool chmax(A &a, B b) { if (a<b) { a=b; return 1; } return 0; }
template<typename A, typename B> inline bool chmin(A &a, B b) { if (a>b) { a=b; return 1; } return 0; }
typedef long long ll;
typedef pair<int, int> pii;
const ll INF = 1e9+100;
const ll MOD = 1e9+7;
const bool debug = 0;

int main() {
	int N;
	priority_queue<int, vector<int>, greater<int> > pq;
	
	cin >> N;
	REP(i, N) {
		int a, b;
		scanf("%d %d", &a, &b);
		pq.push(a + b);
	}
	
	vector<int> ans;
	while (pq.size() > 1) {
		int a = pq.top(); pq.pop();
		int b = pq.top(); pq.pop();
		
		if (a == b) pq.push(a + 1);
		else {
			pq.push(b);
			ans.push_back(a);
		}
	}
	if (pq.size() > 0) ans.push_back(pq.top());
	
	REP(i, ans.size()) printf("%d 0\n", ans[i], i == ans.size() - 1 ? '\n' : ' ');
	
	return 0;
}