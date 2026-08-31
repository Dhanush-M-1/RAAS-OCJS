//#pragma GCC optimize("Ofast,fast-math,unroll-loops")
//#pragma GCC target("avx,avx2,sse,sse2,sse3,ssse3,sse4,abm,mmx,popcnt")
#include <bits/stdc++.h>
//#define int32_t int64_t


/*
const size_t MAX_MEM = 2e8;
char MEM[MAX_MEM];
size_t MEM_POS = 0;
void* operator new(size_t x) {
    auto ret = MEM + MEM_POS;
    MEM_POS += x;
    assert(MEM_POS < MAX_MEM);
    return ret;
}

void operator delete(void*)
{}
*/

template <class T>
std::istream& operator>>(std::istream &in, std::vector<T> &a) {
    for (auto &x : a)
        in >> x;
    return in;
}

template <class T>
std::ostream& operator<<(std::ostream &out, const std::vector<T> &a) {
    for (auto &x : a)
        out << x << " ";
    return out;
}

template <class T, class U>
std::istream& operator>>(std::istream &in, std::pair<T, U> &p) {
    in >> p.first >> p.second;
    return in;
}

template <class T, class U>
std::ostream& operator<<(std::ostream &out, const std::pair<T, U> &p) {
    out << p.first << " " << p.second;
    return out;
}

const int64_t P = 1e9+7;
int64_t add(int64_t a, int64_t b) {
    return a + b >= P ? a + b - P : a + b;
}
int64_t mul(int64_t a, int64_t b) {
    return a * b % P;
}

const int64_t M = 2e5+5, D = 10;

std::vector<std::vector<int64_t>> dp(M, std::vector<int64_t>(D));
void init() {
    for (int i = 0; i < D; ++i)
        dp[0][i] = 1;
    for (int l = 1; l < M; ++l) {
        for (int d = 0; d < D; ++d) {
            if (d == 9) {
                dp[l][d] = add(dp[l - 1][0], dp[l - 1][1]);
            } else {
                dp[l][d] = dp[l - 1][d + 1];
            }
        }
    }
}

void solve() {
    int64_t m;
    std::string n;
    std::cin >> n >> m;
    std::reverse(n.begin(), n.end());
    while (n.size() > 1 && n.back() == '0')
        n.pop_back();
    std::reverse(n.begin(), n.end());
    int64_t ans = 0;
    for (char d : n)
        ans = add(ans, dp[m][d - '0']);
    std::cout << ans << "\n";
}

signed main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);
    std::cout.tie(nullptr);
    init();
    int32_t t;
    std::cin >> t;
    while (t--) {
        solve();
    }
    return 0;
}

