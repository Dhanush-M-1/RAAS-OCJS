
#include <bits/stdc++.h>

#define null               ""
#define all(dat)           dat.begin(), dat.end()
#define over(msg)          cout << msg << endl, exit(0);
#define loop(i, to)        for (int i = 0; i < to; ++i)
#define cont(i, to)        for (int i = 1; i <= to; ++i)
#define circ(i, fr, to)    for (int i = fr; i <= to; ++i)
#define foreach(i, dat)    for (__typeof(dat.begin()) i = dat.begin(); i != dat.end(); ++i)

typedef long long          num;

using namespace std;

struct edge {
    int u, v;
    num val;
    edge() {}
    edge(int u, int v, num val) {
        this->u = u;
        this->v = v;
        this->val = val;
    }
};

int n, pr[200005];
num ans, d, w[200005];
vector<edge> dat;

bool inline cmp(edge a, edge b) {
    return a.val < b.val;
}

int find_pr(int a) {
    return pr[a] == a ? a : pr[a] = find_pr(pr[a]);
}

void solve(int l, int r) {
    if (l == r)  return;
    int mid = (l + r) >> 1, pl = 0, pr = 0;
    num ml = 5e18, mr = 5e18;
    circ (i, l, mid) {
        num cur = w[i] - d * i;
        if (cur < ml) {
            pl = i;
            ml = cur;
        }
    }
    circ (i, mid + 1, r) {
        num cur = w[i] + d * i;
        if (cur < mr) {
            pr = i;
            mr = cur;
        }
    }
    circ (i, mid + 1, r) {
        dat.push_back(edge(pl, i, ml + w[i] + d * i));
    }
    circ (i, l, mid) {
        dat.push_back(edge(i, pr, mr + w[i] - d * i));
    }
    solve(l, mid);
    solve(mid + 1, r);
}

int main() {
    ios_base::sync_with_stdio(0);
    cin >> n >> d;
    cont (i, n) {
        cin >> w[i];
    }
    solve(1, n);
    sort(all(dat), cmp);
    cont (i, n) {
        pr[i] = i;
    }
    loop (i, dat.size()) {
        int u = dat[i].u, v = dat[i].v, pu = find_pr(u), pv = find_pr(v);
        num val = dat[i].val;
        if (pu == pv)  continue;
        pr[pv] = pu;
        ans += val;
    }
    cout << ans << endl;
}
