#include <bits/stdc++.h>
using namespace std;

#define TRACE(x) cerr << #x << " = " << x << endl
#define _ << " _ " <<

#define fi first
#define se second

typedef long long ll;
typedef long double ld;
typedef pair<int, int> pii;
typedef vector<int> vi;

vi p;

int find_p(int x) {
    if (x == p[x]) return x;
    return p[x] = find_p(p[x]);
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    srand(time(0));

    int n, m;
    cin >> n >> m;

    vi sol;

    p.resize(m + 1);
    iota(p.begin(), p.end(), 0);

    for (int i = 0; i < n; i++) {
        int k, x, y;
        cin >> k >> x;
        if (k == 2) cin >> y;
        else y = 0;

        x = find_p(x);
        y = find_p(y);

        if (x == y) continue;

        if (rand() % 2) swap(x, y);
        p[x] = y;

        sol.push_back(i + 1);
    }

    const int MOD = 1e9 + 7;
    int cnt = sol.size(), sz = 1;
    for (int i = 0; i < cnt; i++) {
        sz += sz;
        if (sz >= MOD) sz -= MOD;
    }
    cout << sz << ' ' << cnt << '\n';
    for (auto it : sol) cout << it << ' ';
    cout << '\n';

    return 0;
}

