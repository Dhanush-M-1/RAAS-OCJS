#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef pair<ll, ll> l_l;
typedef pair<int, int> i_i;

template <typename T>
bool chmax(T &a, T b) {
    if(a < b) {
        a = b;
        return true;
    }
    return false;
}

template <typename T>
bool chmin(T &a, T b) {
    if(a > b) {
        a = b;
        return true;
    }
    return false;
}

#define EPS (1e-7)
#define INF (1e9)
#define PI (acos(-1))
//const ll mod = 1000000007;
ll n, m, a, b, p, q;
ll ans = 1e18;

void solve1() {
    ll timer = m / (p + q);
    chmin(timer, n);
    chmin(ans, abs(m - timer * (p+q)));
    timer++;
    chmin(timer, n);
    chmin(ans, abs(m - timer * (p+q)));
    return;
}

void solve2() {
    ll Mindex = 0;
    ll pak = p;
    ll qbk = q;
    for(ll i = 1; i < n; i++) {
        if(pak > 1e15 / a) break;
        if(qbk > 1e15 / b) break;
        chmax(Mindex, i);
        pak *= a;
        qbk *= b;
    }
    ll rest = m;
    while(Mindex >= 0) {
        //cerr << Mindex << " " << rest << " " << pak << " " << qbk << endl;
        chmin(ans, abs(rest - pak - qbk));
        if(rest - pak - qbk >= 0) {
            rest -= pak + qbk;
            chmin(ans, rest);
        }
        pak /= a;
        qbk /= b;
        Mindex--;
    }
}

void solve3() {
    ll Mindex = 0;
    ll qbk = q;
    for(ll i = 1; i < n; i++) {
        if(qbk > 1e15 / b) break;
        chmax(Mindex, i);
        qbk *= b;
    }
    for(int num = 1; num <= Mindex + 1; num++) {
        ll rest = m - num * p;
        ll restnum = num;
        ll nowqbk = qbk;
        for(int j = Mindex; j >= 0; j--) {
            if(j + 1 == restnum or (restnum >= 1 and rest - nowqbk >= 0)) {
                rest -= nowqbk;
                restnum--;
            } else {
                /*
                ll nowrest = rest;
                rest -= nowqbk;
                ll nowrestnum = restnum - 1;
                ll newqbk = q;
                for(ll i = 0; i < nowrestnum; i++) {
                    rest -= newqbk;
                    newqbk *= b;
                }
                */
                //chmin(ans, abs(nowrest));
            }
            nowqbk /= b;
        }
        chmin(ans, abs(rest));
    }
}

int main() {
    //cout.precision(10);
    cin >> n >> m >> a >> b >> p >> q;
    ans = m;
    if(a == 1 and b == 1) {
        solve1();
    } else if(a != 1 and b != 1) {
        solve2();
    } else {
        if(a != 1) {
            swap(a, b);
            swap(p, q);
        }
        solve3();
    }
    cout << ans << endl;
    return 0;
}
