#include <bits/stdc++.h>
using namespace std;
#define int long long
#define INF 1e18
#define rep(i, n) for(int (i) = 0; (i) < (n); (i)++)
#define all(x) (x).begin(), (x).end()
typedef pair<int, int> P;
const int mod = 1000000007;

int calc(int n){
    int res = 0;
    int m = 0, tmp = 1;
    while(n > 0){
        int x = n % 10;
        n /= 10;
        m = tmp * x + m;
        tmp *= 10;
        res = max(res, n * m);
    }
    return res;
}


signed main(){

    int q;
    cin >> q;
    while(q--){
        int n;
        cin >> n;
        int cnt = 0;
        while(n >= 10){
            n = calc(n);
            //cout << n << endl;
            cnt++;
        }
        cout << cnt << endl;
    }
}
