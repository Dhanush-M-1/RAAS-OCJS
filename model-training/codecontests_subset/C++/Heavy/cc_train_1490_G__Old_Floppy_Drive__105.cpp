#include <bits/stdc++.h>
#define w(x) int x; cin >> x; while(x--)
#define endl '\n'
#define mod 1000000007
#define ll long long
using namespace std;

ll pow(ll x, ll y, ll p) {
    ll res = 1;
    x = x % p;
    
    if(x == 0) 
        return 0;

    while(y > 0) {
        if(y & 1)
            res = (res * x) % p;

        y = y >> 1;
        x = (x * x) % p;
    }

    return res;
}

ll _pow(ll a, ll b) {
    if(!b)
        return 1;

    ll temp = _pow(a, b / 2);
    temp = temp * temp;

    if(b & 1)
        return a * temp;
    return temp;
}

ll invmod(ll a, ll m) {
    return pow(a, m - 2, m);
}

ll cl(ll a, ll x) {
    return a % x == 0 ? a / x : a / x + 1;
}
 
int main() {

    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    #ifndef ONLINE_JUDGE
        freopen("input.txt", "r", stdin);
        freopen("output.txt", "w", stdout);
    #endif

    w(t) {
        ll n, m, sum = 0;
        cin >> n >> m;

        vector<ll> v(n), q(m);
        vector<pair<ll, ll>> pre;

        for(int i = 0; i < n; i++) {
            cin >> v[i];
            sum += v[i];

            if(sum > 0) {
                if(pre.empty() || pre.back().first < sum)
                    pre.push_back({sum, i});
            }
        }

        for(int i = 0; i < m; i++)
            cin >> q[i];

        for(int i = 0; i < m; i++) {
            auto j = lower_bound(pre.begin(), pre.end(), make_pair(q[i], 0LL));

            if(j != pre.end())
                cout << j -> second << " ";
            else if(sum <= 0)
                cout << -1 << " ";
            else {
                q[i] -= pre.back().first;
                ll val = cl(q[i], sum);
                q[i] -= val * sum;
                ll ans = val * n;

                j = lower_bound(pre.begin(), pre.end(), make_pair(q[i] + pre.back().first, 0LL));

                ans += j -> second;

                cout << ans << " ";
            }
        }

        cout << endl;
    }  
}