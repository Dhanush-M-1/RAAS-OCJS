#include <bits/stdc++.h>
#define rep(i,n) for(int i = 0; i < n; i++)
using namespace std;
typedef long long ll;
typedef pair<ll,ll> P;
 
const double EPS = 1e-10;
const ll INF = 100000000;
const ll MOD = 1000000007;

ll n, m, a, b, p, q;
ll X[41];
ll nX;
ll x[(1<<21)], y[(1<<21)];
ll nx, ny;

int main() {
    cin >> n >> m >> a >> b >> p >> q;
    if (a == 1 && b == 1) {
        if ((p+q) <= m/n) cout << m - n*(p+q) << endl;
        else cout << min(m % (p+q), p+q - m%(p+q)) << endl;
        return 0;
    }
    {
        ll pre = p, pos = q;
        rep(i,n) {
            X[i] = pre + pos;
            nX++;
            if (pre + pos >= m) {
                break;
            }
            pre *= a; pos *= b;
        }
    }
    nx = nX/2;
    ny = nX - nx;
    rep(i,(1<<nx)) {
        ll pos = 0;
        rep(j,nx) {
            if (i&(1<<j)) pos += X[j];
            if (pos > m) break;
        }
        x[i] = pos;
    }
    rep(i,(1<<ny)) {
        ll pos = 0;
        rep(j,ny) {
            if (i&(1<<j)) pos += X[nx+j];
            if (pos > m) break;
        }
        y[i] = pos;
    }
    sort(x, x+(1<<nx));
    sort(y, y+(1<<ny));
    ll ans = INF*INF;
    rep(i,(1<<nx)) {
        int p = lower_bound(y, y+(1<<ny), m-x[i]) - y;
        ans = min(ans, abs(y[p]+x[i]-m));
        if (p != 0) ans = min(ans, abs(y[p-1]+x[i]-m));
    }
    cout << ans << endl;
}


