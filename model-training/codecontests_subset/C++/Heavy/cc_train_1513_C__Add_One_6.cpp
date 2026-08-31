#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
#pragma GCC target("avx,avx2,fma")
#define all(x) (x).begin(), (x).end()
#define len(s) (int)((s).size())
#define str(ch) string(1, ch)
using namespace std;
using ll = long long;
using ull = unsigned long long;
using graph = vector<vector<int>>;

long long calc[200001];
void solve() {
    int n, m;
    cin >> n >> m;
    long long ans = 0;
    int cnt[10];
    memset(cnt, 0, sizeof(cnt));
    while(n) cnt[n % 10]++, n /= 10;
    for(int i = 0; i < 10; i++) {
        if((9 - i) < m)
            ans += calc[m - (10 - i)] * cnt[i], ans %= (int)1e9 + 7;
        else
            ans += cnt[i];
    }
    cout << ans << endl;
}   

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    long long cnt[10];
    for(int i = 0; i < 10; i++)
        cnt[i] = 0;
    for(int i = 0; i <= 200000; i++)
        calc[i] = 0;
    cnt[9] = 1;
    for(int i = 0; i <= 200000; i++) {
        long long ncnt[10];
        memset(ncnt, 0, sizeof(ncnt));
        for(int j = 0; j < 10; j++) {
            if(j == 9) {
                ncnt[0] += cnt[9];
                ncnt[0] %= (int)1e9 + 7;
                ncnt[1] += cnt[9];
                ncnt[1] %= (int)1e9 + 7;
                continue;
            }
            ncnt[j + 1] += cnt[j];
            ncnt[j + 1] %= (int)1e9 + 7;
        }
        for(int j = 0; j < 10; j++) {
            cnt[j] = ncnt[j];
            calc[i] += cnt[j];
            calc[i] %= (int)1e9 + 7;
        }
    }
    int tt;
    cin >> tt;
    while(tt--) solve();
    return 0;
}


