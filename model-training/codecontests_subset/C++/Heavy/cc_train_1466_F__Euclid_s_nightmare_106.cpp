#include <iostream>
#include <vector>
#define ll long long
#define f first
#define s second
#define NMAX 500000
#define MOD 1000000007

using namespace std;

ll n, m, viz[NMAX+10];
ll nr, ans = 1, ans2, tata[NMAX+10], rang[NMAX+10];
vector <ll> nod[NMAX+10], a;
pair <ll, ll> v[NMAX+10];

ll findDaddy(ll x)
{   ll y = x, r = x;
    while(r != tata[r]) r = tata[r];
    while(x != tata[x])
        {   y = tata[y];
            tata[x] = r;
            x = y;
        }
    return r;
}

void unite(ll x, ll y)
{   if(rang[x] < rang[y]) tata[x] = y;
    else tata[y] = x;
    if(rang[x] == rang[y]) rang[x]++;
}

ll lgput(ll a, ll n)
{   if(!n) return 1;
    if(n % 2 == 0) return lgput(a*a % MOD, n/2);
    return a * lgput(a*a % MOD, n/2) % MOD;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >> m;
    for(ll i=1; i<=n; i++)
        {   ll k;
            cin >> k;
            if(k == 1)
                {   cin >> v[i].f;
                    ll x = v[i].f;
                    nod[0].push_back(x);
                    nod[x].push_back(0);
                }
            else
                {   cin >> v[i].f >> v[i].s;
                    ll x = v[i].f, y = v[i].s;
                    nod[x].push_back(y);
                    nod[y].push_back(x);
                }
        }
    for(ll i=0; i<=m; i++) tata[i] = i, rang[i] = 1;
    for(ll i=1; i<=n; i++)
        {   ll val1, val2;
            if(!v[i].s) val1 = findDaddy(v[i].f), val2 = findDaddy(0);
            else val1 = findDaddy(v[i].f), val2 = findDaddy(v[i].s);
            if(val1 == val2) continue;
            ans2++;
            a.push_back(i);
            unite(val1, val2);
        }
    cout << lgput(2LL, ans2) << ' ' << ans2 << '\n';
    for(ll u : a) cout << u << ' ';
    cout << '\n';
    return 0;
}
