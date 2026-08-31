#include<bits/stdc++.h>
 
using namespace std;
using ll = long long;

vector<int> G;
int get_group(int x) {
    if(G[x] == x)
        return x;
    return G[x] = get_group(G[x]);
}

void merge_group(int x, int y) {
    int gx = get_group(x);
    int gy = get_group(y);
    if(gx == gy) return;
    if(gx > gy)
        swap(gx, gy);
    G[gx] = G[gy];
}

constexpr long long MOD = 1e9 + 7;
void solve(int TestCase) {
    int n, m;
    cin >> n >> m;

    int k = max(n, m);
    vector<vector<int>> A(n, vector<int>(4));
    for(auto i = 0; i < n; ++i) {
        int cnt;
        cin >> cnt;
        for(auto j = 0; j < cnt; ++j)
            cin >> A[i][j];
        if(cnt == 1) A[i][1] = k+1;
        A[i][2] = i + 1;

        if(cnt == 2 && A[i][0] > A[i][1])
            swap(A[i][0], A[i][1]);
    }

    G.resize(k+3);
    iota(G.begin(), G.end(), 0);

    for(auto& a : A) {
        auto g0 = get_group(a[0]);
        auto g1 = get_group(a[1]);
        if(g0 == g1) a[3] = 1;
        else merge_group(a[0], a[1]);
    }

    int cnt = 0;
    for(auto& a : A)
        if(!a[3]) cnt++;
    
    ll ret = 1;
    for(auto i = 0; i < cnt; ++i)
        ret = ret * 2 % MOD;
    
    cout << ret << " " << cnt << endl;
    for(auto& a : A)
        if(!a[3]) cout << a[2] << " ";
    cout << endl;
}
 
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
 
    int t = 1;
    //cin >> t;
    for(auto i = 1; i <= t; ++i) {
        //cout << "Case #"<< i << ": ";
        solve(i);
    }
}