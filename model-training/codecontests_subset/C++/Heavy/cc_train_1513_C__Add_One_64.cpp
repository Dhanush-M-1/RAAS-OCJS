//Template Starts Here

//Headers
#include <iostream>
#include <string>
#include <vector>
#include <climits>
#include <algorithm>
#include <cfloat>
#include <sstream>
#include <unordered_set>
#include <queue>
#include <deque>
#include <iomanip>
#include <bitset>
#include <iterator>
#include <list>
#include <stack>
#include <map>
#include <unordered_map>
#include <set>
#include <functional>
#include <numeric>
#include <utility>
#include <limits>
#include <time.h>
#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <cctype>

using namespace std;

//For fast I/O
#define fast                          \
    ios_base::sync_with_stdio(false); \
    cin.tie(0);                       \
    cout.tie(0);
#define endl "\n"

// // Magic
// template <typename... T>
// void read(T &...args)
// {
//     ((cin >> args), ...);
// }

// template <typename... T>
// void write(T &...args)
// {
//     ((cout << args << " "), ...);
// }

// For printing
#define p0(a) cout << a << " "
#define p1(a) cout << a << "\n"
#define p2(a, b) cout << a << " " << b << "\n"
#define p3(a, b, c) cout << a << " " << b << " " << c << "\n"
#define p4(a, b, c, d) cout << a << " " << b << " " << c << " " << d << "\n"
#define p5(a, b, c, d, e) cout << a << " " << b << " " << c << " " << d << " " << e << "\n"

#define fsp(n) fixed << setprecision(n)

#define pfi(x) printf("%d\n", x);
#define pfi2(x, y) printf("%d %d\n", x, y);
#define pfi3(x, y, z) printf("%d %d %d\n", x, y, z);

#define pfl(x) printf("%lld\n", x);
#define pfl2(x, y) printf("%lld %lld\n", x, y);
#define pfl3(x, y, z) printf("%lld %lld %lld\n", x, y, z);

#define pfs(x) printf("%s\n", x);
#define pfs2(x, y) printf("%s %s\n", x, y);
#define pfs3(x, y, z) printf("%s %s %s\n", x, y, z);

#define ia(arr, n) \
    f0(i, n) { cin >> arr[i]; }
#define pa(arr, n)                      \
    f0(i, n) { cout << arr[i] << " "; } \
    cout << "\n";

//Scanf
#define sf1(a) scanf("%d", &a)
#define sf2(a, b) scanf("%d %d", &a, &b)
#define sf3(a, b, c) scanf("%d %d %d", &a, &b, &c)
#define sf4(a, b, c, d) scanf("%d %d %d %d", &a, &b, &c, &d)
#define sf5(a, b, c, d, e) scanf("%d %d %d %d %d", &a, &b, &c, &d, &e)
#define sf1l(a) scanf("%I64d", &a)
#define sf2l(a, b) scanf("%I64d %I64d", &a, &b)
#define sf3l(a, b, c) scanf("%I64d %I64d %I64d", &a, &b, &c)
#define sf4l(a, b, c, d) scanf("%I64d %I64d %I64d %I64d", &a, &b, &c, &d)
#define sf5l(a, b, c, d, e) scanf("%I64d %I64d %I64d %I64d %I64d", &a, &b, &c, &d, &e)

// Short Forms
#define ld long double
#define F first
#define S second
#define pb push_back
#define eb emplace_back
#define all(x) (x).begin(), (x).end()
#define al(x, n) (x), (x) + n
#define mp make_pair
#define sz size()
#define clr clear()
#define len length()

// Constant
#define Mod 1000000007
#define Mod2 998244353
#define INF 2147483647
const double PI = 3.14159265358979323846264338327950288419716939937510582097494459230;
const int dx4[] = {-1, 0, 1, 0};
const int dy4[] = {0, 1, 0, -1};
const int dx8[] = {-1, 0, 1, 0, -1, -1, 1, 1};
const int dy8[] = {0, 1, 0, -1, -1, 1, -1, 1};

// Self Defined
#define gcd __gcd
#define lcm(a, b) (a * b) / gcd(a, b)
#define rsort(r) sort(r, greater<ll>())
#define ABS(r) ((r) < 0 ? -(r) : (r))
#define deb(x) cout << ">> " << #x << " : " << x << endl;

// Max - Min
#define max3(a, b, c) max(max(a, b), c)
#define min3(a, b, c) min(min(a, b), c)
#define max4(a, b, c, d) max(a, max3(b, c, d))
#define min4(a, b, c, d) min(a, min3(b, c, d))
#define max5(a, b, c, d, e) max(max4(a, b, c, d), e)
#define min5(a, b, c, d, e) min(min4(a, b, c, d), e)
#define maxa(v) *max_element(v, v + v.size())
#define mina(v) *min_element(v, v + v.size())

//remain
#define f0(i, n) for (ll i = 0; i < n; i++)
#define f1(i, n) for (ll i = 1; i <= n; i++)
#define f3(i, n) for (ll i = n - 1; i >= 0; i--)
#define f4(i, n) for (ll i = n; i > 0; i--)

// Type Def Start
typedef int64_t ll;
// typedef int64_t ll;
typedef map<string, int> msi;
typedef map<int, int> mii;
typedef map<ll, ll> mll;
typedef map<char, int> mci;
typedef map<int, string> mis;

typedef unordered_map<string, int> usi;
typedef unordered_map<int, int> uii;
typedef unordered_map<ll, ll> ull;
typedef unordered_map<char, int> uci;
typedef unordered_map<int, string> uis;

typedef pair<int, int> pii;
typedef pair<ll, ll> pll;
typedef pair<string, int> psi;
typedef pair<string, string> pss;
typedef pair<int, pii> tri;
typedef pair<double, double> pd;

typedef vector<int> vi;
typedef vector<vi> vvi;
typedef vector<ll> vl;
typedef vector<string> vs;
typedef vector<char> vc;
typedef vector<bool> vb;
typedef vector<pii> vpi;

typedef priority_queue<int, vector<int>, greater<int>> rpq;
typedef priority_queue<int> pq;

typedef set<int> si;
typedef set<ll> sl;

// Defined
#define test()        \
    ll test_case;     \
    cin >> test_case; \
    while (test_case--)
#define inp1(n)      \
    ll n;            \
    cin >> n;        \
    ll arr[n] = {0}; \
    f0(i, n) { cin >> arr[i]; }
#define inp2(n, k)    \
    int n, k;         \
    cin >> n;         \
    cin >> k;         \
    int arr[n] = {0}; \
    f0(i, n) { cin >> arr[i]; }

//MODED DATA
// ll add(ll a, ll b)
// {
//     ll t = a + b;
//     if (t >= mod)
//     {
//         return t -= mod;
//     }
//     return t;
// }
// ll sub(ll a, ll b)
// {
//     return (a - b + mod) % mod;
// }
// ll mul(ll a, ll b)
// {
//     return (a * b) % mod;
// }

//DECIMAL DATA
// const long double eps = 1e-9;
// bool equalTo(double a, double b)
// {
//     if (fabs(a - b) <= eps)
//         return true;
//     else
//         return false;
// }
// bool notEqual(double a, double b)
// {
//     if (fabs(a - b) > eps)
//         return true;
//     else
//         return false;
// }
// bool lessThan(double a, double b)
// {
//     if (a + eps < b)
//         return true;
//     else
//         return false;
// }
// bool lessThanEqual(double a, double b)
// {
//     if (a < b + eps)
//         return true;
//     else
//         return false;
// }
// bool greaterThan(double a, double b)
// {
//     if (a > b + eps)
//         return true;
//     else
//         return false;
// }
// bool greaterThanEqual(double a, double b)
// {
//     if (a + eps > b)
//         return true;
//     else
//         return false;
// }

//Funtions
template <typename T>
int to_int(T num)
{
    int val;
    stringstream stream;
    stream << num;
    stream >> val;
    return val;
}
bool isPrime(ll n)
{
    if (n < 2)
        return false;
    for (ll i = 2; i * i <= n; i++)
        if (n % i == 0)
            return false;
    return true;
}
bool isPowerTwo(ll x)
{
    return (x && !(x & (x - 1)));
};
bool isSubstring(string s1, string s2)
{
    if (s1.find(s2) != string::npos)
        return true;
    return false;
}

ll mod = 1;

ll fast_pow(ll a, ll p)
{
    ll res = 1;
    while (p)
    {
        if (p % 2 == 0)
        {
            a = a * 1ll * a;
            p /= 2;
        }
        else
        {
            res = res * 1ll * a;
            p--;
        }
    }
    return res;
}

ll fact(ll n)
{
    ll res = 1;
    for (ll i = 1; i <= n; i++)
    {
        res = res * 1ll * i % mod;
    }
    return res;
}

ll nCr(ll n, ll k)
{
    return fact(n) * 1ll * fast_pow(fact(k), mod - 2) % mod * 1ll * fast_pow(fact(n - k), mod - 2) % mod;
}

ll gcd(ll a, ll b)
{
    if (b > a)
    {
        return gcd(b, a);
    }
    if (b == 0)
    {
        return a;
    }
    return gcd(b, a % b);
}
ll expo(ll a, ll b, ll mod)
{
    ll res = 1;
    while (b > 0)
    {
        if (b & 1)
            res = (res * a) % mod;
        a = (a * a) % mod;
        b = b >> 1;
    }
    return res;
}
void extendgcd(ll a, ll b, ll *v)
{
    if (b == 0)
    {
        v[0] = 1;
        v[1] = 0;
        v[2] = a;
        return;
    }
    extendgcd(b, a % b, v);
    ll x = v[1];
    v[1] = v[0] - v[1] * (a / b);
    v[0] = x;
    return;
} //pass an arry of size1 3
ll mminv(ll a, ll b)
{
    ll arr[3];
    extendgcd(a, b, arr);
    return arr[0];
} //for non prime b
ll mminvprime(ll a, ll b) { return expo(a, b - 2, b); }
bool revsort(ll a, ll b) { return a > b; }
void swap(int &x, int &y)
{
    int temp = x;
    x = y;
    y = temp;
}
ll combination(ll n, ll r, ll m, ll *fact, ll *ifact)
{
    ll val1 = fact[n];
    ll val2 = ifact[n - r];
    ll val3 = ifact[r];
    return (((val1 * val2) % m) * val3) % m;
}
void google(int t) { cout << "Case #" << t << ": "; }
vector<ll> sieve(int n)
{
    int *arr = new int[n + 1]();
    vector<ll> vect;
    for (int i = 2; i <= n; i++)
        if (arr[i] == 0)
        {
            vect.push_back(i);
            for (int j = 2 * i; j <= n; j += i)
                arr[j] = 1;
        }
    return vect;
}
ll mod_add(ll a, ll b, ll m)
{
    a = a % m;
    b = b % m;
    return (((a + b) % m) + m) % m;
}
ll mod_mul(ll a, ll b, ll m)
{
    a = a % m;
    b = b % m;
    return (((a * b) % m) + m) % m;
}
ll mod_sub(ll a, ll b, ll m)
{
    a = a % m;
    b = b % m;
    return (((a - b) % m) + m) % m;
}
ll mod_div(ll a, ll b, ll m)
{
    a = a % m;
    b = b % m;
    return (mod_mul(a, mminvprime(b, m), m) + m) % m;
} //only for prime m

//Template Completed
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// sort(s.begin(), s.end());
//distance(s.begin(), unique(s.begin(), s.end()))
//s.resize(distance(s.begin(),  unique(s.begin(), s.end())))

void check(bool b, string y = "YES", string n = "NO")
{
    // b ? cout << "YES\n" : cout << "NO\n";
    b ? cout << y << "\n" : cout << n << "\n";
}

bool cmp(pair<ll, ll> a, pair<ll, ll> b)
{
    if (a.first < b.first)
        return false;
    if (a.first > b.first)
        return true;
    else
        return a.second < b.second;
}

void sol6()
{
    ll n;
    cin >> n;
    string s[n];
    for (ll x = 0; x < n; x++)
    {
        cin >> s[x];
    }
}

void sol5()
{
    ll a, b;
    cin >> a >> b;
    ll a2 = a, b2 = b;
    string s;
    cin >> s;
}

void sol4()
{
    ll n;
    cin >> n;
    ll a[n];
    for (ll i = 0; i < n; i++)
    {
        cin >> a[i];
    }
}

void sol3()
{
    ll n, k;
    cin >> n >> k;
}

const ll N = 2 * 1e5 + 10;
ll dp[10][N];

void solve()
{
    //Initial Single Digit for Each
    for (ll i = 0; i <= 9; i++)
    {
        dp[i][0] = 1;
    }
    for (ll j = 1; j < N; j++)
    {
        //All digits increase only but digits are same
        for (ll i = 0; i <= 8; i++)
        {
            dp[i][j] = dp[i + 1][j - 1];
        }
        //9 break in 0 and 1
        dp[9][j] = mod_add(dp[0][j - 1], dp[1][j - 1], Mod);
    }
}

void sol2()
{
    ll n, m;
    cin >> n >> m;
    vector<ll> v(10, 0);
    while (n != 0)
    {
        ll rem = n % 10;
        v[rem]++;
        n /= 10;
    }
    ll ans = 0;
    for (ll i = 0; i < 10; i++)
    {
        ll x = dp[i][m];
        ll y = v[i];
        ans = mod_add(mod_mul(x, y, Mod), ans, Mod);
    }
    p1(ans);
}

void sol()
{
    ll n, l, r, s;
    cin >> n >> l >> r >> s;
}

int main()
{
    fast;
    solve();
    test()
    {
        sol2();
    }
}
