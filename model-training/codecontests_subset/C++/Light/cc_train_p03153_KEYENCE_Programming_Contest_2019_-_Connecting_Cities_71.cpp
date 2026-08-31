// ※※※ 解答不能 ※※※
// LHiC氏.
// https://atcoder.jp/contests/keyence2019/submissions/4005363
#include <bits/stdc++.h>
using namespace std;
using LL = long long;
#define repex(i, a, b, c) for(int i = a; i < b; i += c)
#define repx(i, a, b) repex(i, a, b, 1)
#define rep(i, n) repx(i, 0, n)
#define repr(i, a, b) for(int i = a; i >= b; i--)
#define a first
#define b second
const int MAXN = 210000;
LL d;
int n;
LL a[MAXN];

int main(){
    scanf("%d %lld", &n, &d);
    rep(i, n) scanf("%lld", &a[i]);
    vector<pair<LL, int>> vv;
    repx(i, 1, n){
        LL x = a[i] + d * i;
        while(!vv.empty() && vv.back().a >= x) vv.pop_back();
        vv.emplace_back(x, i);
    }
    int now = 1;
    LL bst = a[0];
    LL ans = 0;
    rep(i, vv.size()){
        int nw = vv[i].b;
        ans += vv[i].a + bst;
        repx(j, now, nw){
            ans += a[j] + min(vv[i].a - j * d, bst + j * d);
            bst = min(bst, a[j] - j * d);
        }
        bst = min(bst, a[nw] - nw * d);
        now = nw + 1;
    }
    printf("%lld\n", ans);
    return 0;
}