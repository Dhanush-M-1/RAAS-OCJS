#include <bits/stdc++.h>

using namespace std;

typedef long long LL;
typedef pair<int , int> P2;
typedef pair<pair<int , int> , int> P3;
typedef pair<pair<int , int> , pair<int , int> > P4;
#define PB(a) push_back(a)
#define MP(a , b) make_pair((a) , (b))
#define M3P(a , b , c) make_pair(make_pair((a) , (b)) , (c))
#define M4P(a , b , c , d) make_pair(make_pair((a) , (b)) , make_pair((c) , (d)))
#define repp(i,a,b) for(int i = (int)(a) ; i < (int)(b) ; ++i)
#define repm(i,a,b) for(int i = (int)(a) ; i > (int)(b) ; --i)

int main(){
	int N; LL D; cin >> N >> D;	
	vector<LL> A(N),r(N);
	repp(i,0,N){
		cin >> A[i];
		r[i] = i;
	}
	sort(r.begin(),r.end(),[&](const int &u, const int &v){return A[u]+u*D < A[v]+v*D;});
	int p = 0;
	LL m = A[0];
	LL ans = 0;
	repp(i,0,N) if(r[i] > p){
		LL z = A[r[i]]-r[i]*D;
		++p;
		while(p < r[i]){
			if(m+A[p]+p*D < A[r[i]]+r[i]*D+A[p]-p*D){
				ans += m+A[p]+p*D;
				m = min(m,A[p]-p*D);
			} else {
				ans += A[r[i]]+r[i]*D+A[p]-p*D;
				z = min(z,A[p]-p*D);
			}
			++p;
		}
		ans += m+A[r[i]]+r[i]*D;
		m = min(m,z);
	}
	cout << ans << endl;
	return 0;
}
