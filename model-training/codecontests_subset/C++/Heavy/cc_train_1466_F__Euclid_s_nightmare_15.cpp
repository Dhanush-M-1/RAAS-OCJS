#include <bits/stdc++.h>

using namespace std;

#define fi first
#define se second
#define mp make_pair
#define pb push_back
#define all(a) (a).begin(), (a).end()
using ll = long long;
using ull = unsigned long long;
using pii = pair<int, int>;
using pil = pair<int, ll>;
using pli = pair<ll, int>;
using pll = pair<ll, ll>;
using ld = long double;
using dbl = double;
template<typename T1, typename T2> bool chkmin(T1 &x, T2 y) { return y < x ? (x = y, true) : false; }
template<typename T1, typename T2> bool chkmax(T1 &x, T2 y) { return y > x ? (x = y, true) : false; }
void debug_out()
{
    cerr << endl;
}
template<typename T1, typename... T2> void debug_out(T1 A, T2... B)
{
    cerr << ' ' << A;
    debug_out(B...);
}
#ifdef DEBUG
    #define debug(...) cerr << "[" << #__VA_ARGS__ << "]:", debug_out(__VA_ARGS__)
#else
    #define debug(...) 1337
#endif

const int maxN = 500105;
const int MOD = 1e9 + 7;
int add(int a, int b)
{
    a += b;
    if (a >= MOD)
        a -= MOD;
    return a;
}
void vadd(int &a, int b)
{
    a += b;
    if (a >= MOD)
        a -= MOD;
}
int mult(int a, int b)
{
    return a * (ll)b % MOD;
}
int p2[maxN];

int q[maxN];
int badc[maxN];

int gt(int x)
{
    return q[x] < 0 ? x : q[x] = gt(q[x]);
}

bool un(int a, int b)
{
    a = gt(a);
    b = gt(b);
    if (a == b)
        return false;
    if (-q[a] > -q[b])
        swap(a, b);
    q[b] += q[a];
    badc[b] += badc[a];
    q[a] = b;
    return true;
}

signed main()
{
#ifdef DEBUG
    freopen("in", "r", stdin);
#endif
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    memset(q, 255, sizeof q);
    p2[0] = 1;
    for (int i = 1; i < maxN; ++i)
        p2[i] = mult(2, p2[i - 1]);
    int n, m;
    cin >> n >> m;
    vector<int> ans;
    for (int i = 1; i <= n; ++i)
    {
        int k;
        cin >> k;
        if (k == 1)
        {
            int a;
            cin >> a;
            a = gt(a);
            if (badc[a] == 0)
            {
                ans.push_back(i);
                ++badc[a];
            }
        }
        else
        {
            int a, b;
            cin >> a >> b;
            a = gt(a);
            b = gt(b);
            if (a == b || badc[a] + badc[b] > 1)
                continue;
            if (-q[a] > -q[b])
                swap(a, b);
            q[b] += q[a];
            badc[b] += badc[a];
            q[a] = b;
            ans.push_back(i);
        }
    }
    cout << p2[ans.size()] << ' ' << ans.size() << '\n';
    for (auto i : ans)
        cout << i << ' ';
    cout << '\n';

    return 0;
}