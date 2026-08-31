#include <bits/stdc++.h>
#define FOR(i,bg,ed) for(ll i=(bg);i<(ed);i++)
#define REP(i,n) FOR(i,0,n)
#define REP1(i,n) for(ll i=1;i<=(n);i++)
#define MOD 1000000007
#define int long long
#define all(c) (c).begin(), (c).end()
#define uniq(c) c.erase(unique(all(c)), (c).end())
using namespace std;
typedef long long ll;
typedef pair<ll, ll> P;
const int INF = 1e9;

ll T;   //合計T[g]の砂
int K;  //砂時計をひっくり返す回数
int Q;  //クエリ数

signed main()
{
    cin >> T;
    cin >> K;
    set<P> events;
    REP(i,K) {
        int t;  //ひっくり返す時刻。元から昇順で並んでいる
        cin >> t;
        events.insert(P(t, -1));    //reverse query
    }
    cin >> Q;
    REP(i,Q) {
        ll t;   //時刻
        ll f;   //始めのAの砂の量
        cin >> t >> f;
        events.insert(P(t, f));
    }

    bool inc = false;   //A,Bどちらが上か。Aが上のときfalse
    ll pt = 0;
    ll a = 0;
    ll b = T;
    ll c = 0;
    for (P e : events) {
        ll t = e.first;     //ひっくり返す、もしくはクエリの時刻
        ll x = e.second;    //-1ならreverse query

        if (inc) {  //Bが上
            ll d = t - pt;
            c += d;
            if (b + c > T) b = T - c;
            if (a > b) a = b;
        } else {    //Aが上
            ll d = t - pt;
            c -= d;
            if (a + c < 0) a = -c;
            if (a > b) b = a;
        }
        if (x == -1) {  //reverse
            inc = !inc;
        } else {
            cout << max(a, min(b, x)) + c << endl;
        }
        pt = t;
    }
}
