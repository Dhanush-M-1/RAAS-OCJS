// <><> NEVER GIVE UP <><> 
// design by CAN NGOC BINH
 
#include<bits/stdc++.h>
using namespace std;
 
 
#define pb push_back
#define ll long long
#define endl '\n'
#define mp make_pair
#define mt make_tuple
#define f first
#define pll pair<long long, long long>
#define s second
#define eb emplace_back
#define pii pair<int, int>
#define INF INT_MAX
#define LINF LLONG_MAX
#define all(vec) vec.begin(), vec.end()
#define FILEINPUT freopen("inputCNB.txt", "r", stdin);
#define FILEOUTPUT freopen("ouputCNB.txt", "w", stdout);
#define FOR(i, m, n) for(int i=(int)m; i<(int)n; i++)
#define FORD(i, m, n) for(int i=(int)m; i>=(int)n; i--)
#define FastIO cin.tie(0); ios_base::sync_with_stdio(false); cout.tie(0);
#define pq_max priority_queue<int>
#define pq_min priority_queue<int, vector<int>, greater<int>>
#define reset(A) memset(A, 0, sizeof(A))
#define sqr(a) (1.0)*(a)*(a)
/******* LIBRARY and DEFINE *******/
 
 
template<typename A, typename B> 
ostream& operator << (ostream &os, const pair<A, B> &p){
return os << "(" << p.f << " " << p.s << ")";};
 
template<typename T>
ostream& operator << (ostream &os, const vector<T> &vec){
os << "VECTOR: "; for(auto ele: vec) os << ele << " "; return os;};
/********** TEMPLATES *********/
 
const int MAXN = 1005;
const int mod = 1e9 + 7;
/***** CONSTANT ******/



void solution(){
	
	int k, n, m;
	cin >> k >> n >> m;
	vector<int> mono(n), poly(m);
	
	for(auto &x: mono) cin >> x;
	for(auto &x: poly) cin >> x;
		
	vector<int> ans;
	
	bool isDone = true;
	int pos1 = 0, pos2 = 0;
	while(pos1 < n && pos2 < m){
		
		int val1 = mono[pos1];
		int val2 = poly[pos2];
		if(val1 == 0){
			ans.pb(val1);
			pos1++;
			continue;
		}
		if(val2 == 0){
			ans.pb(val2);
			pos2++;
			continue;
		}
		
		int MIN = min(val1, val2);
		ans.pb(MIN);
		if(val1 == MIN){
			pos1++;
			continue;
		}
		if(val2 == MIN){
			pos2++;
			continue;
		}	
	}
	
	if(pos1 != n){
		for(int i=pos1; i<n; i++) ans.pb(mono[i]);					
	}
	else if(pos2 != m){
		for(int i=pos2; i<m; i++) ans.pb(poly[i]);		
	}
	
	for(auto x: ans){
		if(x == 0) k++;
		else{
			if(x > k){
				isDone = false;
				break;
			}
		}
	}
	
	if(!isDone) cout << -1 << endl;
	else{
		for(auto x: ans) cout << x << " ";
		cout << endl;
	}
}

 
/*******************************/
		
/******** MAIN FUNCTION *********/
int32_t main(){
	
	#ifdef NGOCBINH
		FILEINPUT;
		FILEOUTPUT;
	#endif
	
	
	FastIO;
	
 	
 
	int test = 1;	
	cin >> test; cin.ignore();	
 
	while(test--) solution();
	
	return 0;	
}
/********** I'mAlone ***********/
 
