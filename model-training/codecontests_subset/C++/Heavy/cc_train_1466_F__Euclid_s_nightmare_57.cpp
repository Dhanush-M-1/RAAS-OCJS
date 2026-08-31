/// In the name of God 
 
#include <bits/stdc++.h>
 
#define FILE_NAME "A"
 
using namespace std;
using ll = long long;
 
#define f first
#define s second 
 
#define pb push_back
#define pp pop_back
#define SZ(x) ((int) x.size())
#define all(x) x.begin(), x.end()
#define what_is(x) cerr << #x << " is " << x << endl;
 
void freekick() {
#ifndef ONLINE_JUDGE
    freopen(FILE_NAME".in", "r", stdin);
    freopen(FILE_NAME".out", "w", stdout);
#endif
}
 
const int N = 2e5 + 112;
const int INF = 1e9;
const ll MOD = 1e9 + 7;
const int DX[] = {+1, 0, -1, 0, +1, +1, -1, -1};
const int DY[] = {0, +1, 0, -1, +1, -1, +1, -1};
 
void freegoal() {
    ios_base::sync_with_stdio(false); 
    cin.tie(nullptr);   
}


struct DSU {
 
    vector<int> parent;  
    
    DSU(int n) {
        parent.resize(n, -1);
    }

    int find_set(int v) {
        if (parent[v] < 0)
            return v;
        return parent[v] = find_set(parent[v]);
    } 

    int find_set2(int v) {
        return 0 > parent[v] ? v : parent[v] = find_set2(parent[v]); 
    }

    bool unite(int a, int b) {
        a = find_set2(a);
        b = find_set2(b);
        if (a == b)
            return 0;
        if (parent[a] < parent[b]) 
            swap(a, b);
        parent[b] += parent[a];
        parent[a] = b;
        return 1;
    }
};

signed main() {
    freegoal();
    int n, m, x, y;
    cin >> n >> m;
    vector<int> result;
    DSU dsu(m + 1);
    ll answer = 1;
    for (int i = 0; i < n; i++) {
        int k;
        cin >> k;
        if (k == 1) {
            cin >> x;
            y = 0;
        } else {
            cin >> x >> y;
        }                    
        auto count_primes = [&](int n) {
        const int S = 10000;
        vector<int> primes;
        int nsqrt = sqrt(n);
        vector<char> is_prime(nsqrt + 1, true);
        for (int i = 2; i <= nsqrt; i++) {
            if (is_prime[i]) {
                primes.push_back(i);
                for (int j = i * i; j <= nsqrt; j += i)
                    is_prime[j] = false;
            }
        }
        
        int result = 0;
        vector<char> block(S);
        for (int k = 0; k * S <= n; k++) {
            fill(block.begin(), block.end(), true);
            int start = k * S;
            for (int p : primes) {
                int start_idx = (start + p - 1) / p;
                int j = max(start_idx, p) * p - start;
                for (; j < S; j += p)
                    block[j] = false;
            }
            if (k == 0)
                block[0] = block[1] = false;
            for (int i = 0; i < S && start + i <= n; i++) {
                if (block[i])
                    result++;
            }
        }
        return result;
    };     
        if (dsu.unite(x, y)) {
            result.pb(i + 1);
            answer = answer * 2;
            answer = answer % MOD;
        }
    }
    cout << answer << " " << SZ(result) << "\n";
    for (auto &r : result)
        cout << r << " ";
    cout << "\n";   
    return false;
}