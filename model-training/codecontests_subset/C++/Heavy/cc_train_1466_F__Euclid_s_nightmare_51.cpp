#include <bits/stdc++.h>

//using namespace std;

typedef long long ll;
typedef long double ld;

//std::mt19937 rng(std::chrono::steady_clock::now().time_since_epoch().count());
//int randi = std::uniform_int_distribution<int>(0, 999)(rng);

const double EPS = 1e-9;
const double PI = acos(-1.0);
const ll OO = 2e18 + 10;
const int oo = 1e9 + 10;
const int MOD = 1e9 + 7;

struct DSU {
    std::vector<int> parent, size;

    void build(int n) {
        parent.resize(n);
        size.resize(n);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int find(int v) {
        if (parent[v] == v)
            return v;
        return parent[v] = find(parent[v]);
    }

    bool unite(int v, int u) {
        v = find(v);
        u = find(u);
        if (v == u)
            return false;
        if (size[u] > size[v])
            std::swap(v, u);
        parent[u] = v;
        size[v] += size[u];
        return true;
    }
};

void solve() {
    int n, m;
    std::cin >> n >> m;

    DSU dsu;
    dsu.build(m + 1);
    std::set<int> s;
    for (int i = 0; i < n; i++) {
        int k;
        std::cin >> k;
        if (k == 1) {
            int x;
            std::cin >> x;
            if (dsu.find(x) != dsu.find(0)) {
                dsu.unite(x, 0);
                s.insert(i);
            }
        } else {
            int x1, x2;
            std::cin >> x1 >> x2;
            if (dsu.find(x1) != dsu.find(x2)) {
                dsu.unite(x1, x2);
                s.insert(i);
            }
        }
    }

    ll ans = 1;
    for (int i = 0; i < s.size(); i++) {
        ans = (ans * 2) % MOD;
    }
    std::cout << ans << " " << s.size() << "\n";
    for (auto &i : s) {
        std::cout << (i + 1) << " ";
    }
    std::cout << "\n";

}

int main() {
    std::ios::sync_with_stdio(false); std::cin.tie(nullptr); std::cout.tie(nullptr);
//    std::chrono::steady_clock::time_point begin = std::chrono::steady_clock::now();

    int tests = 1;
//    std::cin >> tests;
    while (tests--) {
        solve();
    }

//    std::chrono::steady_clock::time_point end = std::chrono::steady_clock::now();
//    std::cout << "time in micros: " << std::chrono::duration_cast<std::chrono::microseconds>(end - begin).count();
    return 0;
}
