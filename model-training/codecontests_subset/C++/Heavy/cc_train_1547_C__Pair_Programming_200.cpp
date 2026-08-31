 #include <bits/stdc++.h>

//#pragma startup st_point /* start some function before main*/
//#pragma exit /* start some function after main */
//#pragma warn -rvl /* No return value, + do opposite*/
//#pragma warn -par /* Parameter not used, + do opposite */
//#pragma warn - rch /* Unreachable code, + do opposite */

/*

__attribute__((constructor)) acts like #pragma startup
__attribute__((destructor)) acts like #pragma exit


*/

#define pb push_back
#define mp make_pair
#define sz(s) s.size()
#define all(x) (x).begin(), x.end()
#define F first
#define S second
#define left(v) (v) + (v)
#define right(v) (v) + (v) + 1

using namespace std;

using ll = long long;

typedef map<int, int> mpii;
typedef map<ll, ll> mpll;
typedef map<char, char> mpcc;
typedef map<char, string> mpcs;
typedef map<string, char> mpsc;
typedef pair<int, int> prii;
typedef pair<ll, ll> prll;
typedef unsigned long long ull;
typedef vector<vector<ll> > graph;

const int MAXN = 2e5 + 5;
const int MAXPRIME = 3 * 1e7 + 5;
const int inf = 1e9;
const ll INF = 1e18;
const int M = 1e9 + 7;

void YES();
void NO();

int k, n, m, a[105], b[105], ans[505];

void solve() {

cin >> k >> n >> m;
/*
5 1 4
0
0 0 1 0
*/
for (int i = 1; i <= n; ++i) cin >> a[i];

for (int i = 1; i <= m; ++i) cin >> b[i];

int pos = 1, pos1 = 1, pos2 = 1;

for (int i = 1; i <= n + m; ++i) {
    
     if(pos1 > n) {
         
        for (int j = pos2; j <= m; ++j) {
            
             if(!b[j]) ans[pos] = b[j], pos++, k++;
             
             else if(b[j] > k) {
                 
                 cout << "-1\n";
                 
                 for (int i = 1; i <= n + m; ++i) ans[i] = 0;
                 
                 return;
                 
             }
             
             else ans[pos] = b[j], pos++;
            
        }
        
        break;
        
     }
     
     else if(pos2 > m) {
         
        for (int j = pos1; j <= n; ++j) {
            
             if(!a[j]) ans[pos] = a[j], pos++, k++;
             
             else if(a[j] > k) {
                 
                cout << "-1\n";
                
                 for (int i = 1; i <= n + m; ++i) ans[i] = 0;
                
                return;
                 
             }
             
             else ans[pos] = a[j], pos++;
            
        }
         
        break;
         
     }
         
     else if(!a[pos1]) ans[pos] = a[pos1], pos++, pos1++, k++;
     
     else if(!b[pos2]) ans[pos] = b[pos2], pos++, pos2++, k++;
     
     else if(min(a[pos1], b[pos2]) > k) {
         
         cout << "-1\n";
         
                 for (int i = 1; i <= n + m; ++i) ans[i] = 0;
         
         return;
         
     }
     
     else {
         
         if(a[pos1] > b[pos2]) ans[pos] = b[pos2], pos++, pos2++; 
         
         else ans[pos] = a[pos1], pos++, pos1++;
         
     }
     
}

for (int i = 1; i <= n + m; ++i) {
    
    cout << ans[i] << ' ';
    
    ans[i] = 0;
    
}

cout << '\n';

}

int main() {

	//freopen("document.in", "r", stdin);
	//freopen("document.out", "w", stdout);
	ios_base::sync_with_stdio(NULL);
	cin.tie(NULL);
	cout.tie(NULL);

	int tt = 1;

	cin >> tt;

	for (int i = 1; i <= tt; ++i) {

		//cout << "Case: " << cs << ' ';

		solve();

	}

	return 0;
}

void YES() {

	cout << "YES\n";

}

void NO() {

	cout << "NO\n";

}
