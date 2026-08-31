#include <iostream>

using namespace std;

const int Nmax = int(1e5 + 5),MOD = 1e9 + 7;
int dp[Nmax];
int N,M,X;

int main() {
    cin >> N >> M;
    while(M--) {
        cin >> X;
        dp[X] = -1;
    }
    dp[N] = 1;
    for(int i = N - 1; i >= 0; --i)
        if(dp[i] == -1)
            dp[i] = 0;
        else
            dp[i] = (dp[i + 1] + dp[i + 2]) % MOD;
    cout <<dp[0];
    return 0;
}
