#include <bits/stdc++.h>
using i64 = long long;

int main() {
    constexpr i64 inf = std::numeric_limits<i64>::max() / 2;
    int n;
    i64 d;
    std::cin >> n >> d;
    std::vector<i64> a(n), b, c;
    for (int i = 0; i < n; i++) {
        std::cin >> a[i];
        b.push_back(a[i] + i * d);
        c.push_back(a[i] - i * d);
    }

    for (int i = 1; i < n; i++) {
        b[n - 1 - i] = std::min(b[n - i - 1], b[n - i]);
        c[i] = std::min(c[i], c[i - 1]);
    }

    std::vector<int> r;
    i64 ret = 0;
    for (int i = 0; i < n; i++) {
        i64 cost = inf;
        if (i && c[i - 1] <= a[i] - i * d) {
            cost = std::min(cost, c[i - 1] + a[i] + i * d);
        }
        if (i + 1 < n && b[i + 1] <= a[i] + i * d) {
            cost = std::min(cost, b[i + 1] + a[i] - i * d);
        }

        if (cost < inf) ret += cost;
        else r.push_back(i);
    }

    for (int i = 1; i < r.size(); i++) {
        auto v = r[i - 1], w = r[i];
        ret += a[v] + a[w] + (w - v) * d;
    }
    std::cout << ret << std::endl;

    return 0;
}