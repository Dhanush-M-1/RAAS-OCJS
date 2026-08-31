#include<stdio.h>
#include<map>
#include<cmath>
#include<stdlib.h>
#include<algorithm>
#include<set>
#include<vector>
#include<queue>

using namespace std;

typedef pair<int,int> pii;
typedef long long ll;

const int MX = 100005;
const int MM = 998244353;

struct EV{
	int o, t, a, ad;
	EV(int o, int t, int a, int ad):o(o), t(t), a(a), ad(ad){}
	bool operator<(EV l)const{
		return t < l.t;
	}
};

int N;
int ans[MX], D[MX];

int main()
{
	vector<EV> L;
	int X, K, Q, t, a;
	scanf("%d%d", &X, &K);
	for(int i = 1; i <= K; i++){
		scanf("%d", D+i);
		L.emplace_back(0, D[i], 0, 0);
	}
	scanf("%d", &Q);
	for(int i = 1; i <= Q; i++){
		scanf("%d%d", &t, &a);
		L.emplace_back(1, t, a, i);
	}

	sort(L.begin(), L.end());

	int l = 0, r = X, u = 0, ch = 0, b = 0;
	for(EV c : L){
		if( c.o == 0 ){
			int d = c.t - b; b = c.t;
			if( ch ){
				int v = X-(u + (r-l));
				r = max(l, r - max(0, d-v));
				u = min(X, u+d);
			}
			else{
				l = min(r, l + max(0, d - u));
				u = max(0, u-d);
			}
			ch = !ch;
		}
		else{
			int d = c.t - b, a = c.a;
			int v = u + min(r-l, max(0, a-l));
			if( !ch ){
				ans[c.ad] = max(0, v - d);
			}
			else ans[c.ad] = min(X, v + d);
		}
	}

	for(int i = 1; i <= Q; i++) printf("%d\n", ans[i]);
}
