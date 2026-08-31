#include<bits/stdc++.h>
#include<string>
#include<map>
#include<set>
#include<sstream>

using namespace std;

#define fast ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0)
#define linebreak cout<<"\n"
#define lli long long int
const int MOD = 1000000007;
const int N = 100005;
const lli p = 53;
const lli m = 1000000000000000009;
int dx[] = {-1,-1,-1,0,0,1,1,1};
int dy[] = {-1,0,1,-1,1,-1,0,1};

int dappa[2][200010];

int dp(int n, int m) {
    // cout << n << " " << m << "\n";
    if(dappa[n][m] != 0) { return dappa[n][m]; }

    if(m < 9) { dappa[n][m] = 1; return 1; }

    if(n == 0 && m < 10) { dappa[n][m] = 1; return 1; }
    if(n == 1) {
        // cout << "jjj";
        dappa[n][m] = (dp(1, m-9)%MOD +dp(0, m-9)%MOD)%MOD;
        // cout << n << " " << m << " " << dappa[n][m] << "\n";
    }
    else {
        // cout << "lll";
        dappa[n][m] = (dp(1, m-10)%MOD +dp(0, m-10)%MOD)%MOD;
        // cout << n << " " << m << " " << dappa[n][m] << "\n";
    }
    
    return dappa[n][m];
}

void testCase() {
    int n, m; cin >> n >> m;
    int answer = 0;
    // memset(dappa, -1, sizeof(dappa));
    int nn = n, mm = m;
    while(nn != 0) {
        mm = m;
        int x = nn%10;
        if(x == 0) { mm--; }
        else {
            mm += x-1;
        }
        answer = (answer+dp(1, mm))%MOD;
        // cout << dappa[1][mm] << " " << x << " " << answer << " " << mm << " " << "ouch\n";
        nn /= 10;
    }
    cout << answer << "\n";
}

int main() {

    fast;
    int t=1; cin >> t;
    while(t!=0) {t--;
        testCase();
    }
    return 0;
}
