#include <bits/stdc++.h>

using namespace std;

struct Event {
    int t, d, a;
    Event() {}
    Event(int _t, int _d, int _a) : t(_t), d(_d), a(_a) {}
    bool operator<(const Event& _oth) const {
        return t < _oth.t;
    }
};

void solve() {
    int R, K;
    cin >> R >> K;
    vector<Event> es;
    for (int _ = 0; _ < K; _++) {
        int t; cin >> t;
        es.emplace_back(t, -1, 0);
    }
    int Q; cin >> Q;
    for (int _ = 0; _ < Q; _++) {
        int t,a;
        cin >> t >> a;
        es.emplace_back(t, 1, a);
    }
    sort(es.begin(), es.end());
    
    int l = 0, r = R, x = 0;
    int t = 0, d = -1;
    for (auto& e: es) {
        x += d * (e.t - t); t = e.t; d *= e.d;
        l = min(max(l,-x), -x+R);
        r = min(max(r,-x), -x+R);

        if (e.d > 0) {
            int a = min(max(e.a, l), r);
            cout << (a + x) << "\n";
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    solve();
    cout << endl;
}
