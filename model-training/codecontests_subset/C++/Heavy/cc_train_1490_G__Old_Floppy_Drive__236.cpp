#include <bits/stdc++.h>
using namespace std;
string to_string(char x) {
    string re;
    re += '\'';
    re += x;
    re += '\'';
    return re;
}
template <typename A, typename B>
string to_string(pair<A, B> p);
template <typename A, typename B, typename C>
string to_string(tuple<A, B, C> p);
template <typename A, typename B, typename C, typename D>
string to_string(tuple<A, B, C, D> p);
string to_string(const string& s) {
    return '"' + s + '"';
}
string to_string(const char* s) {
    return to_string((string)s);
}
string to_string(bool b) {
    return (b ? "true" : "false");
}
string to_string(vector<bool> v) {
    bool first = true;
    string res = "{";
    for (int i = 0; i < static_cast<int>(v.size()); i++) {
        if (!first) {
            res += ", ";
        }
        first = false;
        res += to_string(v[i]);
    }
    res += "}";
    return res;
}
template <size_t N>
string to_string(bitset<N> v) {
    string res = "";
    for (size_t i = 0; i < N; i++) {
        res += static_cast<char>('0' + v[i]);
    }
    return res;
}
template <typename A>
string to_string(A v) {
    bool first = true;
    string res = "{";
    for (const auto& x : v) {
        if (!first) {
            res += ", ";
        }
        first = false;
        res += to_string(x);
    }
    res += "}";
    return res;
}
template <typename A, typename B>
string to_string(pair<A, B> p) {
    return "(" + to_string(p.first) + ", " + to_string(p.second) + ")";
}
template <typename A, typename B, typename C>
string to_string(tuple<A, B, C> p) {
    return "(" + to_string(get<0>(p)) + ", " + to_string(get<1>(p)) + ", " +
           to_string(get<2>(p)) + ")";
}
template <typename A, typename B, typename C, typename D>
string to_string(tuple<A, B, C, D> p) {
    return "(" + to_string(get<0>(p)) + ", " + to_string(get<1>(p)) + ", " +
           to_string(get<2>(p)) + ", " + to_string(get<3>(p)) + ")";
}
void debug_out() {
    cerr << endl;
}
template <typename Head, typename... Tail>
void debug_out(Head H, Tail... T) {
    cerr << " " << to_string(H);
    debug_out(T...);
}
#define LOCAL
//#undef LOCAL
#ifdef LOCAL
#define debug(...) cerr << "[" << #__VA_ARGS__ << "]:", debug_out(__VA_ARGS__)
#else
#define debug(...)
#endif
#define fi first
#define se second
#define ins insert
#define pb push_back
#define em emplace
#define eb emplace_back
#define sz(x) ((int)x.size())
#define all(x) x.begin(), x.end()
#define IOS                  \
	ios::sync_with_stdio(0); \
	cin.tie(0)
#define fk(i, a, b) for (int i = (a); i < (b); ++i)
#define fb(i, a, b) for (int i = (a); i <= (b); ++i)
#define fan(i, a, b) for (int i = (a); i >= (b); --i)
#define foreach(i, x) for (auto& i : x)
#define frei freopen("i", "r", stdin)
#define freo freopen("o", "w", stdout)
using namespace std;
using i32 = int;
using ll = long long;
using i64 = long long;
using pii = pair<int, int>;
using pll = pair<ll, ll>;
using vi = vector<int>;
using vl = vector<ll>;
using si = set<int>;
using sl = set<ll>;
using mii = map<int, int>;
using mll = map<ll, ll>;
template <typename T>
using S = set<T>;
template <typename T>
using V = vector<T>;
template <typename T>
using Q = queue<T>;
template <typename T>
using DQ = deque<T>;
template <typename T>
using ST = stack<T>;
template <typename T, typename _T>
using M = map<T, _T>;
template <typename T>
using DP = priority_queue<T, vector<T>, less<T>>;
template <typename T>
using XP = priority_queue<T, vector<T>, greater<T>>;
const char end1 = '\n';
template <typename T>
ll Min(T a) {
    return (ll)a;
}
template <typename Head, typename... Tail>
ll Min(Head H, Tail... T) {
    return min((ll)H, Min(T...));
}
template <typename T>
ll Max(T a) {
    return (ll)a;
}
template <typename Head, typename... Tail>
ll Max(Head H, Tail... T) {
    return max((ll)H, Max(T...));
}
template <typename T>
ll Gcd(T a) {
    return a;
}
template <typename Head, typename... Tail>
ll Gcd(Head H, Tail... T) {
    return __gcd((ll)H, Gcd(T...));
}
int main() {
    IOS;
    int t;
    cin >> t;
    while (t--) {
        ll n, m;
        cin >> n >> m;
        vl v(n + 1);
        fb (i, 1, n) {
            cin >> v[i];
        }
        vl sum(n + 1, 0);
        vl mx(n + 1, 0);
        fb (i, 1, n) {
            sum[i] = sum[i - 1] + v[i];
            if (i == 1) mx[i] = sum[i];
            else mx[i] = max(mx[i - 1], sum[i]);
        }
        vl ans;
        while (m--) {
            ll x;
            cin >> x;
            auto re = lower_bound(all(mx), x);
            if (re == mx.end()) {
                if (sum.back() <= 0) {
                    ans.pb(-1);
                }
                else {
                    ll sheng = x - mx.back();
                    ll lun = sheng / sum.back();
                    if (sheng % sum.back()) ++lun;
                    sheng = x - lun * sum.back();
                    
                    auto re2 = lower_bound(all(mx), sheng);
                    ans.pb(lun * n + (long long )(re2 - mx.begin() - 1));
                }
            }
            else {
                ans.pb(re - mx.begin() - 1);
            }
        }
        foreach (i, ans) {
            cout << i << ' ';
        }
        cout << end1;
    }
    return 0;
}
