#pragma GCC optimize ("O3")
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int N = 5e5 + 5;
const int mod = 1e9 + 7;
int n, m, cnt = 1, par[N];
vector<int> ans;
int find(int u) {
    return (u == par[u]) ? u : par[u] = find(par[u]);
}
bool join(int a, int b) {
    a = find(a), b = find(b);
    if(a == b)
        return 0;
    par[b] = a;
    return 1;
}
int main() {
    ios_base::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> n >> m;
    for(int i = 1;i <= m + 1;i++)
        par[i] = i;
    for(int i = 1;i <= n;i++) {
        int k, a, b = m + 1;
        cin >> k >> a;
        if(k > 1)
            cin >> b;
        if(join(a, b))
            ans.push_back(i), cnt = (2ll * cnt) % mod;
    }
    cout << cnt << " " << ans.size() << '\n';
    for(auto &i : ans)
        cout << i << " ";
    return 0;
}