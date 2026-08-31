#include <iostream>
#include <algorithm>

constexpr int N = 105;
constexpr int p = 1000000007;

int add(int x, int y) { return (x += y) >= p ? x - p : x; }
int sub(int x, int y) { return (x -= y) < 0 ? x + p : x; }

int n, q, k;
int c[N], b[N];
int f[N][N * N];
int s[2][N * N];
int l[N];

int main() {
    std::ios::sync_with_stdio(false), std::cin.tie(nullptr);
    std::cin >> n;
    int sumc = 0;
    for (int i = 1; i <= n; ++i) std::cin >> c[i], sumc += c[i];
    for (int i = 1; i < n; ++i) std::cin >> b[i];
    std::cin >> q;
    while (q--) {
        std::cin >> k;
        int sumb = k;
        for (int i = 1; i <= n; ++i) {
            l[i] = l[i - 1] + sumb;
            sumb += b[i];
        }
        f[0][0] = 1;
        for (int i = 0; i <= sumc; ++i) s[0][i] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < l[i] && j <= sumc; ++j) s[1][j] = 0, f[i][j] = 0;
            for (int j = std::max(l[i], 0); j <= sumc; ++j) {
                f[i][j] = sub(s[0][j], j - c[i] - 1 >= 0 ? s[0][j - c[i] - 1] : 0);
                s[1][j] = add(f[i][j], j > 0 ? s[1][j - 1] : 0);
            }
            std::swap(s[0], s[1]);
        }
        int min = k * n + sumb - k;
        int ans = 0;
        for (int i = std::max(min, 0); i <= sumc; ++i) {
            ans = add(ans, f[n][i]);
        }
        std::cout << ans << '\n';
    }
    return 0;
}
