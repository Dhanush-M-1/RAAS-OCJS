#include <bits/stdc++.h>

#define F first
#define S second

using namespace std;
typedef long double ld;
typedef long long ll;

const int max_n = 300011, max_m = 500011, inf = 1000111222;
const ll inff = 1000111222333444;

struct dsu {
    int p[max_n], sz[max_n];
    dsu() {
        for (int i = 0; i < max_n; ++i) {
            p[i] = i;
            sz[i] = 1;
        }
    }
    int find_set(int x) {
        if (p[x] == x) return x;
        return p[x] = find_set(p[x]);
    }
    void union_set(int x, int y) {
        x = find_set(x);
        y = find_set(y);
        if (x != y) {
            if (sz[x] < sz[y]) swap(x, y);
            p[y] = x;
            sz[x] += sz[y];
        }
    }
};

int n, a[max_n], d;
vector<pair<ll, pair<int, int> > > edges;
dsu dd;

ll dist(int i, int q) {
    return 1LL * abs(i - q) * d + a[i] + a[q];
}

void dev(int l, int r) {
    if (l + 1 == r) {
        return;
    }
    int mid = (l + r) / 2;
    pair<ll, int> cv1, cv2;
    cv1 = cv2 = {inff, 0};
    for (int i = l; i < mid; ++i) {
        cv1 = min(cv1, {a[i] - 1LL * d * i, i});
    }
    for (int i = mid; i < r; ++i) {
        cv2 = min(cv2, {a[i] + 1LL * d * i, i});
    }
    for (int i = l; i < mid; ++i) edges.push_back({dist(i, cv2.S), {i, cv2.S}});
    for (int i = mid; i < r; ++i) edges.push_back({dist(i, cv1.S), {i, cv1.S}});
    dev(l, mid);
    dev(mid, r);
}

int main() {
    //freopen("input.txt", "r", stdin);
    //freopen("output.txt", "w", stdout);
    cin >> n >> d;
    for (int i = 0; i < n; ++i) {
        scanf("%d", &a[i]);
    }
    dev(0, n);
    sort(edges.begin(), edges.end());
    ll ans = 0;
    for (int i = 0; i < edges.size(); ++i) {
        if (dd.find_set(edges[i].S.F) != dd.find_set(edges[i].S.S)) {
            dd.union_set(edges[i].S.F, edges[i].S.S);
            ans += edges[i].F;
        }
    }
    cout << ans << endl;
    return 0;
}
