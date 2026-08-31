#include <algorithm>
#include <iostream>
#include <map>
#include <vector>
using namespace std;

int main()
{
    cin.tie(0);

    int x, k;
    cin >> x >> k;

    vector<int> rs(k);
    for (auto& r : rs)
        cin >> r;
    rs.push_back(1e9 + 1);

    int qn;
    cin >> qn;
    vector<pair<int, int>> qs(qn);
    for (auto& q : qs) {
        cin >> q.first >> q.second;
    }

    int lo = 0, hi = x;
    int qi = 0;
    int prev = 0;
    int base = 0;

    for (int i = 0; i < rs.size(); i++) {
        // cerr << "hi: " << hi << ", lo: " << lo << ", base: " << base << endl;

        int dir = i % 2 == 0 ? -1 : 1;
        int r = rs[i];
        while (qi < qs.size() && qs[qi].first < r) {
            int t = qs[qi].first - prev;
            int b = min(hi - lo, max(0, qs[qi].second - base)) + lo;
            int ans = min(x, max(0, b + t * dir));
            cout << ans << endl;
            qi++;
        }

        int ma = min(x, max(0, hi + (r - prev) * dir));
        int mi = min(x, max(0, lo + (r - prev) * dir));

        base += (mi - (r - prev) * dir) - lo;

        hi = ma;
        lo = mi;

        prev = r;
    }

    return 0;
}
