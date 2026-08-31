#include <bits/stdc++.h>
using namespace std;

#define INF_LL (int64)1e18
#define INF (int32)1e9
#define REP(i, n) for(int64 i = 0;i < (n);i++)
#define FOR(i, a, b) for(int64 i = (a);i < (b);i++)
#define all(x) x.begin(),x.end()
#define fs first
#define sc second

using int32 = int_fast32_t;
using uint32 = uint_fast32_t;
using int64 = int_fast64_t;
using uint64 = uint_fast64_t;
using PII = pair<int32, int32>;
using PLL = pair<int64, int64>;

const double eps = 1e-10;

template<typename A, typename B>inline void chmin(A &a, B b){if(a > b) a = b;}
template<typename A, typename B>inline void chmax(A &a, B b){if(a < b) a = b;}

int main(void){
	cin.tie(0);
	ios::sync_with_stdio(false);
	int32 N;
	vector<int32> a;
	cin >> N;
	a.resize(N);
	vector<int32> cnt(N, 0);
	REP(i, N){
		cin >> a[i];
	}
	REP(i, N){
		FOR(j, i+1, N){
			if(abs(a[i]-a[j])%(N-1) == 0){
				cout << a[i] << " " << a[j] << endl;
				return 0;
			}
		}
	}

}
