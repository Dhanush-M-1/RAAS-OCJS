#include<bits/stdc++.h>
#include<iostream>
using namespace std;
#define int long long 
#define fi first 
#define se second 
#define mp make_pair 
#define pb push_back 
typedef pair<int, int >ii;
typedef pair<int, ii> iii;
const int INF = 1e15;
const int MOD = 1e9 + 7;
const int N = 1e5 + 5;
int i;
char st;
string s;

void solve() {
    int k;
    int n, m;
    cin >> k >> n >> m;
    vector<int> a(n);
    vector<int> b(m);
    for (int i = 0; i < n; i++)
        cin >> a[i];
    for (int i = 0; i < m; i++)
        cin >> b[i];
    int i = 0, j = 0;
    vector<int> res;
    while (i != n || j != m) {

        if (i < n && k >= a[i]) {

            res.pb(a[i]);
            if (a[i] == 0) {
                k++;
            }
            i++;

        }
        else if (j < m && k >= b[j]) {
            res.pb(b[j]);
            if (b[j] == 0) {
                k++;
            }
            j++;
        }
        else {

            cout << -1 << endl;
            return;

        }
    }
    for (auto x : res) {
        cout << x << " ";
    }
    cout << endl;
}

int32_t main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
   // freopen("input.txt", "r", stdin);
  //  freopen("output.txt", "w", stdout);
    int t;
    cin >> t;
    while (t--) {
        solve();
    }
}