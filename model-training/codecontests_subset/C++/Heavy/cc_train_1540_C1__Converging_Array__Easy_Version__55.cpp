#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
#include <array>
#include <random>
#include <chrono>
#include <string>
#include <queue>
#include <cassert>
#define int long long
#define pb push_back
#define pp pair<int,int>
#define ff first
#define dd second
#define mp make_pair

using namespace std;

int n, k, q, x, ans = 0;

int c[101];
int b[101];
int bsum[102];
const int maxSum = 100 * 100 + 2;
int mod = 1e9 + 7;
int dp[101][maxSum];
int psum[maxSum];

int getSum(int i) {
    return bsum[i+1];
}

void solve() {
    cin >> n;   
    for (int i = 0; i < n; ++i) cin >> c[i];
    bsum[0] = 0;
    for (int i = 0; i < n-1; ++i) { 
        cin >> b[i];
        bsum[i+1] = bsum[i] + b[i];
    }
    cin >> q;
    while (q--) {
        cin >> x;
        ans = 0;
        psum[0] = 0;
        for (int i = 0; i <= maxSum; ++i) {
            dp[0][i] = (int)(i >= x && i <= c[0]);
            psum[i+1] = psum[i] + dp[0][i];
        }
        int bb = 0;
        for (int i = 1; i < n; ++i) {
            bb += getSum(i-1);
            for (int sum = 0; sum < 100*n+1; ++sum) {
                dp[i][sum] = 0;
                if ((sum - bb) >= x*(i + 1)) {
                    dp[i][sum] += (psum[sum+1] - psum[max(sum-c[i], 0ll)] + mod) % mod; // dp[i-1][sum] + ... + dp[i-1][sum-c[i]];
                    dp[i][sum] %= mod;
                    if (i == n-1) {
                        ans += dp[i][sum];
                        ans %= mod;
                    }
                }
                //cout << "i sum dp[i][sum] " << i << " " << sum << " " << dp[i][sum] << endl;
            }
            for (int sum = 0; sum <= maxSum; ++sum) {
                psum[sum+1] = psum[sum] + dp[i][sum];
                psum[sum+1] %= mod;
            }
        }
        cout << ans << endl;
    }    
}

int32_t main() {
    ios_base::sync_with_stdio(false);
    int z = 1;//; cin >> z;
    while (z--) {
        solve();
    }
}