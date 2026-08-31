//include
//------------------------------------------
#include <vector>
#include <list>
#include <map>
#include <set>
#include <deque>
#include <stack>
#include <bitset>
#include <algorithm>
#include <functional>
#include <numeric>
#include <utility>
#include <sstream>
#include <iostream>
#include <iomanip>
#include <cstdio>
#include <cmath>
#include <cstdlib>
#include <cctype>
#include <string>
#include <cstring>
#include <ctime>
#include <climits>
#include <queue>

using namespace std;

//typedef
//------------------------------------------
typedef vector<int> VI;
typedef vector<VI> VVI;
typedef vector<string> VS;
typedef pair<int, int> PII;
typedef long long LL;

//container util
//------------------------------------------
#define ALL(a)  (a).begin(),(a).end()
#define RALL(a) (a).rbegin(), (a).rend()
#define PB push_back
#define MP make_pair
#define SZ(a) int((a).size())
#define EACH(i,c) for(typeof((c).begin()) i=(c).begin(); i!=(c).end(); ++i)
#define EXIST(s,e) ((s).find(e)!=(s).end())
#define SORT(c) sort((c).begin(),(c).end())

//repetition
//------------------------------------------
#define FOR(i,a,b) for(int i=(a);i<(b);++i)
#define REP(i,n)  FOR(i,0,n)

//constant
//--------------------------------------------
const double EPS = 1e-10;
const double PI  = acos(-1.0);

bool dp[2][9][7*7*7*7];
int main(){
  cin.tie(0);
  ios_base::sync_with_stdio(false);

  int N;
  while(cin>>N,N){
	int crt = 0, nxt = 1;
	dp[crt][4][0] = true;
	FOR(i,1,N+1){
	  REP(j,9) REP(k,7*7*7*7) dp[nxt][j][k] = false;
	  
	  VI vi(16);
	  REP(j,16) cin >> vi[j];

	  for(int idx=0;idx<9;++idx){
		for(int c=0;c<7*7*7*7;++c){
		  if(!dp[crt][idx][c]) continue;
		  set<int> p;
		  for(int x=idx/3*3;x<=idx/3*3+2;++x) p.insert(x);
		  for(int y=idx%3;y<9;y+=3) p.insert(y);
		  VI ps_(4);
		  int tmp = c;
		  REP(j,4){
			ps_[j] = tmp % 7;
			tmp /= 7;
		  }
		
		  for(int idx_: p){
			if(i == 1 && idx_ != 4) continue;
			int orig;
			if(idx_ < 3)
			  orig = idx_;
			else if(idx_ < 6)
			  orig = 1 + idx_;
			else
			  orig = 2 + idx_;
			if(vi[orig] || vi[orig+1] || vi[orig+4] || vi[orig+5]) continue;
			VI ps = ps_;

			if(idx_ != 0) ++ps[0];
			else ps[0] = 0;
			if(idx_ != 2) ++ps[1];
			else ps[1] = 0;
			if(idx_ != 6) ++ps[2];
			else ps[2] = 0;
			if(idx_ != 8) ++ps[3];
			else ps[3] = 0;
		  
			if(ps[0] >= 7 || ps[1] >= 7 || ps[2] >= 7 || ps[3] >= 7) continue;
			tmp = 0;
			REP(j,4) tmp = tmp*7 + ps[3-j];
			dp[nxt][idx_][tmp] = true;
		  }
		}
	  }
	  swap(crt, nxt);
	}
	bool ok = false;
	for(int idx=0;idx<9;++idx)
	  for(int c=0;c<7*7*7*7;++c)
		ok = ok || dp[crt][idx][c];

	cout << (ok? 1: 0) << endl;
  }
  
  return 0;
}