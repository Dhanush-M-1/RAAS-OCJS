#include <bits/stdc++.h>

using namespace std;

#define fst(t) std::get<0>(t)
#define snd(t) std::get<1>(t)
#define thd(t) std::get<2>(t)
#define unless(p) if(!(p))
#define until(p) while(!(p))

using ll = long long;
using P = std::tuple<int,int>;

const int dx[8] = {-1, 1, 0, 0, -1, -1, 1, 1}, dy[8] = {0, 0, -1, 1, -1, 1, -1, 1};

vector<tuple<int, int, int> > v;

int main(){
    std::cin.tie(nullptr);
    std::ios::sync_with_stdio(false);

    ll X, K;
    std::cin >> X >> K;

    for(int i=0;i<K;++i){
        int r;
        std::cin >> r;

        v.emplace_back(r, 2, -1);
    }

    int Q;
    std::cin >> Q;

    for(int i=0;i<Q;++i){
        int t, a;
        std::cin >> t >> a;

        v.emplace_back(t, 1, a);
    }

    sort(v.begin(), v.end());

    // 今 max{lb, min{ub, x + s}}
    ll lb = 0, ub = X, s = 0;
    int lastTime = 0, sgn = -1;
    for(const auto& p : v){
        int t, qt, a;
        tie(t, qt, a) = p;

        int passedTime = t - lastTime;
        if(qt == 1){
            ll x = max(lb, min<ll>(ub, a + s));
            x = max(0ll, min<ll>(X, x + sgn * passedTime));
            std::cout << x << std::endl;
        }else{
            lb = max(0ll, min<ll>(X, lb + sgn * passedTime));
            ub = max(0ll, min<ll>(X, ub + sgn * passedTime));
            s += sgn * passedTime;

            sgn *= -1;
            lastTime = t;
        }
    }
}
