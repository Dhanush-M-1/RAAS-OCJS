#include <bits/stdc++.h>
 
#define int long long
#define MOD 1000000007
 
using namespace std;
 
template <class T> ostream &operator<<(ostream &os, vector<T> V) {
    os << "[ ";
    for (auto v : V)
        os << v << " ";
    os << "]";
    return os;
}
template <class T> ostream &operator<<(ostream &os, set<T> S) {
    os << "{ ";
    for (auto s : S)
        os << s << " ";
    return os << "}";
}
template <class T> ostream &operator<<(ostream &os, multiset<T> S) {
    os << "{ ";
    for (auto s : S)
        os << s << " ";
    return os << "}";
}
template <class L, class R> ostream &operator<<(ostream &os, map<L, R> M) {
    os << "{ ";
    for (auto m : M)
        os << "(" << m.first << ":" << m.second << ") ";
    return os << "}";
}
template <class L, class R> ostream &operator<<(ostream &os, pair<L, R> P) {
    return os << "(" << P.first << "," << P.second << ")";
}

const int M = 200050;

int res[M];

void solve() {
    int n, m;
    cin >> n >> m;
    
    int num = n;
    int ans = 0;
    while(num) {
        ans += res[num % 10 + m - 1];
        num /= 10;
        ans %= MOD;
    }

    cout << ans << endl;
}


int32_t main() {
    int t = 1;
    #ifndef ONLINE_JUDGE
    freopen("input.txt", "rt", stdin);
    freopen("output.txt", "wt", stdout);
    #endif
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    vector<int> count(10, 0);
    count[0] = 1;
    for(int i = 0; i < M; i++) {
        vector<int> temp(10, 0);
        temp[0] = count[9];
        for(int j = 0; j < 9; j++) {
            temp[j + 1] = count[j];
        }
        
        temp[1] += temp[0];
        temp[1] %= MOD;
        int sum = 0;
        for(int j = 0; j < 10; j++) {
            count[j] = temp[j];
            sum += count[j];
            sum %= MOD;
        }

        res[i] = sum;
    }



    cin >> t;
    while(t--) {
        solve();
    }
#ifndef ONLINE_JUDGE
    cout << "\nTime Elapsed : " << 1000 * (long double)clock() / (long double)CLOCKS_PER_SEC << " ms\n";
#endif
    return 0;
}