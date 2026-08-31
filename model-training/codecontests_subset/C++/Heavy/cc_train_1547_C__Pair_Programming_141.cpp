#include<bits/stdc++.h>
using namespace std;
#define ll long long
#define fast_io ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
#define endl "\n"
#define all(v) v.begin(),v.end()

const int mod = 1e9 + 7;
bool solved[305][305], dp[305][305];
int parent[305][305];
bool recurse(vector<int>& a, vector<int>& b, int pagecount, int i, int j, int n, int m) {
    if (i == n && j == m)
        return true;
    if (solved[i][j])
        return dp[i][j];
    solved[i][j] = true;
    bool ans = false;
    if (i < n && (a[i] == 0 || pagecount >= a[i])) {
        parent[i + 1][j] = 1;
        ans |= recurse(a, b, pagecount + (a[i] == 0), i + 1, j, n, m);
    }
    if (!ans && j < m && (b[j] == 0 || pagecount >= b[j])) {
        parent[i][j + 1] = 2;
        ans |= recurse(a, b, pagecount + (b[j] == 0), i, j + 1, n, m);
    }
    return ans;
}
int main (){
    fast_io;
    int t;
    cin >> t;
    while (t--) {
        memset(solved, false, sizeof(solved));
        memset(parent, 0, sizeof(parent));
        int k, n, m;
        cin >> k >> n >> m;
        vector<int> a(n), b(m);
        for (int i = 0; i < n; i++)
            cin >> a[i];
        for (int j = 0; j < m; j++)
            cin >> b[j];
        bool poss = recurse(a, b, k, 0, 0, n, m);
        if (poss == false) {
            cout << - 1 << endl;
            continue;
        }
        vector<int> ans;
        int i = n, j = m;
        while (i > 0 || j > 0) {
            if (parent[i][j] == 1) {
                ans.push_back(a.back());
                a.pop_back();
                i--;
            }
            else {
                ans.push_back(b.back());
                b.pop_back();
                j--;
            }
        }
        reverse(all(ans));
        for (auto it: ans)
            cout << it << ' ';
        cout << endl;
    }
}
