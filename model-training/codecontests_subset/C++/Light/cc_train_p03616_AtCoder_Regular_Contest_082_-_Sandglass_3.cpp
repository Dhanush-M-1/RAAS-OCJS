#include <iostream>
#include <algorithm>

using namespace std;
int x, k, q, t, a, low, up, add, delta, now, ans, r[100007];
bool flag;

int cal(int tt, int lower = 0, int upper = x) {
    if (tt < lower) return lower;
    if (tt > upper) return upper;
    return tt;
}

int main() {
    ios::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);

    cin >> x >> k;
    for (int i = 1; i <= k; i++) cin >> r[i];
    cin >> q;

    low = x, now = 1;
    while (q--) {
        cin >> t >> a;
        while (t >= r[now] && now <= k) {
            delta = (flag ? 1 : -1) * (r[now] - r[now - 1]), add += delta;
            up = cal(delta + up), low = cal(delta + low);
            flag = !flag, now++;
        }
        ans = cal((flag ? 1 : -1) * (t - r[now - 1]) + cal(a + add, up, low));
        cout << ans << '\n';
    }
    return 0;
}