#include <bits/stdc++.h>

using namespace std;

const int MOD = 1e9 + 7;

class DSU {
public:
    vector<int> uf, rank;
    DSU(int n): uf(n), rank(n, 1) {iota(uf.begin(), uf.end(), 0);}; 
    int find(int x){
        if (uf[x] != x) uf[x] = find(uf[x]);
        return uf[x];
    }
    bool unify(int x, int y){
        int px = find(x), py = find(y);
        bool ans = false;
        if (px != py){
            if (rank[px] > rank[py]) swap(px, py);
            rank[py] += rank[px];
            uf[px] = py;
            ans = true;
        }
        return ans;
    }
};


int main(){

    #ifndef ONLINE_JUDGE
    freopen("in.txt", "r", stdin);
    #endif

    ios::sync_with_stdio(false);
    cin.tie(0);

    int n, m;
    cin >> n >> m;
    DSU dsu(m + 1);
    vector<int> ans;
    int x;
    for (int i = 1; i <= n; i++) {
        cin >> x;
        int a = m, b = m;
        cin >> a;
        a--;
        if (x == 2) {
            cin >> b;
            b--;
        }
        if (dsu.unify(a, b)) ans.push_back(i);
    }
    int t = 1;
    for (int i = 0; i < ans.size(); i++) t = t * 2 % MOD;
    cout << t << " " << ans.size() << endl;
    for (int a: ans) cout << a << " ";
    cout << endl;

    return 0;
}