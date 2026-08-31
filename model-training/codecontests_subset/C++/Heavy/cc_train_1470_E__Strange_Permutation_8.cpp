#include <bits/stdc++.h>

using namespace std;

#define mem(a, w) memset(a, w, sizeof(a))
#define all(a) a.begin(), a.end()
#define mp make_pair
#define fi first
#define se second

typedef long long ll;
typedef double db;
typedef long double ldb;
typedef pair<int, int> pii;

const int maxc = 4 + 5;
const int maxn = 30000 + 5;

struct data {
    int l, r;
    ll w;
    data() { }
    data(const int &_l, const int &_r, const ll &_w) {
        l = _l; r = _r; w = _w;
        return;
    }
};

int N, Cost, Q, A[maxn];

deque<data> Dq[maxc], tl, tr;
vector<pii> Rev;
int Front[maxc][maxn];
ll Sum[maxc][maxn * maxc];

ll C(int n, int m) {
    if(n < m) return 0;
    ll ret = 1;
    for(int i = 0; i < m; ++i)
        ret = ret * (n - i);
    for(int i = 1; i <= m; ++i)
        ret = ret / i;
    return ret;
}

ll ways(int len, int c) {
    ll ret = 0;
    for(int i = 0; i <= c; ++i) {
        if(len <= 1) ret += (i == 0);
        else ret += C(len - 1, i);
    }
    return ret;
}

bool cmp(data x, data y) {
    return A[x.r] < A[y.r];
}

data F(int p, int c, ll k) {
    int res = 0;
    int i = Front[c][p];
    int l = i + 1, r = Dq[c].size();
    while(l <= r) {
        int mid = l + r >> 1;
        if(Sum[c][mid] - Sum[c][i] >= k) {
            res = mid;
            r = mid - 1;
        }
        else
            l = mid + 1;
    }

    return data(Dq[c][res - 1].l, Dq[c][res - 1].r, Sum[c][res - 1] - Sum[c][i]);
}

void solve() {
    scanf("%d%d%d", &N, &Cost, &Q);
    for(int i = 1; i <= N; ++i)
        scanf("%d", &A[i]);

    for(int c = 1; c <= Cost; ++c) {
        Dq[c].clear();
        for(int i = 1; i <= N; ++i)
            Front[c][i] = 0;
        
        Dq[c].push_back(data(N, N, 1));
        for(int i = N - 1; i >= 1; --i) {
            while(!tl.empty()) tl.pop_back();
            while(!tr.empty()) tr.pop_back();

            for(int j = 1; j <= min(c, N - i); ++j) {
                ll w = ways(N - (i + j), c - j);
                if(A[i] < A[i + j]) {
                    tr.push_back( data(i, i + j, w) );
                }
                else {
                    tl.push_front( data(i, i + j, w) );
                    ++Front[c][i + 1];
                }
            }
            sort(all(tl), cmp);
            sort(all(tr), cmp);
            while(!tl.empty()) {
                Dq[c].push_front(tl.back());
                tl.pop_back();
            }
            while(!tr.empty()) {
                Dq[c].push_back(tr.front());
                tr.pop_front();
            }
        }
        
        // printf("c: %d\n", c);
        // for(int i = 0; i < Dq[c].size(); ++i) {
        //     printf("(%d, %d, %lld)\n", Dq[c][i].l, Dq[c][i].r, Dq[c][i].w); 
        // }
        // puts("");
        
        for(int i = 1; i <= N; ++i)
            Front[c][i] += Front[c][i - 1];
        for(int i = 1; i <= Dq[c].size(); ++i)
            Sum[c][i] = Sum[c][i - 1] + Dq[c][i - 1].w;
    }
    ll limit = ways(N, Cost);
    while(Q--) {
        int pos; ll rk;
        scanf("%d%lld", &pos, &rk);
        if(rk > limit) {
            puts("-1");
            continue;
        }
        
        while(!Rev.empty()) Rev.pop_back();

        int c = Cost, p = 1;
        while(c && p <= N) {
            data tmp = F(p, c, rk);
            //assert(rk - tmp.w > 0);
            Rev.push_back(make_pair(tmp.l, tmp.r));
            rk -= tmp.w;
            p = tmp.r + 1;
            c -= (tmp.r - tmp.l);
        }

        bool flag = 0;
        for(auto x: Rev) {
            // printf("(%d, %d)\n", x.fi, x.se);
            if(x.fi <= pos && pos <= x.se) {
                flag = 1;
                printf("%d\n", A[x.se - (pos - x.fi)]);
                break;
            }
        }
        if(!flag) printf("%d\n", A[pos]);
    }

    return;
}

int main() {
    int T; scanf("%d", &T);
    while(T--) {
        solve();
    }
    return 0;
}
/*
1
6 4 4
6 5 4 3 1 2
*/