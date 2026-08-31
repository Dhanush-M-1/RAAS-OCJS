#include <bits/stdc++.h>

#define all(x) x.begin(), x.end()
#define rall(x) x.rbegin(), x.rend()
#define int long long
#define ll long long
#define pb push_back
#define ppb pop_back
#define pf push_front
#define ppf pop_front
#define ff first
#define ss second
#define ld long double
#define pii pair<int, int>

#define prev prev228
#define left left228
#define right right228
#define dist dist228
#define tm tm228

using namespace std;

mt19937 rnd(time(nullptr));

const long long INF = 1e18, P = 1e9 + 7, N = 5e5 + 10;
const long double EPS = 1e-9;
int pr[N], rk[N], used[N];
vector<int> ans, to_used[N];
vector<pair<int, int> > ed;
map<pair<int, int>, int> mp;


int get_root(int x) {
    return (x == pr[x] ? x : pr[x] = get_root(pr[x]));
}

void mrg(int y1, int y2) {
    if (rk[y1] > rk[y2]) {
        swap(y1, y2);
    }
    pr[y1] = y2;
    if (rk[y1] == rk[y2]) {
        rk[y2]++;
    }
}

bool add(int v, int u) {
    v = get_root(v);
    u = get_root(u);
    if (v == u) {
        return false;
    }
    mrg(v, u);
    return true;
}

void do_used(int x) {
    used[x] = 1;
    vector<int> st = {x};
    while (st.size() > 0) {
        int v = st.back();
        st.pop_back();
        for (int u : to_used[v]) {
            if (!used[u]) {
                used[u] = 1;
                st.push_back(u);
            }
        }
    }
}

int32_t main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    //cout << setprecision(15) << fixed;

    //freopen("input.txt", "r", stdin);
    //freopen("output.txt", "w", stdout);
    int n, m;
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        int k;
        cin >> k;
        if (k == 1) {
            int x;
            cin >> x;
            x--;
            if (!used[x]) {
                ans.push_back(i + 1);
                do_used(x);
            }
        } else {
            int v, u;
            cin >> v >> u;
            v--;
            u--;
            mp[{v, u}] = i;
            if (!used[v] || !used[u]) {
                ed.push_back({v, u});
                if (!used[v] && !used[u]) {
                    to_used[v].push_back(u);
                    to_used[u].push_back(v);
                } else if (!used[v]) {
                    do_used(v);
                } else if (!used[u]) {
                    do_used(u);
                }
            }
        }
    }
    for (int i = 0; i < m; i++) {
        pr[i] = i;
        rk[i] = 1;
    }

    for (pair<int, int> p : ed) {
        int v = p.ff, u = p.ss;
        if (add(v, u)) {
            ans.push_back(mp[{v, u}] + 1);
        }
    }
    sort(all(ans));
    int pw = 1;
    for (int i = 0; i < ans.size(); i++) {
        pw *= 2;
        pw %= P;
    }
    cout << pw << ' ' << ans.size() << "\n";
    for (int elem : ans)  {
        cout << elem << ' ';
    }
    cout << "\n";
    return 0;
}
