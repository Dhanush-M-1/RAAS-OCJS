#include <bits/stdc++.h>
using namespace std;

#define taskname "TEST"
typedef long long ll;
typedef long double ld;

const int N = 5e5 + 5;
const int MOD = 1e9 + 7;

int n, m, up[N];
vector <int> res;

void init() {
    for (int i = 1; i <= 5e5 + 1; i++) up[i] = i;
}
int findset(int u) {
    if (up[u] != u) up[u] = findset(up[u]);
    return up[u];
}
bool bunion(int u, int v) {
    u = findset(u);
    v = findset(v);
    up[u] = v;
    return (u != v);
}
void inp() {
    cin >> n >> m;
    for (int i = 1; i <= n; i++) {
        int k, u, v = m + 1; cin >> k;
        cin >> u;
        if (k > 1) cin >> v;
        if (bunion(u, v)) res.push_back(i);
    }
}
void out() {
    int ans = 1;
    for (int i = 0; i < res.size(); i++) ans = ((ll)2*ans)%MOD;
    cout << ans << " " << res.size() << "\n";
    for (int i = 0; i < res.size(); i++) cout << res[i] << " ";
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
  //  freopen(taskname".INP", "r", stdin);
  //  freopen(taskname".OUT", "w", stdout);
    init();
    inp();
    out();
}
