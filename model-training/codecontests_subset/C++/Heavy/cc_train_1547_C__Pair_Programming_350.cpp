#include <bits/stdc++.h>
#define ff first
#define ss second
#define ll long long
#define ld long double
#define pb push_back
#define mp make_pair
#define pii pair<int, int>
#define pll pair<ll,ll>
#define vi vector<int>
#define vl vector<ll>
#define vii vector<pii>
#define endl '\n'

// n acho que eu seja bom, mas eu ja fui pior

using namespace std;

const int MAX = 310;
const int INF = 1e9+7;
const ll LLINF = 0x3f3f3f3f3f3f3f3fll;
const int MOD = 1000000007;
const ld EPS = 1e-8;
const ld PI = acos(-1);

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    int t, k, n, m, a[MAX], b[MAX]; cin >> t;
    while (t--) {
        cin >> k >> n >> m;
        
        for (int i = 0; i < n; i++)
            cin >> a[i];
            
        for (int i = 0; i < m; i++)
            cin >> b[i];
        
        vi res;
        int curr = k; // current line
        bool ans = true;
        
        int it = 0, jt = 0;
        while (true) {
            bool mod = false;
            
            while (it < n) {
                if (a[it] == 0) {
                    curr++;
                    res.pb(a[it]);
                    mod = true;
                } else if (a[it] <= curr) {
                    res.pb(a[it]);
                    mod = true;
                } else {
                    break;
                }
                
                it++;
            }
            
            while (jt < m) {
                if (b[jt] == 0) {
                    curr++;
                    res.pb(b[jt]);
                    mod = true;
                } else if (b[jt] <= curr) {
                    res.pb(b[jt]);
                    mod = true;
                } else {
                    break;
                }
                
                jt++;
            }
            
            if (!mod) {
                if (it != n or jt != m)
                    ans = false;
                
                break;
            }
        }
        
        
        if (!ans) cout << -1 << endl;
        else {
            for (int i = 0; i < res.size(); i++)  {
                cout << res[i];
                
                if (i == res.size()-1) cout << endl;
                else cout << ' ';
            }
        }
    }
    
    return 0;
}